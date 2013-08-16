package com.bosch.symptom.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import com.bosch.symptom.dto.DtcDTO;

@Entity
@Table(name = "dtc")
public class DtcEntity implements Dtc {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "modification_time", nullable = false)
    private Date modificationTime;
    
    @Version
    private long version = 0;
    
    @Column(name = "moduleId", nullable = false)
    private String moduleId;
    
    @Column(name = "moduleDesc", nullable = false)
    private String moduleDesc;
    
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

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
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
    
    public static DtcEntity build(DtcDTO dtcDTO) {
    	DtcEntity entity = new DtcEntity();
    	
    	entity.setModuleDesc(dtcDTO.getModuleDesc());
    	entity.setModuleId(dtcDTO.getModuleId());
    	
    	return entity;
    }
    
    public void update(DtcDTO dtcDTO) {
    	this.setModuleDesc(dtcDTO.getModuleDesc());
    	this.setModuleId(dtcDTO.getModuleId());
    }
}
