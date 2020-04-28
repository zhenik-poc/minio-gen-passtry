package com.zhenik.scheduler.minio;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix="minio")
public class MinioConfiguration {
  private String url;
  private String accessKey;
  private String secretKey;
  private String bucketname;
  private String bucketnameSuffix;

  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }
  public String getAccessKey() { return accessKey; }
  public void setAccessKey(String accessKey) { this.accessKey = accessKey; }
  public String getSecretKey() { return secretKey; }
  public void setSecretKey(String secretKey) { this.secretKey = secretKey; }
  public String getBucketname() { return bucketname; }
  public void setBucketname(String bucketname) { this.bucketname = bucketname; }
  public String getBucketnameSuffix() { return this.bucketnameSuffix; }
  public void setBucketnameSuffix(String bucketnameSuffix) { this.bucketnameSuffix = bucketnameSuffix; }
}
