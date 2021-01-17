package com.artemf29.core.webapp;

import com.artemf29.core.webapp.builder.OrganizationBuilder;
import com.artemf29.core.webapp.builder.PersonBuilder;
import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;
import com.artemf29.core.webapp.storage.SqlStorage;

public class Main {

    public static void main(String[] args) {
        SqlStorage storage = new SqlStorage(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

        PersonBuilder personBuilder = new PersonBuilder();
        OrganizationBuilder organizationBuilder = new OrganizationBuilder();

        for (int i = 0; i < 100; i++) {
            personBuilder.setName("Name " + i);
            personBuilder.setNumber(new PhoneNumber("+78975" + i * 1230));
            personBuilder.setGender(i % 2 == 0 ? Gender.MALE : Gender.FEMALE);
            personBuilder.setCreateDate();
            personBuilder.setUpdateDate();

            storage.create(personBuilder.create());

            organizationBuilder.setName("Organization" + i);
            organizationBuilder.setNumber(new PhoneNumber("+7991254" + i * 1000));
            organizationBuilder.setInfo("Info № " + i);
            organizationBuilder.setCreateDate();
            organizationBuilder.setUpdateDate();

            storage.create(organizationBuilder.create());
        }


    }
}