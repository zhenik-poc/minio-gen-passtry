//package com.zhenik.scheduler.minio;
//
//import javax.inject.Inject;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import org.eclipse.microprofile.rest.client.inject.RestClient;
//// for testing purposes
//@Path("/bike")
//public class PayloadResource {
//
//  @Inject
//  @RestClient
//  BySykkelService bySykkelService;
//
//  @GET
//  @Produces(MediaType.TEXT_PLAIN)
//  public Response getLatestStationInfo() {
//    Response res = bySykkelService.getBikeAvailability();
//    String data = res.readEntity(String.class);
//    System.out.println(data);
//    return Response.status(200).entity(data).build();
//  }
//}
