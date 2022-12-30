package com.study.quarkus.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;

import java.util.Set;

@Path("/extensions")
@RegisterRestClient
public interface ExtensionsService {

    @GET
    @Path("/stream/{stream}")
    Set<Extension> getByStream(@PathParam String stream, @QueryParam("id") String id);

    Set<Extension> getById(String id);
}