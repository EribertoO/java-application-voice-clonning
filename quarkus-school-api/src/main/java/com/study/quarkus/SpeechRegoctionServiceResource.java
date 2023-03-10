package com.study.quarkus;

import com.study.quarkus.dto.SpeechRegoctionRequest;
import com.study.quarkus.service.SpeechRegoctionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Voice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpeechRegoctionServiceResource {

    private final SpeechRegoctionService service;

    @Inject
    public SpeechRegoctionServiceResource(SpeechRegoctionService service) {
        this.service = service;
    }

    @GET
    public Response listAlunos() {
        final var response = service.retrieveAll();
        return Response.ok(response).build();
    }

    @GET
    @Path("/{PersonID}")
    public Response getAluno(@PathParam("PersonID") int PersonID) {
        final var response = service.getByPersonID(PersonID);
        return Response.ok(response).build();
    }

    /*
    @POST
    public Response getTranscription(final SpeechRegoctionRequest SpeechRegoction) {

        final var response = service.save(SpeechRegoction);

        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }
    */

    /*
    @PUT
    @Path("/{id}")
    public Response updateAluno(@PathParam("id") int id, SpeechRegoctionRequest Aluno) {

        var response = service.update(id, Aluno);

        return Response
                .ok(response)
                .build();
    }
    */

    /* 

    @DELETE
    @Path("/{id}")
    public Response removeAluno(@PathParam("id") int id) {

        service.delete(id);

        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
    */
}
