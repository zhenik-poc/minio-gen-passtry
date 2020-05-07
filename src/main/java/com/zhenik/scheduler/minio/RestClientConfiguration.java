package com.zhenik.scheduler.minio;

import com.zhenik.scheduler.minio.config.ProxyConfiguration;
import java.net.MalformedURLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import static org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder.PROPERTY_PROXY_HOST;
import static org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder.PROPERTY_PROXY_PORT;
import static org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder.PROPERTY_PROXY_SCHEME;

@ApplicationScoped
public class RestClientConfiguration {
  private ProxyConfiguration proxyConfiguration;

  @ConfigProperty(name = "bysykkel-api/mp-rest/url")
  private String targetUrl;

  @Inject
  public RestClientConfiguration(ProxyConfiguration proxyConfiguration) {
    this.proxyConfiguration = proxyConfiguration;
  }

  public BySykkelServiceApi restClient() throws MalformedURLException {
    RestClientBuilder restClientBuilder = RestClientBuilder
        .newBuilder()
        .baseUrl(UriBuilder.fromUri(targetUrl).build().toURL());

    if (proxyConfiguration.getUri().isPresent()){
      restClientBuilder
          .property(PROPERTY_PROXY_HOST, proxyConfiguration.getUri().get())
          .property(PROPERTY_PROXY_PORT, proxyConfiguration.getPort().get())
          .property(PROPERTY_PROXY_SCHEME, proxyConfiguration.getScheme().get());
    }
    return restClientBuilder.build(BySykkelServiceApi.class);
  }
}
