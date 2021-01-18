import React, { useState, useEffect } from 'react';
import { Form, Button } from "react-bootstrap";
import facade from "./apiFacade";

const NewContact = () => {
    const init = { name: "", jobtitle: "", company: "", phone: "", email: "" };
    const [newContact, setNewContact] = useState(init);

    const handleChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        setNewContact({ ...newContact, [name]: value })
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        window.alert("New Contact added: ", JSON.stringify(newContact))
        facade.newContact(...newContact, newContact.name, newContact.jobtitle, newContact.company, newContact.phone, newContact.email);
    }


    return (
        <div>
            <h3>New Contact</h3><br />
            <Form onChange={handleChange} onSubmit={handleSubmit}>
                <input placeholder="Contact Name" name="name" /><br />
                <input placeholder="Jobtitle" name="newJob" /><br />
                <input placeholder="Company" name="NewCompany" /><br />
                <input placeholder="Phone" name="newPhone" /><br />
                <input placeholder="Email" name="newEmail" /><br /><br />
                <Button variant="dark" type="submit">Create Contact</Button>


            </Form>
            <p>{JSON.stringify(newContact)}</p>
        </div>
    );
}


export default NewContact;






