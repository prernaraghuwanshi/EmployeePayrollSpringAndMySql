package com.bl.emp.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.bl.emp.exception.BadRequestException;
import com.bl.emp.model.EmployeeDTO;
import com.bl.emp.model.EmployeeEntity;
import com.bl.emp.model.ResponseDTO;

public interface IEmployeePayrollService {

	public ResponseDTO addEmployee(EmployeeDTO empReqDo);

	public List<EmployeeEntity> getEmployeeList();
	
	public ResponseDTO getEmployee(long empId);
	
	public ResponseDTO deleteEmployee(long empId);

	public ResponseDTO updateEmployee(long empId, EmployeeDTO emp);
}
