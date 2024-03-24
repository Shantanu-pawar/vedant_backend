package com.project.EmployeeManagement.Dto.Projects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AssignProjectDto {

    private String projectName;

    private String projectHeadName;

    private long empId;
}
