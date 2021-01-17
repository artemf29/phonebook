package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.util.Objects;

public class Organization extends Contact {
    private final String info;

    public Organization(String name, PhoneNumber phoneNumber,String createDate,String updateDate, String info) {
        super(name, phoneNumber,createDate,updateDate);
        this.info = info;
    }

    public Organization(String uuid, String name, PhoneNumber phoneNumber,String createDate,String updateDate, String info) {
        super(uuid, name, phoneNumber,createDate,updateDate);
        this.info = info;
    }

    public String getInfo() {
        return info;
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

    @Override
    public String toString() {
        return "Название организации: " + name + '\n' +
                "Номер: " + phoneNumber.toString() + '\n' +
                "Информация: " + info + '\n' +
                "Дата создания: " + createDate + '\n' +
                "Дата изменения: " + updateDate;
    }
}

