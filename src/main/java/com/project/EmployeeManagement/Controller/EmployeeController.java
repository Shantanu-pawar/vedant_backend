package com.project.EmployeeManagement.Controller;

import java.util.List;

import com.project.EmployeeManagement.Dto.Employee.AddEmpDto;
import com.project.EmployeeManagement.Dto.Employee.UpdateEmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EmployeeManagement.model.Employee;
import com.project.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("employees")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired private	EmployeeService employeeService;

	/* LOGIC : in add employee when we're creating emp then
	we've to set the department information also

	so for that we gonna create one new department and set the params and then
	save it in that way we can able to see all the previous departments that he'd work on
	*/

	@PostMapping("new")
	public ResponseEntity<?> createEmp(@RequestBody AddEmpDto dto){
		String response = employeeService.createEmp(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("update-emp")
	public ResponseEntity<?> update(@RequestBody UpdateEmpDto dto){
		String response = employeeService.updateEmp(dto);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
		String response = employeeService.deleteEmployee(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("get-all")
	public ResponseEntity<?> getAllEmployees(){
		List<Employee> response = employeeService.getAllEmployeeList();
		return new ResponseEntity<>(response, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id){
		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
	}

	//searchEmployeeByfirstName
	@GetMapping("search/{firstName}")
	public List<Employee> searchByKeyword(@PathVariable("firstName") String firstName) {
		return	employeeService.searchByKeyword(firstName);
	}


	// forLoadingDataToDatabase
//	@GetMapping("load")
//	public List<Employee> load() {
//		return employeeService.load();
//	}
}
