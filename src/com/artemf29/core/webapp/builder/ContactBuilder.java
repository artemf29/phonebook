package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

abstract public class ContactBuilder implements Builder {
    protected String name;
    protected PhoneNumber phoneNumber;
    protected String uuid = "No";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM y'г.'(HH'ч.'mm'мин.')");
    protected String createDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    protected String updateDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber.checkNumber(phoneNumber.getNumber()));
    }

    @Override
    public void setCreateDate() {
        this.createDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    @Override
    public void setCreateDate(String date) {
        this.createDate = date;
    }

    @Override
    public void setUpdateDate() {
        this.updateDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    @Override
    public void setUpdateDate(String date) {
        this.updateDate = date;
    }

}
