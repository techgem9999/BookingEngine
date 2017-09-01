/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.REST;

import com.jfc.bookingengine.dao.CountryRepository;
import com.jfc.bookingengine.services.junk.Cargo;
import com.jfc.bookingengine.services.junk.DomainBean;
import com.jfc.bookingengine.services.junk.Informal;
import java.util.List;
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
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Path("domain")
public class Domain {

    @Inject
    DomainBean domainBean;
    @Inject
    Cargo cargo;
    @Inject
    @Informal
    List<String> list;
    @Inject
    CrudRepository personRepository;
    @Inject
    CountryService countryService;

    @GET
    @Path("/domain")
    public String getPath() {
        return domainBean.callMe();
    }

    @GET
    @Path("/cargo")
    public String method() {
        return cargo.method() + " a";
    }

    @GET
    @Path("produces/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String produces(@Context UriInfo uri, @PathParam("id") @Min(value = 2, message = "wrong") @Valid String id) {
        StringBuilder sb = new StringBuilder();
        list.forEach(l -> sb.append(l).append(" "));
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
    public JsonArray getCountry() throws Exception {
        return countryService.get().stream()
                .map(h -> Json.createObjectBuilder()
                .add("Country Id", h.getCountryId())
                .add("Country Name", h.getName())
                .build())
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();
    }

    @GET
    @Path("countries/{id}")
    public Country getCountry(@PathParam(value = "id") int id) throws Exception {
        return countryService.get(id);
    }

    @GET
    @Path("json")
    public JsonObject getJson() {
        return Json.createObjectBuilder().add("Hello", " World").build();
    }

    @POST
    @Path("add")
    public void addCountry(@Valid Country country) throws Exception {
        System.out.println("test " + country);
        countryService.create(country);
    }

    @POST
    @Path("validate")
    public void addValid(@Valid @Size (max = 4, min = 2) String value) {
        System.out.println(value);
    }
}
