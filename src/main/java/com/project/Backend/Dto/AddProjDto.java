package com.project.Backend.Dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AddProjDto {

    private long projectId;
    private String projectName;
    private String projectHeadName;
    private String employeeEmail;

}
