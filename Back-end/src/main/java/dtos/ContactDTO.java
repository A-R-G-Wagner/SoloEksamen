/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Contact;

/**
 *
 * @author Alex Wagner
 */
public class ContactDTO {
    

    private Long id;
    private String name;
    private String email;
    private String company;
    private String jobtitle;
    private String phone;

    public ContactDTO(String name, String email, String company, String jobtitle, String phone) {
        
        this.name = name;
        this.email = email;
        this.company = company;
        this.jobtitle = jobtitle;
        this.phone = phone;
    }

    public ContactDTO(Contact c){
        this.id = c.getId();
        this.name = c.getName();
        this.email = c.getEmail();
        this.company = c.getCompany();
        this.jobtitle = c.getJobtitle();
        this.phone = c.getPhone();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
