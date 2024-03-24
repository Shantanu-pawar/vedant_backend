package com.project.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;

    private int salary;

    @CreationTimestamp
    private Date fromDate;

    @UpdateTimestamp
    private Date toDate;

    @ManyToOne
    @JoinColumn
    private Employee employee;

}
