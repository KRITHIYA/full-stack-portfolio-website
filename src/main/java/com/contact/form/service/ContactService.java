package com.contact.form.service;

import com.contact.form.entity.Contact;
import com.contact.form.repository.ContactRepository;
import com.contact.form.request.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements ContactInterface{
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact saveContact(ContactRequest contactRequest) {
        Contact contact=new Contact();
        contact.setFirstname(contactRequest.getFirstname());
        contact.setLastname(contactRequest.getLastname());
        contact.setEmail(contactRequest.getEmail());
        contact.setMessage(contactRequest.getMessage());
        return contactRepository.save(contact);
    }
}
