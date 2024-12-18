package com.contact.form.service;

import com.contact.form.entity.Contact;
import com.contact.form.request.ContactRequest;

public interface ContactInterface {
    Contact saveContact(ContactRequest contactRequest);
}
