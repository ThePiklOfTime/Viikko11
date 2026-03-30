package com.example.Viikko11;

public class Contact {
   private String firstName;
   private String lastName;
   private String number;

    public Contact(String firstName, String lastName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.contactGroup = contactGroup;
    }

    private String contactGroup;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getFullName() {
        String fll = this.firstName + " "  + this.lastName;
        return fll;
    }

    public String getContactGroup() {
        return contactGroup;
    }




}
