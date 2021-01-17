package com.artemf29.core.webapp.storage;

import com.artemf29.core.webapp.Config;

public class SqlStorageTest extends ContactStorageTest{
        public SqlStorageTest() {
            super(Config.get().getStorage());
        }
    }

