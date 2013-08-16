package com.bosch.symptom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bosch.symptom.model.DtcEntity;

public interface DtcRepository extends JpaRepository<DtcEntity, Long>{

}
