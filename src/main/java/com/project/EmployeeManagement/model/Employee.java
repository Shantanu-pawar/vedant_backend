package com.project.EmployeeManagement.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.EmployeeManagement.Enums.Gender;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	private String firstName;
	
	private String lastName;

	private Date birthDate;

	@Timestamp
	private Date hiringDate;

	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	@Column(name="email_id", nullable = true, unique = true)
	private String emailId;

	// for emp to salary : one to many
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Salaries> salariesList = new ArrayList<>();


	// one employee works on multiple projects
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private List<Project> projectList = new ArrayList<>();


	// here we're getting the list of departments that employee previously worked on
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private List<Departments> departmentsList = new ArrayList<>();

	public Employee(String firstName, String lastName, Date birthDate, Gender gender, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.emailId = emailId;
	}

	public void setProjectList(boolean add) {
	}
}
