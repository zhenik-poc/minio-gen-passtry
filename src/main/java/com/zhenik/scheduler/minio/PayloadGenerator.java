package com.zhenik.scheduler.minio;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterForReflection
public class PayloadGenerator {
  private RandomString randomString;
  private Integer maxTries;
  private Random random;

  public PayloadGenerator() {
    this(10);
  }
  public PayloadGenerator(Integer maxTries) {
    this.maxTries = maxTries;
    this.randomString = new RandomString();
    this.random = new Random();
  }

  // csv format
  // id, timestamp, value
  // string, long, string
  public String getPayload() {
    StringBuilder sb = new StringBuilder();
    sb.append("id,timestamp,value\n");
    int tries = random.nextInt(maxTries)+1;
    for (int i=0;i<tries;i++) {
      sb.append(
          UUID.randomUUID().toString() + "," +
          Instant.now().getEpochSecond() + "," +
          randomString.nextString() + "\n");
    }
    return sb.toString();
  }

  public RandomString getRandomString() { return randomString; }
  public void setRandomString(RandomString randomString) { this.randomString = randomString; }
  public Integer getMaxTries() { return maxTries; }
  public void setMaxTries(Integer maxTries) { this.maxTries = maxTries; }
}
