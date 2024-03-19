package com.project.Backend.service;

import com.project.Backend.Dto.AddProjDto;
import com.project.Backend.model.Employee;
import com.project.Backend.model.Project;
import com.project.Backend.repository.EmployeeRepo;
import com.project.Backend.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired private ProjectRepo projectRepo;
    @Autowired private EmployeeRepo employeeRepo;

    public String addProject(AddProjDto dto) throws RuntimeException {

        Optional<Employee> op = employeeRepo.findByEmail(dto.getEmployeeEmail());
        if(!op.isPresent()){
            throw new RuntimeException("Email is invalid, kindly enter valid email");
        }

        Project project = new Project(dto.getProjectId(),
                dto.getProjectName(), dto.getProjectHeadName());

        project.setEmployee(op.get());
        projectRepo.save(project);
        return "project added successfully";
    }
}
