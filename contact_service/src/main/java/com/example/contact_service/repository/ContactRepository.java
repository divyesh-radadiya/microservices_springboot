package com.example.contact_service.repository;

import com.example.contact_service.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, Long> {
}
