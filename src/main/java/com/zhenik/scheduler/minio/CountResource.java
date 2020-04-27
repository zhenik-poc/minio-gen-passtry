package com.zhenik.scheduler.minio;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/payload")
public class CountResource {

    @Inject
    PayloadGenerator payloadGenerator;

    @Inject
    MinioService minioService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String randomPayload() {
        String payload = payloadGenerator.getPayload();
        minioService.putObject(payload);
        return payload;
    }
}
