package com.bl.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.emp.model.EmployeeDTO;
import com.bl.emp.model.ResponseDTO;
import com.bl.emp.service.IEmployeePayrollService;

@RestController
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO emp) {
		return new ResponseEntity(employeePayrollService.addEmployee(emp),HttpStatus.OK);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<EmployeeDTO>> getEmployeeList() {
		return new ResponseEntity(employeePayrollService.getEmployeeList(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable("empId") long empId) {
		return new ResponseEntity(employeePayrollService.getEmployee(empId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable("empId") long empId) {
		return new ResponseEntity(employeePayrollService.deleteEmployee(empId),HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("empId") long empId, @RequestBody EmployeeDTO emp) {
		return new ResponseEntity(employeePayrollService.updateEmployee(empId,emp),HttpStatus.OK);
	}
}
