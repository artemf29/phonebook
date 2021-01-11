package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public interface Builder {

    void setName(String name);

    void setNumber(PhoneNumber phoneNumber);

    Contact create();
}
