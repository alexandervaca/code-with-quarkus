package org.acme.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.acme.rest.json.Fruit;
import org.acme.service.FruitService;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import java.util.*;

@Path("/fruits")
@Slf4j
@OpenAPIDefinition(
    info = @Info(title="Example API", version = "1.0.1", license = @License(
    name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")))
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<Fruit> fruitList = fruitService.findAll();
        return Response.ok(fruitList).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response listByName(@PathParam("name") String name) {
        List<Fruit> fruitList = fruitService.findByName(name);
        return Response.ok(fruitList).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        var fruit = fruitService.findAll().stream().filter(
            existingFruit -> Objects.equals(existingFruit.getId(), id));

        return Response.ok(fruit).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Fruit fruit) {
        fruitService.create(fruit);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        var fruits = fruitService.findAll().removeIf(existingFruit -> existingFruit.getId().equals(id));
        return Response.ok(fruits).build();
    }

}
