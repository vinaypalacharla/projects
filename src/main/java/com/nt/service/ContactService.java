package com.nt.service;

import java.util.List;


import com.nt.pojo.Contact;

public interface ContactService {
public boolean contactSave(Contact contact);
public List<Contact> getAllContacts();
public Contact findById(Integer id);
public void deleteContact(Integer id);
}
