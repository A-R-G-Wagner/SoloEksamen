/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HolidayDTO;
import facades.DataFetcherFacade;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alex Wagner
 */
@Path("holidays")
public class HolidayResource {

    private static final DataFetcherFacade FACADE = new DataFetcherFacade();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HollidayResource
     */
    public HolidayResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHolidayDTO() throws IOException {

        Collection<HolidayDTO> HolidayDTO = FACADE.getHolidayDTO();
        String holiday = GSON.toJson(HolidayDTO);

        return holiday;
    }

}
