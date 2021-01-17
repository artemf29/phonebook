package com.artemf29.core.webapp;

import com.artemf29.core.webapp.storage.ContactStorage;
import com.artemf29.core.webapp.storage.SqlStorage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String PROPERTIESPATH = "/Contacts.properties";
    private static final Config INSTANCE = new Config();

    private final ContactStorage storage;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream inputStream = Config.class.getResourceAsStream(PROPERTIESPATH)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            storage = new SqlStorage(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file" + PROPERTIESPATH);
        }
    }

    public ContactStorage getStorage() {
        return storage;
    }
}
