package com.bosch.symptom.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bosch.symptom.dto.DtcDTO;
import com.bosch.symptom.model.Dtc;
import com.bosch.symptom.model.DtcEntity;
import com.bosch.symptom.repository.DtcRepository;

public class RepositoryDtcService implements DtcService {

	@Resource 
	DtcRepository dtcRepository;
	
	@Override
	public Dtc create(DtcDTO dtcDTO) {
		DtcEntity dtcEntity = DtcEntity.build(dtcDTO);
		
		dtcRepository.save(dtcEntity);
		return null;
	}

	@Override
	public Dtc update(DtcDTO dtcDTO) {
		DtcEntity dtcEntity = this.read(dtcDTO.getId());
		dtcEntity.update(dtcDTO);			
		dtcRepository.save(dtcEntity);
		
		return dtcEntity;
	}

	@Override
	public void delete(Long dtcId) {
		dtcRepository.delete(dtcId);
	}

	@Override
	public Dtc findBy(Long dtcId) {
		return this.read(dtcId);
	}

	@Override
	public List<Dtc> findAll() {
		List<Dtc> dtcs = new ArrayList<Dtc>();
		
		for(DtcEntity dtcEntity : dtcRepository.findAll()) {
			dtcs.add(dtcEntity);
		}
			
		return dtcs;
	}
	
	private DtcEntity read(Long dtcId) {
		return dtcRepository.findOne(dtcId);
	}

}
