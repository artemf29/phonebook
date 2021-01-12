package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.contacts.Contact;

public interface ContactStorage {

    void create(Contact contact);

    Contact get(String uuid);

    void update(Contact contact);

    void delete(String uuid);

    void clear();

    int size();

    Contact find(String searchWord);

}
