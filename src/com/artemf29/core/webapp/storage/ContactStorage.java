package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.contacts.Contact;

import java.util.List;

public interface ContactStorage {

    void create(Contact contact);

    Contact get(String uuid);

    void update(Contact contact);

    void delete(String uuid);

    List<Contact> getAll();

    void clear();

    int size();

    Contact find(String searchWord);


}
