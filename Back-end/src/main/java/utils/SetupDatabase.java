/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Contact;
import entities.Task;
import entities.TaskStatus;
import entities.TaskType;
import entities.OpportunityStatus;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alex Wagner
 */
public class SetupDatabase {

    public static void main(String[] args) throws IOException {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Task t1 = new Task();
        
        Contact c1 = new Contact("DummyAlpha","DummyMailA","DummyCO","DummySr", "44505011");
        Contact c2 = new Contact("DummyBeta","DummyMailB","DummyCO","DummyJr", "44505022");
        
        OpportunityStatus os1 = new OpportunityStatus("Active");
        OpportunityStatus os2 = new OpportunityStatus("Inactive");
        OpportunityStatus os3 = new OpportunityStatus("Won");
        OpportunityStatus os4 = new OpportunityStatus("Lost");
        
        TaskType tt1 = new TaskType("Online");
        TaskType tt2 = new TaskType("Meeting");
        TaskType tt3 = new TaskType("Email");
        TaskType tt4 = new TaskType("Call");

        TaskStatus ts1 = new TaskStatus("Non Started");
        TaskStatus ts2 = new TaskStatus("In Progress");
        TaskStatus ts3 = new TaskStatus("Complete");

        //tt1.AddTask(t1);
        //ts1.AddTask(t1);

        em.persist(c1);
        em.persist(c2);
        
        em.persist(os1);
        em.persist(os2);
        em.persist(os3);
        em.persist(os4);
        
        em.persist(tt1);
        em.persist(tt2);
        em.persist(tt3);
        em.persist(tt4);

        em.persist(ts1);
        em.persist(ts2);
        em.persist(ts3);

       // em.persist(t1);

        em.getTransaction().commit();

    }

}
