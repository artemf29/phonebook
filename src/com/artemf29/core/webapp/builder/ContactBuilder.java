package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.time.LocalDate;

abstract class ContactBuilder implements Builder {
    protected String name;
    protected LocalDate localDate;
    protected PhoneNumber phoneNumber;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public void setNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
