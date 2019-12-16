package org.aguibert.quarkus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class TestService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try /* (  BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("jsonpath.js")))  ) */ {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("jsonpath.js")));
            reader.readLine();
         }catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "ok";
    }

}
