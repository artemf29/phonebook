package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.builder.OrganizationBuilder;
import com.artemf29.core.webapp.builder.PersonBuilder;
import com.artemf29.core.webapp.contacts.Organization;
import com.artemf29.core.webapp.contacts.Person;
import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public class ContactsTestData {
    public static final OrganizationBuilder organizationBuilder = new OrganizationBuilder();
    public static final PersonBuilder personBuilder = new PersonBuilder();
    public static final Organization organization, organization2;
    public static final Person person, person2;

    static {
        organizationBuilder.setName("Test1");
        organizationBuilder.setNumber(new PhoneNumber("+79117987987"));
        organizationBuilder.setInfo("TestData");
        organizationBuilder.setCreateDate();
        organizationBuilder.setUpdateDate();
        organization = (Organization) organizationBuilder.create();

        personBuilder.setName("Test2");
        personBuilder.setNumber(new PhoneNumber("fkeofdokeokdok"));
        personBuilder.setGender(Gender.MALE);
        personBuilder.setCreateDate();
        personBuilder.setUpdateDate();
        person = (Person) personBuilder.create();

        organizationBuilder.setName("Test3");
        organizationBuilder.setNumber(new PhoneNumber("+00000000000"));
        organizationBuilder.setInfo("TestData3");
        organizationBuilder.setCreateDate();
        organizationBuilder.setUpdateDate();
        organization2 = (Organization) organizationBuilder.create();

        personBuilder.setName("Test4");
        personBuilder.setNumber(new PhoneNumber("+7857578575"));
        personBuilder.setGender(Gender.FEMALE);
        personBuilder.setCreateDate();
        personBuilder.setUpdateDate();
        person2 = (Person) personBuilder.create();
    }
}
