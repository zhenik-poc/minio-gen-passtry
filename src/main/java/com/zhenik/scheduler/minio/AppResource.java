package com.zhenik.scheduler.minio;

import java.net.MalformedURLException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("bike")
public class AppResource {

  @Inject
  RestClientConfiguration configuration;

  @GET
  @Path("example")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPayloadExample() throws MalformedURLException {
    return configuration.restClient().getBikeAvailability();
  }

  @GET
  @Path("healthcheck")
  public Response checkHealth() {
    return Response.ok("I am ok").build();
  }
}
