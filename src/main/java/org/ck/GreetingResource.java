package org.ck;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import freemarker.template.Template;
import io.quarkiverse.freemarker.runtime.TemplatePath;

@Path("/hello")
public class GreetingResource {

    @Inject
    @TemplatePath("hello.ftl")
    Template hello;

    @GET
    @Produces(TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        hello.process(Map.of("name", name), stringWriter);
        return stringWriter.toString();
    }



//     @GET
//     @Produces(MediaType.TEXT_PLAIN)
//     public String hello() {
//         return "Hello from RESTEasy Reactive";
//     }
}
