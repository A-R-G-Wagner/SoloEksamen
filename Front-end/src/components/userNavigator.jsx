import React from "react";
import { Nav, NavItem, NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";


const UserNavigator = () => {
  return (
    <>
      
      <NavItem>
        <NavDropdown title="Sales" id="basic-nav-dropdown">
          <NavDropdown.Item as={Link} to="/ViewContacts">
            View Contacts
                </NavDropdown.Item>
          <NavDropdown.Item as={Link} to="/NewContact">
            New Contact
                </NavDropdown.Item>
          <NavDropdown.Item as={Link} to="/SingleContact">
            View Single Contact
                </NavDropdown.Item>
        </NavDropdown>
      </NavItem>
    </>
  );
};

export default UserNavigator;
