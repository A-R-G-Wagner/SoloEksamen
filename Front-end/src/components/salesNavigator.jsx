import React from "react";
import { Nav, NavItem, NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";

const SalesNavigator = () => {
    return (
        <>
            <NavItem>
                <NavDropdown title="Contacts" id="basic-nav-dropdown">
                    <NavDropdown.Item as={Link} to="/ViewContacts">
                        Contacts
                </NavDropdown.Item>
                    <NavDropdown.Item as={Link} to="/Readme">
                        Opportunities
                </NavDropdown.Item>
                </NavDropdown>
            </NavItem>
        </>
    );
};

export default SalesNavigator;
