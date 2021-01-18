import React, { useEffect, useState } from "react";
import { HolidaysUrl } from "./../sites";

const url = HolidaysUrl;

const styles = {
    width: "140px"
}

const Holidays = () => {
    const [holidays, setHolidays] = useState([]);
    useEffect(() => {
        fetch(url)
            .then((res) => res.json())
            .then((data) => {
                setHolidays(data);
            });
    }, []);
    const TableBody = () => holidays.map((h) => (
        <tr key={h.date.toString()}>
            <td>{h.date}</td>
            <td>{h.localName}</td>
            <td>{h.type}</td>
        </tr>
    ))
    return (
        <div>
            <h3>Danske helligdage</h3>
            <table >
                <thead>
                    <tr>
                        <th style={{width: styles.width}}>Dato</th>
                        <th style={{width: styles.width}}>Helligdag</th>
                        <th style={{width: styles.width}}>Omfang</th>
                    </tr>
                </thead>
                <TableBody />

            </table>
        </div>
    );
};

export default Holidays;