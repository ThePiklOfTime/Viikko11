package com.example.Viikko11;

import java.util.ArrayList;

public class ContactStorage {

    public ArrayList<Contact> contacts = new ArrayList<>();
    private static ContactStorage contactStorage;

    public static ContactStorage getInstance(){
        if (contactStorage == null) {
            contactStorage = new ContactStorage();
        }
        return contactStorage;
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void removeContact(int id){
        contacts.remove(id);
    }

}
