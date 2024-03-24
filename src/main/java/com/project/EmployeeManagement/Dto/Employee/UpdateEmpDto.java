package com.project.EmployeeManagement.Dto.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmpDto {

    private long empId;

    private String firstName;

    private String lastName;

    private Date birthDate;

}
