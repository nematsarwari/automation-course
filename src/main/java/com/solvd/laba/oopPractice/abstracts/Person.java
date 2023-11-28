package com.solvd.laba.oopPractice.abstracts;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.interfaces.Printable;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public abstract class Person implements Printable {
    protected String firstName;
    protected String lastName;
    protected long phoneNumber;

    public Person(String firstName, String lastName, long phoneNumber) throws InvalidPersonException {
        if (firstName == null || StringUtils.isEmpty(firstName) || lastName == null || StringUtils.isEmpty(lastName)) {
            throw new InvalidPersonException("Invalid " + this.getClass().getSimpleName() + ": First name and last name.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public final String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public final long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "Person [name=" + firstName + ", age=" + lastName + "]";
    }
}
