package com.ck;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;
import jakarta.ws.rs.QueryParam;
import jakarta.inject.Inject;

@Path("/hello")
public class HelloResource {

    @Inject
    Template hello;

    @Inject
    Template product;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get(@QueryParam("name") String name) {
        return hello.data("name", name);
    }

    @GET
    @Path("/products")
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get() {
        String name = "Apple";
        return product.data("name", name);
    }


//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "Hello from RESTEasy Reactive";
//    }
}
