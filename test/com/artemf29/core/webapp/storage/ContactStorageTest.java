package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.contacts.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.artemf29.core.webapp.storage.ContactsTestData.*;
import static com.artemf29.core.webapp.storage.ContactsTestData.organization;
import static org.junit.jupiter.api.Assertions.*;

    public abstract class ContactStorageTest {
        ContactStorage contactStorage;

        public ContactStorageTest(ContactStorage contactStorage) {
            this.contactStorage = contactStorage;
        }

        @BeforeEach
        public void setUp() {
            contactStorage.clear();
            contactStorage.create(organization);
            contactStorage.create(person);
            contactStorage.create(organization2);
        }

        @Test
        public void create() {
            contactStorage.create(person2);
            assertSize(4);
            assertGet(person2);
        }

        @Test
        public void get() {
            assertGet(organization);
            assertGet(person);
            assertGet(organization2);
        }

        @Test
        public void update() {
            contactStorage.update(organization);
            assertEquals(organization,contactStorage.get(organization.getUuid()));
        }

        @Test
        public void delete() {
            contactStorage.delete(organization.getUuid());
            assertSize(2);
        }

        @Test
        public void size() {
            assertSize(3);
        }

        @Test
        public void clear() {
            contactStorage.clear();
            assertSize(0);
        }

        private void assertSize(int size) {
            assertEquals(size, contactStorage.size());
        }

        private void assertGet(Contact contact) {
            assertEquals(contact, contactStorage.get(contact.getUuid()));
        }
    }
