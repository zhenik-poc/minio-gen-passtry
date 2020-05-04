package com.zhenik.scheduler.minio;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix="bysykkel")
public class BySykkelConfiguration {
  private String clientIdentifier;

  public String getClientIdentifier() { return clientIdentifier; }
  public void setClientIdentifier(String clientIdentifier) { this.clientIdentifier = clientIdentifier; }
}
