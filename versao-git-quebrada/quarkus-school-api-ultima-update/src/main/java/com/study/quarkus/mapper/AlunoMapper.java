package com.study.quarkus.mapper;

import com.study.quarkus.dto.AlunoResponse;
import com.study.quarkus.dto.TutorResponse;
import com.study.quarkus.model.Aluno;
import com.study.quarkus.model.Professor;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class AlunoMapper {
    public List<AlunoResponse> toResponse(List<Aluno> listOfAlunos) {

        if (Objects.isNull(listOfAlunos)) return new ArrayList<>();

        return listOfAlunos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AlunoResponse toResponse(Aluno entity) {

        Objects.requireNonNull(entity, "Entity must be not null");

        return  AlunoResponse.builder()
                    .id(entity.getId())
                    .name(entity.getName()).id(entity.getTutor().getId())
                    .build();
    }

    public TutorResponse toResponse(Professor entity) {

        Objects.requireNonNull(entity, "Entity must be not null");

        return  TutorResponse.builder()
                    .tutor(entity.getName())
                    .build();
    }
}
