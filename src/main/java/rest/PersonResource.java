/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Person;
import facade.JSONConverter;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jesper
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    PersonFacade pf = new PersonFacade();

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu", null));
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Test if working";
    }

    // ../api/person/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonFromJson() {
        List<Person> persons = pf.getAllPersons();
        return Response.ok().entity(JSONConverter.getJSONFromPersons(persons)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int id) {
        Person p = pf.getPersonById(id);
        return Response.ok().entity(JSONConverter.getJSONFromPerson(p)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCustomer(String content) {
        Person newPerson = JSONConverter.getPersonFromJson(content);
        System.out.println("newPerson: " + newPerson);
        pf.addPerson(newPerson);
        return Response.ok().entity(JSONConverter.getJSONFromPerson(newPerson)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editPerson(String json) {
        Person newPerson = JSONConverter.getPersonFromJson(json);
        pf.editPerson(newPerson);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id") int id) {
        Person p = pf.getPersonById(id);
        return Response.ok().entity(JSONConverter.getJSONFromPerson(p)).build();
    }
}
