/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.REST;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import com.jfc.bookingengine.dao.CrudRepository;
import com.jfc.bookingengine.dao.exception.RepositoryException;
import com.jfc.bookingengine.dto.Country;
import com.jfc.bookingengine.services.CountryService;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author jfc
 */
@Path("domain")
public class Booking {

    @Inject
    CrudRepository personRepository;
    @Inject
    CountryService countryService;


    @GET
    @Path("produces/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String produces(@Context UriInfo uri, @PathParam("id") @Min(value = 2, message = "wrong") @Valid String id) {
        StringBuilder sb = new StringBuilder();
        return sb.toString() + uri.getPath() + " path param " + id;
    }

    @GET
    @Path("person")
    public String getPerson() throws RepositoryException {
        //return em.createNamedQuery("Person.findAll").getSingleResult().toString();
        /* Query namedQuery = session.getNamedQuery("Person.findAll");
        return namedQuery.list().get(0).toString();*/
        String toString = personRepository.findAll().get(0).toString();
        return toString;

    }

    @GET
    @Path("countries")
    public Response getCountry() throws Exception {
        JsonArray build = countryService.get().stream()
                .map(h -> Json.createObjectBuilder()
                        .add("id", h.getCountryId())
                        .add("name", h.getName())
                        .build())
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();
        return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "GET, OPTIONS")
            .status(200).entity(build).build();
    }

    @GET
    @Path("countries/{id}")
    public Country getCountry(@PathParam(value = "id") int id) throws Exception {
        return countryService.get(id);
    }

}
