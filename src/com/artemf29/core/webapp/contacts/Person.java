package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.Gender;

public class Person extends Contact {
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
