package com.bosch.symptom.service;

import java.util.List;

import com.bosch.symptom.dto.SymptomDTO;
import com.bosch.symptom.model.Symptom;


public interface SymptomService {
	
	public Symptom create(SymptomDTO symptomDTO);

	public Symptom update(SymptomDTO symptomDTO);
	
	public void delete(Long symptomId);
	
	public Symptom findBy(Long symptomId);
	
	public List<Symptom> findAll();
	
}
