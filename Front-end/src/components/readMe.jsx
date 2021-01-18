import React from "react";

const Readme = () => {
  return (
    <>
      <h2>ReadMe instruks</h2>
      <ul>
        <li>CA-3 Gruppe 5: Fungerer som home knap</li>
        <li>Home: Fungerer som home knap</li>
        <li>Readme: Viser ReadMe teksten</li>
        <li>DailyFun: Viser data som er samlet fra eksterne API'er</li>
        <li>Admin: Viser en admin-only funktion. Kan kun ses når logget ind som admin</li>
        <li>User: Viser en user-only funktion. Kan kun ses når logget ind som user</li>
        <li>Helligdage: Viser data hentet fra en ekstern server. Kan kun ses når logget ind som user</li>
        <li>Dropdown: Viser 'home' og 'readme' knapperne</li>
        <li>Login: multi-funktion: </li>
        <ul>
          <li>'ikke logged-in': login: Viser login siden </li>
          <li>'admin logged-in': 'username': Viser velkomstside med logout knap</li>
          <li>'user logged-in': 'username': Viser velkomstside med logout knap</li>
        </ul>
        <li>Testbrugere er: </li>
        <ul>
          <li>username: user, password: userPW </li>
          <li>username: admin, password: adminPW </li>
        </ul>
      </ul>
    </>
  );
};

export default Readme;
