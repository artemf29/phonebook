package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Organization;

import java.util.Objects;

public class OrganizationBuilder extends ContactBuilder {
    private String info;

    public void setInfo(String info) {
        this.info = info == null ? "not found" : info;
    }

    @Override
    public Contact create() {
        return uuid.equals("No") ?
                new Organization(name, phoneNumber, createDate, updateDate, info) : new Organization(uuid, name, phoneNumber, createDate, updateDate, info);
    }

}
