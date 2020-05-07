package com.zhenik.scheduler.minio;

import io.quarkus.scheduler.Scheduled;

import java.net.MalformedURLException;
import java.time.Instant;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Scheduler {

  @Inject MinioService minioService;
  @Inject RestClientConfiguration configuration;

  @Scheduled(cron = "{cron.expr}")
  void triggerDataTransfer() throws MalformedURLException {
    long timeNow = Instant.now().getEpochSecond();
    String objectName = timeNow + ".json";
    String payload = configuration.restClient().getBikeAvailability().readEntity(String.class);
    minioService.putObject(objectName, payload);
    System.out.println(objectName + " send to minio");
  }
}
