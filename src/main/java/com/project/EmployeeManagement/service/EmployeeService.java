package com.project.EmployeeManagement.service;

import com.project.EmployeeManagement.Dto.Employee.AddEmpDto;
import com.project.EmployeeManagement.Dto.Employee.UpdateEmpDto;
import com.project.EmployeeManagement.model.Departments;
import com.project.EmployeeManagement.model.Salaries;
import com.project.EmployeeManagement.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EmployeeManagement.model.Employee;
import com.project.EmployeeManagement.repository.EmployeeRepo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo; // repo

	@Autowired private DepartmentRepo departmentRepo;

	public String createEmp(AddEmpDto dto) {
		Employee employee = new Employee(dto.getFirstName(), dto.getLastName(),
				dto.getBirthDate(), dto.getGender(), dto.getEmailId());
		employeeRepo.save(employee);

		Salaries salary = new Salaries();
		salary.setSalary(dto.getSalary());
		salary.setEmployee(employee);

		Departments department = new Departments();
		department.setDepartmentName(dto.getDepartmentName());
		department.setCurrentDepartmentHead(dto.getCurrentDepartmentHead());
		department.setEmployee(employee);
		departmentRepo.save(department);
		return "Employee added successfully";
	}

	public String updateEmp(UpdateEmpDto dto) {
		Optional<Employee> employeeOptional = employeeRepo.findById(dto.getEmpId());
		if(!employeeOptional.isPresent()){
			return "employee Id is invalid! Recheck your Id";
		}
		Employee employee = employeeOptional.get();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setBirthDate(dto.getBirthDate());
		return "Employee updated Successfully";
	}

	public String deleteEmployee(Long id) {
		Optional<Employee> op = employeeRepo.findById(id);
		if(!op.isPresent()) {
			return "kindly enter Correct employee id";
		}
		employeeRepo.delete(op.get());
		return "Employee deleted successfully";
	}

	public List<Employee> getAllEmployeeList() {
		List<Employee> list = employeeRepo.findAll();
		return list;
	}

	public Employee getEmployee(Long id){
		Optional<Employee> op = employeeRepo.findById(id);
		return op.get();
	}

	public List<Employee> searchByKeyword(String firstName) {
		return employeeRepo.findByfirstNameContaining(firstName);
	}

//	public List<Employee> load() {
//		List<Employee> employees = new ArrayList<Employee>(Arrays.asList(
//						new Employee(1,"Vedant","Jakatdar","vedant@tcs.com"),
//						new Employee(2,"Shubham","Jadhav","shubham@capgemini.com"),
//						new Employee(3,"Sandip","Khaire","sandip@polycab.com"),
//						new Employee(4,"Rohan","Chavan","rohan@hdfc.com")
//				));
//
//		return repo.saveAll(employees);
//	}


}
