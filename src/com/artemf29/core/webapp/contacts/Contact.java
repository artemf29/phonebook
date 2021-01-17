package com.artemf29.core.webapp.contacts;

import com.artemf29.core.webapp.contacts.object.PhoneNumber;
import java.util.Objects;
import java.util.UUID;

public abstract class Contact implements Comparable<Contact> {
    private final String uuid;
    protected String name;
    protected PhoneNumber phoneNumber;
    protected final String createDate;
    protected String updateDate;

    public Contact(String name, PhoneNumber phoneNumber, String createDate, String updateDate) {
        this(UUID.randomUUID().toString(), name, phoneNumber, createDate, updateDate);
    }

    public Contact(String uuid, String name, PhoneNumber phoneNumber, String createDate, String updateDate) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(phoneNumber, "phone number must not be null");
        this.uuid = uuid;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return uuid.equals(contact.uuid) && name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber) && createDate.equals(contact.createDate) && updateDate.equals(contact.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, phoneNumber, createDate, updateDate);
    }

    @Override
    public int compareTo(Contact o) {
        int compareName = name.compareTo(o.name);
        return compareName != 0 ? compareName : uuid.compareTo(o.uuid);
    }
}
