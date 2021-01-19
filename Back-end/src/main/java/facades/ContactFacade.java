/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.ContactDTO;
import dtos.ContactsDTO;
import entities.Contact;
import entities.Opportunity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alex Wagner
 */
public class ContactFacade {

    private static ContactFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    public static ContactFacade getContactFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ContactFacade();
        }
        return instance;
    }

    public List<Contact> findContacts2() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contact> q = em.createQuery("SELECT c FROM Contact c", Contact.class);
        List<Contact> l = q.getResultList();
        return l;
    }

    public List<ContactDTO> findContacts() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contact> q = em.createQuery("SELECT c FROM Contact c", Contact.class);
        ContactsDTO c = new ContactsDTO();
        List<Contact> l = q.getResultList();
        for (int i = 0; i < l.size(); i++) {
            c.addToContacts(new ContactDTO(l.get(i)));
        }
        return c.getAllContacts();
    }

    public ContactDTO findContactById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Contact> q = em.createQuery("SELECT c FROM Contact c WHERE c.id = :id", Contact.class);
            q.setParameter("id", id);
            return new ContactDTO(q.getSingleResult());
        } finally {
            em.close();
        }

    }

    public ContactDTO addContact(ContactDTO c) {
        EntityManager em = emf.createEntityManager();
        Contact contact = new Contact(c.getName(), c.getEmail(), c.getCompany(), c.getJobtitle(), c.getPhone());

        try {
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            em.close();
        }

        return c;
    }

    public ContactDTO editContact(ContactDTO c) {
        EntityManager em = emf.createEntityManager();
        Contact c2 = em.find(Contact.class, c.getId());

        c2.setName(c.getName());
        c2.setJobtitle(c.getJobtitle());
        c2.setCompany(c.getCompany());
        c2.setPhone(c.getPhone());
        c2.setEmail(c.getEmail());

        try {
            em.getTransaction().begin();
            em.merge(c2);
            em.getTransaction().commit();
            return new ContactDTO(c2);
        } finally {
            em.close();
        }
    }

}//class
