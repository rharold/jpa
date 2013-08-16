package com.bosch.symptom.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bosch.symptom.dto.SymptomDTO;
import com.bosch.symptom.model.Symptom;
import com.bosch.symptom.model.SymptomEntity;
import com.bosch.symptom.repository.SymptomRepository;

@Service
public class RepositorySymptomService implements SymptomService {

	@Resource
	SymptomRepository symptomRepository;
	
	@Override
	public Symptom create(SymptomDTO symptomDTO) {
		SymptomEntity symptom = SymptomEntity.build(symptomDTO);
		symptomRepository.save(symptom);
		
		return symptom;
	}

	@Override
	public Symptom update(SymptomDTO symptomDTO) {
		SymptomEntity symptomEntity = this.readSymptom(symptomDTO.getId());
		symptomEntity.update(symptomDTO);
		
		symptomRepository.save(symptomEntity);
		
		return symptomEntity;
	}

	@Override
	public void delete(Long symptomId) {
		symptomRepository.delete(symptomId);
	}

	@Override
	public Symptom findBy(Long symptomId) {
		return this.readSymptom(symptomId);
	}

	@Override
	public List<Symptom> findAll() {
		List<Symptom> all = new ArrayList<Symptom>();
		
		for (Symptom symptom : symptomRepository.findAll()) {
			all.add(symptom);
		}
		
		return all;
	}
	
	private SymptomEntity readSymptom(Long symptomId) {
		SymptomEntity symptom = symptomRepository.findOne(symptomId);
		return symptom;
	}

}
