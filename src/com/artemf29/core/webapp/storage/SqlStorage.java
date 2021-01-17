package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.builder.ContactBuilder;
import com.artemf29.core.webapp.builder.OrganizationBuilder;
import com.artemf29.core.webapp.builder.PersonBuilder;
import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Organization;
import com.artemf29.core.webapp.contacts.Person;
import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;
import com.artemf29.core.webapp.sql.SqlHelper;

import java.sql.*;

public class SqlStorage implements ContactStorage {
    private final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void create(Contact contact) {
        sqlHelper.<Void>transactionalExecute(connection -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into contacts(uuid, name, create_date, update_date) values (?,?,?,?)"
            )) {
                preparedStatement.setString(1, contact.getUuid());
                preparedStatement.setString(2, contact.getName());
                preparedStatement.setString(3, contact.getCreateDate());
                preparedStatement.setString(4, contact.getUpdateDate());
                preparedStatement.execute();
            }
            insertNumber(connection, contact);
            insertInfo(connection, contact);
            return null;
        });
    }

    @Override
    public Contact get(String uuid) {

        return sqlHelper.transactionalExecute(connection -> {
            int numberType;
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from  contact_info where contact_uuid=?")) {
                preparedStatement.setString(1, uuid);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    throw new RuntimeException(uuid);
                }
                numberType = resultSet.getInt("type_contact_id");
            }
            return numberType == 1 ? getPerson(connection, uuid) : getOrganization(connection, uuid);
        });
    }

    @Override
    public void update(Contact contact) {
        sqlHelper.<Void>transactionalExecute(connection -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "update contacts set name = ?, create_date = ?, update_date = ? where uuid = ?"
            )) {
                preparedStatement.setString(1, contact.getName());
                preparedStatement.setString(2, contact.getCreateDate());
                preparedStatement.setString(3, contact.getUpdateDate());
                preparedStatement.setString(4, contact.getUuid());
                if (preparedStatement.executeUpdate() != 1) {
                    throw new RuntimeException(contact.getUuid());
                }
            }
            deleteNumber(connection, contact);
            deleteInfo(connection, contact);
            insertNumber(connection, contact);
            insertInfo(connection, contact);
            return null;
        });
    }

    @Override
    public void delete(String uuid) {
        sqlHelper.<Void>execute("delete from contacts where uuid =?", preparedStatement -> {
            preparedStatement.setString(1, uuid);
            if (preparedStatement.executeUpdate() == 0) {
                throw new RuntimeException(uuid);
            }
            return null;
        });
    }

    @Override
    public void clear() {
        sqlHelper.execute("delete from contacts");
    }

    @Override
    public int size() {
        return sqlHelper.execute("select count(*) from contacts", preparedStatement -> {
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? resultSet.getInt(1) : 0;
        });
    }

    @Override
    public Contact find(String searchWord) {
        return null;
    }

    private void insertNumber(Connection connection, Contact contact) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into phone_number(contact_uuid, number) values (?,?)"
        )) {
            preparedStatement.setString(1, contact.getUuid());
            preparedStatement.setString(2, contact.getPhoneNumber().toString());
            preparedStatement.execute();
        }
    }

    private void insertInfo(Connection connection, Contact contact) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into contact_info(contact_uuid, type_contact_id, do_action) values (?,?,?)"
        )) {
            preparedStatement.setString(1, contact.getUuid());
            preparedStatement.setInt(2, typeSpecifier(contact));
            preparedStatement.setString(3, typeInfoSpecifier(contact));
            preparedStatement.execute();
        }
    }

    private void deleteNumber(Connection connection, Contact contact) throws SQLException {
        deleteNumberAndInfo(connection, contact, "delete from phone_number where contact_uuid=?");
    }

    private void deleteInfo(Connection connection, Contact contact) throws SQLException {
        deleteNumberAndInfo(connection, contact, "delete from contact_info where contact_uuid=?");
    }

    private void deleteNumberAndInfo(Connection connection, Contact contact, String sql) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, contact.getUuid());
            preparedStatement.execute();
        }
    }

    private Contact getOrganization(Connection connection, String uuid) throws SQLException {
        OrganizationBuilder organizationBuilder = new OrganizationBuilder();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from  contacts where uuid=?")) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException(uuid);
            }
            organizationBuilder.setUuid(uuid);
            organizationBuilder.setName(resultSet.getString("name"));
            organizationBuilder.setCreateDate(resultSet.getString("create_date"));
            organizationBuilder.setUpdateDate(resultSet.getString("update_date"));
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from phone_number where contact_uuid=?")) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException(uuid);
            }
            organizationBuilder.setNumber(new PhoneNumber(resultSet.getString("number")));
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from contact_info where contact_uuid=?")) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException(uuid);
            }
            organizationBuilder.setInfo(resultSet.getString("do_action"));
        }
        return organizationBuilder.create();
    }

    private Contact getPerson(Connection connection, String uuid) throws SQLException {
        PersonBuilder personBuilder = new PersonBuilder();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from  contacts where uuid=?")) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException(uuid);
            }
            personBuilder.setUuid(uuid);
            personBuilder.setName(resultSet.getString("name"));
            personBuilder.setCreateDate(resultSet.getString("create_date"));
            personBuilder.setUpdateDate(resultSet.getString("update_date"));
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from phone_number where contact_uuid=?")) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException(uuid);
            }
            personBuilder.setNumber(new PhoneNumber(resultSet.getString("number")));
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from contact_info where contact_uuid=?")) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException(uuid);
            }
            personBuilder.setGender(Gender.valueOf(resultSet.getString("do_action")));
        }
        return personBuilder.create();
    }

    private int typeSpecifier(Contact contact) {
        return contact instanceof Person ? 1 : 2;
    }

    private String typeInfoSpecifier(Contact contact) {
        return contact instanceof Person ?
                ((Person) contact).getGender().name() : ((Organization) contact).getInfo();
    }
}
