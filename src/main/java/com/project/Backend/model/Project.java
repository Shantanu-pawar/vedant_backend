package com.project.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	private long projectId;

	private String projectName;

	private String projectHeadName;

	@OneToOne
	@JoinColumn
	private Employee employee;

	public Project(long projectId, String projectName, String projectHeadName) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectHeadName = projectHeadName;
	}
}
