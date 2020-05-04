package com.zhenik.scheduler.minio;

import io.quarkus.scheduler.Scheduled;
import java.time.Instant;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class Scheduler {

  @Inject MinioService minioService;
  @Inject @RestClient BySykkelService bySykkelService;

  @Scheduled(cron = "{cron.expr}")
  void cronJobWithExpressionInConfig() {
    long timeNow = Instant.now().getEpochSecond();
    String objectName = timeNow + ".json";
    String payload = bySykkelService.getBikeAvailability().readEntity(String.class);
    minioService.putObject(objectName, payload);
    System.out.println(objectName + " send to minio");
  }
}
