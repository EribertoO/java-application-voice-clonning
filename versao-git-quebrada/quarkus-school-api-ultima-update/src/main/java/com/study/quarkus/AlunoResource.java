package com.study.quarkus;

import com.study.quarkus.dto.AlunoRequest;
import com.study.quarkus.service.AlunoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {

    private final AlunoService service;

    @Inject
    public AlunoResource(AlunoService service) {
        this.service = service;
    }


    @GET
    public Response listAlunos() {
        final var response = service.retrieveAll();

        return Response.ok(response).build();
    }

    @GET
    @Path("/{id}")
    public Response getAluno(@PathParam("id") int id) {

        final var response = service.getById(id);

        return Response.ok(response).build();
    }

    @POST
    public Response saveAluno(final AlunoRequest Aluno) {

        final var response = service.save(Aluno);

        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAluno(@PathParam("id") int id, AlunoRequest Aluno) {

        var response = service.update(id, Aluno);

        return Response
                .ok(response)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeAluno(@PathParam("id") int id) {

        service.delete(id);

        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

    @PATCH
    @Path("/{id}/tutor/{idProfessor}")
    public Response atualizarTutor(@PathParam("id") int idAluno, @PathParam("idProfessor") int idProfessor) {
        final var response = service.atualizar(idAluno, idProfessor);

        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }


}
