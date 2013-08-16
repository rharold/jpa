package com.bosch.symptom.service;

import java.util.List;

import com.bosch.symptom.dto.DtcDTO;
import com.bosch.symptom.model.Dtc;


public interface DtcService {

	public Dtc create(DtcDTO symptomDTO);

	public Dtc update(DtcDTO symptomDTO);
	
	public void delete(Long symptomId);
	
	public Dtc findBy(Long symptomId);
	
	public List<Dtc> findAll();
	
}
