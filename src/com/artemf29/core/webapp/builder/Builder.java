package com.artemf29.core.webapp.builder;

import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;

public interface Builder {
    void setUuid(String uuid);

    void setName(String name);

    void setNumber(PhoneNumber phoneNumber);

    void setCreateDate();

    void setCreateDate(String date);

    void setUpdateDate();

    void setUpdateDate(String date);

    Contact create();


}
