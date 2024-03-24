package com.project.EmployeeManagement.repository;

import com.project.EmployeeManagement.model.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salaries, Long> {
}
