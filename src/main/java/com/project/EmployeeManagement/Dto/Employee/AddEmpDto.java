package com.project.EmployeeManagement.Dto.Employee;

import com.project.EmployeeManagement.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmpDto {

    private String firstName;

    private String lastName;

    private Date birthDate;
    private Gender gender;
    private String emailId;

    // for salary entity
    private int salary;

    // extra params for saving dept entity
    private String departmentName;
    private String currentDepartmentHead;
}
