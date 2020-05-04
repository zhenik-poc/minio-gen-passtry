package com.zhenik.scheduler.minio;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/bike")
public class PayloadResource {

  @Inject
  @RestClient
  BySykkelService bySykkelService;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getLatestStationInfo() {
    Response res = bySykkelService.getBikeAvailability();
    System.out.println(res.getEntity());
    return res;
  }
}
