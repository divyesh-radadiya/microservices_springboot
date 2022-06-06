package com.example.contact_service.service;

import com.example.contact_service.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getContactsOfUser(Long userId);
    public Contact setContactsOfUser(Contact contact);

}
