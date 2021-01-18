/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ContactDTO;
import dtos.ContactsDTO;
import entities.Contact;
import entities.Opportunity;
import facades.ContactFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Alex Wagner
 */
@Path("contact")
public class ContactResource {

    @Context
    private UriInfo context;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final ContactFacade FACADE = ContactFacade.getContactFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ContactResource() {
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String findContacts() {
        List<ContactDTO> result = FACADE.findContacts();
        return GSON.toJson(result);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findContactById(@PathParam("id") int id) {
        ContactDTO result = FACADE.findContactById(id);
        return GSON.toJson(result);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addContact(String contact) {
        ContactDTO c = GSON.fromJson(contact, ContactDTO.class);
        ContactDTO newContact = FACADE.addContact(c);
        return GSON.toJson(newContact);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
