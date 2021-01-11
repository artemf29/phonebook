package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public class Organization extends Contact {
    private String info;

    public Organization(String name, PhoneNumber phoneNumber, String info) {
        super(name, phoneNumber);
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
