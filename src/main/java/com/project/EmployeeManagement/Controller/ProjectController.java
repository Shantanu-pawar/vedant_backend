package com.project.EmployeeManagement.Controller;

import com.project.EmployeeManagement.Dto.Projects.AssignProjectDto;
import com.project.EmployeeManagement.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("project")
public class ProjectController {

    @Autowired private ProjectService projectService;

    @PostMapping("/create-and-assign-project")
    public ResponseEntity<?> assignProject(@RequestBody AssignProjectDto dto){
        try {
            String response = projectService.addProject(dto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
