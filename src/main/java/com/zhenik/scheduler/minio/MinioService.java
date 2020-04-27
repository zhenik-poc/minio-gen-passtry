package com.zhenik.scheduler.minio;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.MinioException;
import io.minio.errors.XmlParserException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MinioService {
  private MinioClient minioClient;

  public MinioService() throws InvalidPortException, InvalidEndpointException {
    this(new MinioClient(
        "http://localhost:9000",
        "minio",
        "minio123"
    ));
  }

  public MinioService(MinioClient minioClient) {
    this.minioClient = minioClient;
  }

  public void putObject(String payload) {
    try {
      String objectName = UUID.randomUUID().toString()+".csv";
      ByteArrayInputStream bais = new ByteArrayInputStream(payload.getBytes("UTF-8"));
      PutObjectOptions options = new PutObjectOptions(-1, PutObjectOptions.MAX_PART_SIZE);
      //"application/octet-stream"
      minioClient.putObject("default", objectName, bais, options);
      bais.close();
    } catch (IOException | MinioException | InvalidKeyException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
