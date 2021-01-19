import React, { useState, useEffect } from "react";
import { AllContacts } from ".././sites";

const url = AllContacts;

const styles = {
    width: "140px"
}

const Contacts = () => {
    const [contacts, setContacts] = useState([]);
    useEffect(() => {
        fetch(url)
            .then((res) => res.json())
            .then((data) => {
                setContacts(data);
                console.log("data ",data);
                
            });
    }, []);
    console.log("Contacts: ",contacts);
    const TableBody = contacts.map((c) => {
        <tr key={c.id}>
            <td>{c.id}</td>
            <td>{c.name}</td>
            <td>{c.jobtitle}</td>
            <td>{c.company}</td>
            <td>{c.phone}</td>
            <td>{c.email}</td>
        </tr>
        console.log("Inde i TableBody: ", c.name);
    })
    return (
        <div>
            <h3>Contacts</h3><br />
            <table >
                <thead>
                    <tr>
                        <th style={{width: styles.width}}>Contact ID</th>
                        <th style={{width: styles.width}}>Name</th>
                        <th style={{width: styles.width}}>Jobtitle</th>
                        <th style={{width: styles.width}}>Company</th>
                        <th style={{width: styles.width}}>Phone</th>
                        <th style={{width: styles.width}}>Email</th>
                    </tr>
                </thead>
                {TableBody}

            </table>
        </div>
    );
};

export default Contacts;