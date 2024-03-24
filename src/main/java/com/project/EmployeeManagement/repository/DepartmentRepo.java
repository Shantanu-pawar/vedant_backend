package com.project.EmployeeManagement.repository;

import com.project.EmployeeManagement.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Long> {

}
