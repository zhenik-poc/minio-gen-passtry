package com.zhenik.scheduler.minio;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("bike")
public class AppResource {

  @Inject
  @RestClient
  BySykkelService bySykkelService;

  @GET
  @Path("example")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPayloadExample() {
    return bySykkelService.getBikeAvailability();
  }

  @GET
  @Path("healthcheck")
  public Response checkHealth() {
    return Response.ok("I am ok").build();
  }
}
