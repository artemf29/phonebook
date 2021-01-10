package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Person;
import com.artemf29.core.webapp.contacts.object.Gender;

public class PersonBuilder extends ContactBuilder {
    private Gender gender;

    void setGender(Gender gender) {
        this.gender = gender;
    }

    public Contact create() {
        Person person = new Person();
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
        person.setCreateDate(localDate);
        person.setGender(gender);
        return person;
    }
}
