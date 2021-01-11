package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public class Person extends Contact {
    private Gender gender;

    public Person(String name, PhoneNumber phoneNumber, Gender gender) {
        super(name, phoneNumber);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
