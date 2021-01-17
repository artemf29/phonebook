package com.artemf29.core.webapp.contacts.object;

import com.artemf29.core.webapp.contacts.Contact;

import java.util.Objects;
import java.util.regex.Pattern;

public class PhoneNumber implements Comparable<PhoneNumber>{
    private String number;
    private final Pattern PATTERN =
            //временный RegEx, взято из https://habr.com/ru/post/110731/
            Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String checkNumber(String number) {
        if (PATTERN.matcher(number).matches()) {
            return number;
        } else
            return "not found";
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
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return number.compareTo(o.number);
    }
}
