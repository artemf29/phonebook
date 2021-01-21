package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Person;
import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public class PersonBuilder extends ContactBuilder {
    private Gender gender;

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Contact create() {
        return uuid.equals("No") ?
                new Person(name, phoneNumber, createDate, updateDate, gender) : new Person(uuid, name, phoneNumber, updateDate, createDate, gender);
    }

    public Contact createNull(String uuid){
        return new Person(uuid,"",new PhoneNumber(""),createDate,updateDate,Gender.MALE);
    }
    public Contact createNull(){
        return new Person("",new PhoneNumber(""),createDate,updateDate,Gender.MALE);
    }

}
