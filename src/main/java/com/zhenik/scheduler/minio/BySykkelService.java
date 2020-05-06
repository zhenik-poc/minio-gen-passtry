package com.zhenik.scheduler.minio;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface BySykkelService {

  default String clientIdentifier() {
    return ConfigProvider.getConfig().getValue("bysykkel.client-identifier", String.class);
  }

  @GET
  @ClientHeaderParam(name = "Client-Identifier", value = "{clientIdentifier}")
  Response getBikeAvailability();
}
