package com.study.quarkus.service;

import com.study.quarkus.dto.AlunoRequest;
import com.study.quarkus.dto.AlunoResponse;
import com.study.quarkus.dto.TutorResponse;
import com.study.quarkus.mapper.AlunoMapper;
import com.study.quarkus.model.Aluno;
import com.study.quarkus.model.Professor;
import com.study.quarkus.repository.AlunoRepository;
import com.study.quarkus.repository.ProfessorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoMapper mapper;
    private final AlunoRepository repository;
    private final ProfessorRepository repository2;

    public List<AlunoResponse> retrieveAll() {
        log.info("Listing Alunos");
        final List<Aluno> listOfAlunos = repository.listAll();
        return  mapper.toResponse(listOfAlunos);
    }

    public AlunoResponse getById(int id) {
        log.info("Getting Aluno id-{}", id);

        Aluno Aluno = repository.findById(id);
        return mapper.toResponse(Aluno);
    }

    @Transactional
    public AlunoResponse save(AlunoRequest AlunoRequest) {

        log.info("Saving Aluno - {}", AlunoRequest);

        Aluno entity =
                Aluno.builder()
                .name(AlunoRequest.getName()).tutor(AlunoRequest.getTutor())
                .build();

        repository.persistAndFlush(entity);

        return mapper.toResponse(entity);
    }

    @Transactional
    public TutorResponse update(int idAluno, int idProfessor) {

        log.info("Updating tutor id - {}, professor id - {}", idAluno, idProfessor);

        Optional<Aluno> aluno = repository.findByIdOptional(idAluno);
        Optional<Professor> professor = repository2.findByIdOptional(idProfessor);

        professor.orElseThrow(() -> new EntityNotFoundException("Professor not found."));

        aluno.setTutor(professor);
        repository.persist(aluno); 
        return mapper.toResponse(professor);
    }

    @Transactional
    public AlunoResponse update(int id, AlunoRequest AlunoRequest) {

        log.info("Updating Aluno id - {}, data - {}", id, AlunoRequest);

        Optional<Aluno> Aluno = repository.findByIdOptional(id);

        if (Aluno.isPresent()) {
            var entity = Aluno.get();
            entity.setName(AlunoRequest.getName());
            return mapper.toResponse(entity);
        }

        return new AlunoResponse();
    }

    @Transactional
    public AlunoResponse atualizarTutor(int id, AlunoRequest AlunoRequest, int idP) {

        log.info("Updating Aluno id - {}, data - {}", id, AlunoRequest);
        log.info("Updating Professor  id - {}", idP);

        Optional<Aluno> Aluno = repository.findByIdOptional(id);
        Optional<Professor> professor = repository2.findByIdOptional(idP);

        if (Aluno.isPresent() & professor.isPresent()) {
            var entityAluno = Aluno.get();
            var entityProfessor = professor.get();
            // entityProfessor.setTutor(professor);
           // return mapper.toResponse(entityAluno);
        }

        return new AlunoResponse();
    }

    @Transactional
    public void delete(int id) {
        log.info("Deleting Aluno id - {}", id);
        Optional<Aluno> Aluno = repository.findByIdOptional(id);
        Aluno.ifPresent(repository::delete);
    }
}
