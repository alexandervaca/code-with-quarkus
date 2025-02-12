package org.acme.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@Path("/greeting")
@Slf4j
@OpenAPIDefinition(
    info = @Info(title="Example API", version = "1.0.1", license = @License(
    name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")))
public class GreetingResource {

    @ConfigProperty(name = "quarkus.application.version")
    String appVersion;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        log.info("GreetingResource :: hello");

        return Response.ok("Hello from Quarkus REST - " + appVersion).build();
    }
}
