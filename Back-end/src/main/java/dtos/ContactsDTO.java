/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Wagner
 */
public class ContactsDTO {

    List<ContactDTO> allContacts = new ArrayList();

    public ContactsDTO() {
    }
    
//    private ContactsDTO(List<Contact> c){
//        c.forEach((contact) -> {
//        allContacts.add(new ContactDTO(contact));
//    });
//    }

    public List<ContactDTO> getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(List<ContactDTO> allContacts) {
        this.allContacts = allContacts;
    }
    
    public void addToContacts(ContactDTO c){
        this.allContacts.add(c);
    }

}
