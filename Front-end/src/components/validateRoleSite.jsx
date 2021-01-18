import React from "react";
import facade from "./apiFacade";
import UserNavigator from "./userNavigator";
import AdminNavigator from "./adminNavigator";
import SalesNavigator from "./salesNavigator";

const ValidateRoleSite = (props) => {
  const role = facade.getRoles();
  console.log(role);

  if (role === "admin" && props.loggedIn) {
    return (
      <>
        <AdminNavigator />
      </>
    );
  }
  if (role === "sales" && props.loggedIn) {
    return (
      <>
        <SalesNavigator />
      </>
    );
  }
  else if (role === "user" && props.loggedIn) {
    return (
      <>
        <UserNavigator />
      </>
    );
  } else {
    return <></>;
  }
};

export default ValidateRoleSite;
