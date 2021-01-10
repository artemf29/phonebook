package com.artemf29.core.webapp.contacts.object;

import java.util.regex.Pattern;

public class PhoneNumber {
    private String number;
    private final Pattern pattern =
            //временный RegEx, взято из https://habr.com/ru/post/110731/
            Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");

    public PhoneNumber(String number) {
        this.number = checkNumber(number);
    }

    public String checkNumber(String number) {
        if (pattern.matcher(number).matches()) {
            return number;
        } else
            return "missing";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = checkNumber(number);
    }
}
