package com.artemf29.core.webapp.contacts.object;

import java.util.Objects;
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
            return "******";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = checkNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return number.equals(that.number) && Objects.equals(pattern, that.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, pattern);
    }
}
