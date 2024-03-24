package com.project.EmployeeManagement.service;

import com.project.EmployeeManagement.Dto.Projects.AssignProjectDto;
import com.project.EmployeeManagement.model.Employee;
import com.project.EmployeeManagement.model.Project;
import com.project.EmployeeManagement.repository.EmployeeRepo;
import com.project.EmployeeManagement.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired private ProjectRepo projectRepo;
    @Autowired private EmployeeRepo employeeRepo;

    public String addProject(AssignProjectDto dto) throws RuntimeException {

        Optional<Employee> op = employeeRepo.findById(dto.getEmpId());
        if(!op.isPresent()){
            throw new RuntimeException("Employee ID is invalid, kindly enter valid ID!");
        }
        Employee employee = op.get();
        Project project = new Project(dto.getProjectName(),dto.getProjectHeadName());
        project.setEmployee(employee);
        projectRepo.save(project);

        employee.setProjectList(employee.getProjectList().add(project));
        employeeRepo.save(employee);
        return "project added successfully";
    }
}
