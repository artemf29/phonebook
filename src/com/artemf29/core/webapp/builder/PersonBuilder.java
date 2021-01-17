package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Person;
import com.artemf29.core.webapp.contacts.object.Gender;

import java.util.Objects;

public class PersonBuilder extends ContactBuilder {
    private Gender gender;

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Contact create() {
        return uuid.equals("No") ?
                new Person(name, phoneNumber, createDate, updateDate, gender) : new Person(uuid, name, phoneNumber, updateDate, createDate, gender);
    }

}
