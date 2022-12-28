package com.study.quarkus.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class SpeechRegoctionResponse {
    private String transcricao;
    private int PersonID;
    private Float pontuacao;
    private LocalDateTime dateTime;
}
