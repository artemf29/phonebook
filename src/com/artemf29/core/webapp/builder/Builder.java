package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

import java.time.LocalDate;

public interface Builder {

    void setName(String name);

    void setDate(LocalDate localDate);

    void setNumber(PhoneNumber phoneNumber);

    Contact create();
}
