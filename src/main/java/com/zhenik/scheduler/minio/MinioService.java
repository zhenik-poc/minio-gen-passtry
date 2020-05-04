package com.zhenik.scheduler.minio;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.MinioException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MinioService {
  String bucketname;
  String bucketnameSuffix;
  MinioClient minioClient;

  @Inject
  MinioService(MinioConfiguration minioConfiguration) throws InvalidPortException, InvalidEndpointException {
    this.bucketname = minioConfiguration.getBucketname();
    this.bucketnameSuffix = minioConfiguration.getBucketnameSuffix();
    this.minioClient = new MinioClient(
        minioConfiguration.getUrl(),
        minioConfiguration.getAccessKey(),
        minioConfiguration.getSecretKey()
    );
  }

  public void putObject(String objectName, String payload) {
    try {
      ByteArrayInputStream bais = new ByteArrayInputStream(payload.getBytes("UTF-8"));
      PutObjectOptions options = new PutObjectOptions(-1, PutObjectOptions.MAX_PART_SIZE);
      // "application/octet-stream"
      minioClient.putObject(bucketname, bucketnameSuffix + objectName, bais, options);
      bais.close();
    } catch (IOException | MinioException | InvalidKeyException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
