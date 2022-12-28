package com.study.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Score")
public class SpeechRegoction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    private int PersonID;

    @NotBlank(message = "Name must be not empty or null")
    @Column(name = "Pontuacao", nullable = false)
    private Float pontuacao;

    @NotBlank(message = "Name must be not empty or null")
    @Column(name = "Transcricao", nullable = false)
    private String transcricao;

    @Column(name="DataCriacao", nullable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void prePersist(){
        setDateTime(LocalDateTime.now());
    }
}
