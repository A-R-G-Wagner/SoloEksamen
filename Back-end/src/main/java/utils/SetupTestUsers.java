package utils;

import entities.FavColor;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        User dummy1 = new User("dummy1", "dummyPW");
        User dummy2 = new User("dummy2", "dummyPW");
        User user = new User("user", "userPW");
        User admin = new User("admin", "adminPW");
        User both = new User("user_admin", "user_adminPW");

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
            throw new UnsupportedOperationException("You have not changed the passwords");
        }

        em.getTransaction().begin();
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        FavColor yellow = new FavColor("yellow");
        FavColor white = new FavColor("white");
        FavColor green = new FavColor("green");
        FavColor red = new FavColor("red");

        user.addRole(userRole);
        yellow.AddUser(user);
        yellow.AddUser(dummy2);
        red.AddUser(dummy1);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        dummy1.addRole(userRole);
        dummy2.addRole(userRole);
        
        em.persist(userRole);
        em.persist(adminRole);
        
        em.persist(green);
        em.persist(white);
        em.persist(red);
        em.persist(yellow);
        
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.persist(dummy1);
        em.persist(dummy2);
       
        em.getTransaction().commit();
        System.out.println("PW: " + user.getUserPass());
        System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
        System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
        System.out.println("Created TEST Users");

    }

}
