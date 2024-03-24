package com.project.EmployeeManagement.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deptId;

    private String departmentName;

    private String currentDepartmentHead;

    @Timestamp
    private Date fromDate;

    private Date toDate;

//    mapped with employee so that whenever someone hit the Id,
//    it will reflect the department information
    @ManyToOne
    @JoinColumn
    private Employee employee;

}
