package com.zhenik.scheduler.minio.config;

import io.quarkus.arc.config.ConfigProperties;
import java.util.Optional;

@ConfigProperties(prefix="proxy")
public class ProxyConfiguration {
  private Optional<String> uri;
  private Optional<Integer> port;
  private Optional<String> scheme;

  public Optional<String> getUri() { return uri; }
  public void setUri(Optional<String> uri) { this.uri = uri; }
  public Optional<Integer> getPort() { return port; }
  public void setPort(Optional<Integer> port) { this.port = port; }
  public Optional<String> getScheme() { return scheme; }
  public void setScheme(Optional<String> scheme) { this.scheme = scheme; }
}
