package com.contact.form.controller;

import com.contact.form.entity.Contact;
import com.contact.form.request.ContactRequest;
import com.contact.form.request.OrderRequest;
import com.contact.form.service.ContactService;
import com.contact.form.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PageController {
    @Autowired
    ContactService contactService;
    @Autowired
    OrderService orderService;

    @GetMapping("/main")
    public String mainPage() {
        return "main"; // Loads mainpage.html
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // Loads about.html
    }

    @GetMapping("/portfolio")
    public String portfolioPage() {
        return "portfolio"; // Loads portfolio.html
    }

    @GetMapping("/services")
    public String servicesPage() {
        return "services"; // Loads services.html
    }
    @GetMapping("/service1")
    public String service1Page() {
        return "service1"; // Loads services.html
    }
    @GetMapping("/service2")
    public String service2Page() {
        return "service2"; // Loads services.html
    }
    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("contact", new ContactRequest());  // Make sure the model attribute name matches what's used in the template
        return "contact";
    }
    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute ContactRequest contactRequest) {
        Contact savedContact = contactService.saveContact(contactRequest);
        return "submitsuccess";
    }

}