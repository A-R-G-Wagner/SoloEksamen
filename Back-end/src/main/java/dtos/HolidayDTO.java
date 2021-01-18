/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Wagner
 */
public class HolidayDTO {

    String date;
    String localName;
    String type;
    

    public HolidayDTO(String date, String localName, String type) {
        this.date = date;
        this.localName = localName;
        this.type = type;
    }
    
     public HolidayDTO(HolidayDTO h) {
        this.date = h.date;
        this.localName = h.localName;
        this.type = h.type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
