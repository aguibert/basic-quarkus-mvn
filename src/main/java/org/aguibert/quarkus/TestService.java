package org.aguibert.quarkus;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/people")
public class TestService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Person find() {
        System.out.println("@AGG inside find");
        Person p = Person.findAll().firstResult();
        System.out.println("@AGG methods:");
        for (Method m : p.getClass().getDeclaredMethods())
            if (!Modifier.isStatic(m.getModifiers()) && !Modifier.isTransient(m.getModifiers())) {
                System.out.println("  " + m);
                System.out.println("    " + Arrays.toString(m.getAnnotations()));
            }
        System.out.println("@AGG fields:");
        for (Field f : p.getClass().getDeclaredFields())
            if (!Modifier.isStatic(f.getModifiers()) && !Modifier.isTransient(f.getModifiers())) {
                System.out.println("  " + f);
                System.out.println("    " + Arrays.toString(f.getAnnotations()));
            }
        return p;
    }

    @GET
    @Path("str")
    public String findStr() {
        System.out.println("@AGG inside findstr");
        Person p = Person.findAll().firstResult();
        // return
        // Response.ok().entity(Person.findAll().firstResult().toString()).build();
        return p.toString();
    }
}
