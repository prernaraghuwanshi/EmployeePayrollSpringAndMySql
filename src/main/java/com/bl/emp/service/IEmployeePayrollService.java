package com.bl.emp.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.bl.emp.exception.BadRequestException;
import com.bl.emp.model.EmployeeDO;
import com.bl.emp.model.ResponseDo;

public interface IEmployeePayrollService {

	public ResponseDo addEmployee(EmployeeDO empReqDo);

	public List<EmployeeDO> getEmployeeList();
	
	public ResponseDo getEmployee(long empId);
	
	public ResponseDo deleteEmployee(long empId);

	public ResponseDo updateEmployee(long empId, EmployeeDO emp);
}
