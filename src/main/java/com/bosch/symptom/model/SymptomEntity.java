package com.bosch.symptom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import com.bosch.symptom.dto.DtcDTO;
import com.bosch.symptom.dto.SymptomDTO;


@Entity
@Table(name = "symptom")
public class SymptomEntity implements Symptom {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "modification_time", nullable = false)
    private Date modificationTime;
    
    @Version
    private long version = 0;
    
    @Column(name = "procref", nullable = false)
    private String procref;
    
    @Column(name = "subtype", nullable = false)
    private String subtype;
    
    @Column(name = "spaVersion", nullable = false)
    private String spaVersion;
    
	@OneToMany(cascade={CascadeType.ALL})
    private List<DtcEntity> dtcs = new ArrayList<DtcEntity>();
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
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

	public List<DtcEntity> getDtcs() {
		return dtcs;
	}

	public void setDtcs(ArrayList<DtcEntity> dtcs) {
		this.dtcs = dtcs;
	}
	
	@PreUpdate
    public void preUpdate() {
        modificationTime = new Date();
    }
    
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        creationTime = now;
        modificationTime = now;
    }

	@Override
	public List<Dtc> getSymptomDtcs() {
		List<Dtc> superDtcs = new ArrayList<Dtc>();
		
		for (Dtc dtc : this.dtcs) {
			superDtcs.add(dtc);
		}
		
		return superDtcs;
	}


	public static SymptomEntity build(SymptomDTO symptomDTO) {
		SymptomEntity entity = new SymptomEntity();
		entity.setProcref(symptomDTO.getProcref());
		entity.setSpaVersion(symptomDTO.getSpaVersion());
		entity.setSubtype(symptomDTO.getSubtype());
		
		ArrayList<DtcEntity> dtcEntities = new ArrayList<DtcEntity>();
		List<DtcDTO> dtcs = symptomDTO.getDtcs();
		for (DtcDTO dtcDTO : dtcs) {
			DtcEntity dtcEntity = DtcEntity.build(dtcDTO);
			dtcEntities.add(dtcEntity);
		}
		
		entity.setDtcs(dtcEntities);
		
		return entity;
	}

	public void update(SymptomDTO symptomDTO) {
		this.setProcref(symptomDTO.getProcref());
		this.setSpaVersion(symptomDTO.getSpaVersion());
		this.setSubtype(symptomDTO.getSubtype());
		
		for(DtcDTO dtcDTO : symptomDTO.getDtcs()) {
			DtcEntity dtcEntity = this.getMatchingDtc(dtcDTO);
			dtcEntity.update(dtcDTO);
		}					
	}

	private DtcEntity getMatchingDtc(DtcDTO dtcDTO) {
		for (DtcEntity dtcEntity : this.getDtcs()) {
			if(dtcEntity.getId().equals(dtcDTO.getId())) {
				return dtcEntity;
			}
		}
		
		return null;
	}
	
}
