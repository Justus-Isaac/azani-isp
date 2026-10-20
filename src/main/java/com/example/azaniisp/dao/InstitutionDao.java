package com.example.azaniisp.dao;

import com.example.azaniisp.model.InstitutionEntity;

import java.util.List;
import java.util.Optional;

public interface InstitutionDao {
    InstitutionEntity save(InstitutionEntity institution);
    void update(InstitutionEntity institution);
    Optional<InstitutionEntity> findById(Long id);
    Optional<InstitutionEntity> findByRegistrationNo(String registrationNo);
    List<InstitutionEntity> findAll();
}
