package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contact {
    protected String name;
    protected PhoneNumber phoneNumber;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM y'г.' \n (HH'ч.'mm'мин.')");
    private final String createDate;
    protected String updateDate;

    public Contact(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        this.updateDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    protected void setUpdateDate() {
        updateDate = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }
}
