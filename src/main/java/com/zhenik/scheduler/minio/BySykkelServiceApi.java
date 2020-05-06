package com.zhenik.scheduler.minio;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="bysykkel-api")
public interface BySykkelServiceApi {

  default String clientIdentifier() {
    return ConfigProvider.getConfig().getValue("bysykkel-api.client-identifier", String.class);
  }

  @GET
  @ClientHeaderParam(name = "Client-Identifier", value = "{clientIdentifier}")
  Response getBikeAvailability();
}
