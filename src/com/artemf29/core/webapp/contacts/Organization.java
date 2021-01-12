package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.util.Objects;

public class Organization extends Contact {
    private String info;

    public Organization(String name, PhoneNumber phoneNumber, String info) {
        super(name, phoneNumber);
        setInfo(info);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? "not found" : info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Organization that = (Organization) o;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), info);
    }

    @Override
    public String toString() {
        return "Название организации: " + name + '\n' +
                "Номер: " + phoneNumber.toString() + '\n' +
                "Информация: " + info + '\n' +
                "Дата создания: " + createDate + '\n' +
                "Дата изменения: " + updateDate;
    }
}

