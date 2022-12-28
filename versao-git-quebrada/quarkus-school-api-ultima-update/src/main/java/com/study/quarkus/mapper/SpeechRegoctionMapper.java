package com.study.quarkus.mapper;

import com.study.quarkus.dto.SpeechRegoctionResponse;
import com.study.quarkus.model.SpeechRegoction;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class SpeechRegoctionMapper {
    public List<SpeechRegoctionResponse> toResponse(List<SpeechRegoction> listOfTranscriptions) {

        if (Objects.isNull(listOfTranscriptions)) return new ArrayList<>();

        return listOfTranscriptions.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public SpeechRegoctionResponse toResponse(SpeechRegoction entity) {

        Objects.requireNonNull(entity, "Entity must be not null");

        return  SpeechRegoctionResponse.builder()
                 .PersonID(entity.getPersonID())
                 .transcricao(entity.getTranscricao())
                 .build();
                   
    }
}
