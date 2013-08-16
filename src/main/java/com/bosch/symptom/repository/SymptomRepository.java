package com.bosch.symptom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bosch.symptom.model.SymptomEntity;

public interface SymptomRepository extends JpaRepository<SymptomEntity, Long>{

}
