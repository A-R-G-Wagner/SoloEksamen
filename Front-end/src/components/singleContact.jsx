import React, { useState, useEffect } from 'react';
import { Form, Button } from "react-bootstrap";
import facade from "./apiFacade";

const SelectContact = () => {

    const [selectContact, setselectContract] = useState();
    

    const handleChange = (event) => {
        const target = event.target;
        const value = target.value;
        setselectContract(value)
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log("Brugeren valgte: ", {selectContact});
    }

    
return (
    <>
        <div>

            <h3>Select Single Contact</h3><br />
            <Form onChange={handleChange} onSubmit={handleSubmit}>
                <input placeholder="Contact ID" name="id" /><br />
                <br />
                <Button variant="dark" type="submit">Create Contact</Button>
            </Form>
        </div>
        
    </>
)
}

export default SelectContact;