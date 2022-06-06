package com.example.contact_service.service;

import com.example.contact_service.entity.Contact;
import com.example.contact_service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    //fake list of contacts

    List<Contact> list = List.of(
            new Contact(1L, "amit@gmail.com", "Amit", 1311L),
            new Contact(2L, "anil@gmail.com", "Anil", 1311L),
            new Contact(3L, "rohan@gmail.com", "Rohan", 1312L),
            new Contact(4L, "sameer@gmail.com", "Sameer", 1314L)
    );

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        Contact contact = new Contact();
        contact.setUserId(userId);
        Example<Contact> example = Example.of(contact);
        return contactRepository.findAll(example);
    }

    @Override
    public Contact setContactsOfUser(Contact contact) {
                return contactRepository.save(contact);
    }
}
