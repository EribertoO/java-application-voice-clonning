package com.study.quarkus.service;

import com.study.quarkus.dto.SpeechRegoctionRequest;
import com.study.quarkus.dto.SpeechRegoctionResponse;
import com.study.quarkus.mapper.SpeechRegoctionMapper;
//import com.study.quarkus.model.Aluno;
import com.study.quarkus.model.SpeechRegoction;
import com.study.quarkus.repository.SpeechRegoctionRepository;
//import com.study.quarkus.repository.SpeechRegoctionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class SpeechRegoctionService {

    private final SpeechRegoctionMapper mapper;
    private final SpeechRegoctionRepository repository;

    public List<SpeechRegoctionResponse> retrieveAll() {
        log.info("Listing Score");
        final List<SpeechRegoction> listOfScore = repository.listAll();
        return  mapper.toResponse(listOfScore);
    }
    
    public SpeechRegoctionResponse getByPersonID(int id) {
        log.info("Getting Person id-{}", id);
        
        SpeechRegoction Score = repository.findById(id);
        return mapper.toResponse(Score);
    }

    /*
    @Transactional
    public SpeechRegoctionResponse save(SpeechRegoctionRequest SpeechRegoctionRequest) {
        
        log.info("Saving Request - {}", SpeechRegoctionRequest);
        
        SpeechRegoction entity =
            SpeechRegoction.builder()
            .name(SpeechRegoctionRequest.getPersonID())
            .build();
        
        repository.persistAndFlush(entity);
        
        return mapper.toResponse(entity);
    }
    
    /*
    @Transactional
    public SpeechRegoctionResponse update(int id, SpeechRegoctionRequest SpeechRegoctionRequest) {

        log.info("Updating Aluno id - {}, data - {}", id, SpeechRegoctionRequest);

        Optional<Aluno> Aluno = repository.findByIdOptional(id);

        if (Aluno.isPresent()) {
            var entity = Aluno.get();
            entity.setName(SpeechRegoctionRequest.getName());
            return mapper.toResponse(entity);
        }

        return new SpeechRegoctionResponse();
    }
    */

    /*

    @Transactional
    public SpeechRegoctionResponse atualizarTutor(int id, SpeechRegoctionRequest SpeechRegoctionRequest, int idP) {

        log.info("Updating Aluno id - {}, data - {}", id, SpeechRegoctionRequest);
        log.info("Updating SpeechRegoction  id - {}", idP);

        Optional<Aluno> Aluno = repository.findByIdOptional(id);

        if (Aluno.isPresent() & SpeechRegoction.isPresent()) {
            var entityAluno = Aluno.get();
            var entitySpeechRegoction = SpeechRegoction.get();
            // entitySpeechRegoction.setTutor(SpeechRegoction);
           // return mapper.toResponse(entityAluno);
        }

        return new SpeechRegoctionResponse();
    }
    */

    /*
    @Transactional
    public void delete(int id) {
        log.info("Deleting Aluno id - {}", id);
        Optional<Aluno> Aluno = repository.findByIdOptional(id);
        Aluno.ifPresent(repository::delete);
    }
    */
}
