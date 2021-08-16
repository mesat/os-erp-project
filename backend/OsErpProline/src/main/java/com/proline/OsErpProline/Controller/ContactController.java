package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.ContactRepository;
import com.proline.OsErpProline.entity.Contact;
import com.proline.OsErpProline.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {
    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contact")
    List<Contact> all() {
        return contactRepository.findAll();
    }
}
