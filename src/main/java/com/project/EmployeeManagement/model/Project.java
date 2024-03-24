package com.project.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    private String projectName;

    private String projectHeadName;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    public Project(String projectName, String projectHeadName) {
        this.projectName = projectName;
        this.projectHeadName = projectHeadName;
    }
}