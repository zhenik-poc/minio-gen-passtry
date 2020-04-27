package com.zhenik.scheduler.minio;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix="minio")
public class MinioConfiguration {
  private String suffix = "!";
  private String url;
  private String accessKey;
  private String secretKey;
  private String bucketname;

  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }
  public String getAccessKey() { return accessKey; }
  public void setAccessKey(String accessKey) { this.accessKey = accessKey; }
  public String getSecretKey() { return secretKey; }
  public void setSecretKey(String secretKey) { this.secretKey = secretKey; }
  public String getBucketname() { return bucketname; }
  public void setBucketname(String bucketname) { this.bucketname = bucketname; }
  public String getSuffix() { return suffix; }
  public void setSuffix(String suffix) { this.suffix = suffix; }
}
