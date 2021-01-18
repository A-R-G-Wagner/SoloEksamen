import React, { useState, useEffect } from 'react';
import { Form, Button } from "react-bootstrap";
import facade from "./apiFacade";

const SelectContact = () => {

    const init = { select: "" };
    const [selectContract, setselectContract] = useState(init);

    const handleChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        setNewContact({ ...newContact, [name]: value })
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        window.alert("New Contact added: ", JSON.stringify(newContact))
        facade.newContact(newContact.name, newContact.jobtitle, newContact.company, newContact.phone, newContact.email);
    }

    const Selected = () => {

        return ();
    }

    return (
        <>
            <div>
                <h3>Select Single Contact</h3><br />
                <Form onChange={handleChange} onSubmit={handleSubmit}>
                    <input placeholder="Contact ID" name="id" /><br />
                    <br />
                <Button variant="dark" type="submit">Create Contact</Button>
        </div>
                <Selected />
        </>
    )}