package com.contact.form.controller;

import com.contact.form.entity.Contact;
import com.contact.form.request.ContactRequest;
import com.contact.form.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/form")
public class ContactController {
    @Autowired
    ContactService contactService;

//    @GetMapping("/contact")
//    public String showForm(Model model) {
//        model.addAttribute("contact", new ContactRequest());  // Make sure the model attribute name matches what's used in the template
//        return "contact";
//    }
//
//    @PostMapping("/contact")
//    public String submitContactForm(@ModelAttribute ContactRequest contactRequest) {
//        Contact savedContact = contactService.saveContact(contactRequest);
//        return "submitsuccess";
//    }
}



