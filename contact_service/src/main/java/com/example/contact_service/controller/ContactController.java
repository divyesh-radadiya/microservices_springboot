package com.example.contact_service.controller;

import com.example.contact_service.entity.Contact;
import com.example.contact_service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @RequestMapping("/user/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") Long userId) {
        return this.contactService.getContactsOfUser(userId);
    }

    @PostMapping("/")
    public Contact addContacts(@RequestBody Contact contact) {
        return this.contactService.setContactsOfUser(contact);
    }

}
