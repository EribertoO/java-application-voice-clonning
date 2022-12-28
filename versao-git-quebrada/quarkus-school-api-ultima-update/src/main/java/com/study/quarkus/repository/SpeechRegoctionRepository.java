package com.study.quarkus.repository;

import com.study.quarkus.model.SpeechRegoction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SpeechRegoctionRepository implements PanacheRepositoryBase<SpeechRegoction, Integer> {
}
