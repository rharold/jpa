package com.bosch.symptom.dto;

import java.util.ArrayList;
import java.util.List;

public class SymptomDTO {

	private Long id;

	private String procref;

	private String subtype;

	private String spaVersion;

	private List<DtcDTO> dtcs = new ArrayList<DtcDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProcref() {
		return procref;
	}

	public void setProcref(String procref) {
		this.procref = procref;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getSpaVersion() {
		return spaVersion;
	}

	public void setSpaVersion(String spaVersion) {
		this.spaVersion = spaVersion;
	}

	public List<DtcDTO> getDtcs() {
		return dtcs;
	}

	public void setDtcs(List<DtcDTO> dtcs) {
		this.dtcs = dtcs;
	}

}
