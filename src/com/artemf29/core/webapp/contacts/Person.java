package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.util.Objects;

public class Person extends Contact {
    private final Gender gender;

    public Person(String name, PhoneNumber phoneNumber,String createDate,String updateDate, Gender gender) {
        super(name, phoneNumber, createDate, updateDate);
        this.gender = gender;
    }

    public Person(String uuid, String name, PhoneNumber phoneNumber, String createDate,String updateDate, Gender gender) {
        super(uuid, name, phoneNumber,createDate,updateDate);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
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

    @Override
    public String toString() {
        return "Имя: " + name + '\n' +
                "Номер: " + phoneNumber.toString() + '\n' +
                "Пол: " + gender.getGender() + '\n' +
                "Дата создания: " + createDate + '\n' +
                "Дата изменения: " + updateDate;
    }
}
