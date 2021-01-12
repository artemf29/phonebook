package com.artemf29.core.webapp;

import com.artemf29.core.webapp.builder.OrganizationBuilder;
import com.artemf29.core.webapp.builder.PersonBuilder;
import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public class Main {

    public static void main(String[] args) {

        OrganizationBuilder organizationBuilder = new OrganizationBuilder();
        PersonBuilder personBuilder = new PersonBuilder();

        organizationBuilder.setName("SPS");
        organizationBuilder.setNumber(new PhoneNumber("79692017447"));
        organizationBuilder.setInfo("Organization");

        Contact organization = organizationBuilder.create();

        personBuilder.setName("Artem");
        personBuilder.setNumber(new PhoneNumber("791173+-*"));
        personBuilder.setGender(Gender.MALE);

        Contact person = personBuilder.create();

        System.out.println(person.toString());
        System.out.println();
        System.out.println(organization.toString());
    }
}