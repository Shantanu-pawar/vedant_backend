package com.project.EmployeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.EmployeeManagement.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	public List<Employee> findByfirstNameContaining(String firstName);

	Optional<Employee> findByEmailId(String employeeEmail);
}
