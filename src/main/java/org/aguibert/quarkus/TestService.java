package org.aguibert.quarkus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.reactive.mutiny.Mutiny;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TestService {
    
    static int count = 0;
    
    @Inject
    Mutiny.Session mutinySession;

    @GET
    public String hello() {
        return "Hello world";
    }
    
    @GET
    @Path("fruits")
    public Multi<Fruit> get() {
        return mutinySession
                .createNamedQuery( "Fruits.findAll", Fruit.class )
                .getResults();
    }
    
    @GET
    @Path("create")
    public Uni<Response> create() {
        Fruit fruit = new Fruit("banana-" + ++count);
        return mutinySession
                .persist(fruit)
                .chain(mutinySession::flush)
                .map(ignore -> Response.ok(fruit).status(201).build());
    }

}
