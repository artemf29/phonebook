package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.util.Objects;

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
        Objects.requireNonNull(gender, "gender must not be null");
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gender);
    }
}
