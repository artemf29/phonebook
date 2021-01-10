package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Organization;

public class OrganizationBuilder extends ContactBuilder {
    private String info;

    void setInfo(String info) {
        this.info = info;
    }

    @Override
    public Contact create() {
        Organization organization = new Organization();
        organization.setName(name);
        organization.setPhoneNumber(phoneNumber);
        organization.setCreateDate(localDate);
        organization.setInfo(info);
        return organization;
    }
}
