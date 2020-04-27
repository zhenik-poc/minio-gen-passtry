package com.zhenik.scheduler.minio;

import io.quarkus.scheduler.Scheduled;
import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CounterBean {
  private AtomicInteger counter = new AtomicInteger();

  public int get() {
    return counter.get();
  }

  @Scheduled(cron = "{cron.expr}")
  void cronJobWithExpressionInConfig() {
    final int current = counter.incrementAndGet();
    System.out.println(current+ ": cron expression configured in application.properties");
  }
}
