package com.bosch.symptom.model;

import java.util.List;

public interface Symptom {

	Long getId();
	
	String getProcref();
	
	String getSubtype();
	
	String getSpaVersion();
	
	List<Dtc> getSymptomDtcs();
	
}
