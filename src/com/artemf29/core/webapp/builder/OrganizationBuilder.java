package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Organization;

public class OrganizationBuilder extends ContactBuilder {
    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public Contact create() {
        Organization organization = new Organization(name,phoneNumber,info);
        return organization;
    }
}
