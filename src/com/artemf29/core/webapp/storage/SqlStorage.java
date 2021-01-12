package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.contacts.Contact;

public class SqlStorage implements ContactStorage {
    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
    }

    @Override
    public void create(Contact contact) {

    }

    @Override
    public Contact get(String uuid) {
        return null;
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Contact find(String searchWord) {
        return null;
    }
}
