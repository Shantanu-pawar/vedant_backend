package com.project.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	private long projectId;
	private String projectName;

	@OneToOne
	@JoinColumn
	private Employee employee;
}
