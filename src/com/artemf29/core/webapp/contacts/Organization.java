package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Organization that = (Organization) o;
        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), info);
    }
}

