package com.artemf29.core.webapp.contacts.object;

public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
