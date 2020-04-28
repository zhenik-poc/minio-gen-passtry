package com.zhenik.scheduler.minio;

import io.quarkus.scheduler.Scheduled;
import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CounterBean {
  private AtomicInteger counter = new AtomicInteger();
  @Inject PayloadGenerator payloadGenerator;
  @Inject MinioService minioService;

  public int get() {
    return counter.get();
  }

  @Scheduled(cron = "{cron.expr}")
  void cronJobWithExpressionInConfig() {
    final int current = counter.incrementAndGet();
    // generate payload -> put into minio
    String payload = payloadGenerator.getPayload();
    minioService.putObject(payload);
    System.out.println(current+ ": object send to minio");
  }
}
