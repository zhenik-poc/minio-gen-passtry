package com.zhenik.scheduler.minio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface BySykkelService {

  @GET
  @Path("/station_status.json")
  @ClientHeaderParam(
      name = "Client-Identifier",
      value = "zhenik-test") // todo: extract header value to config
  Response getBikeAvailability();
}
