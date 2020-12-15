package com.bl.emp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.emp.model.EmployeeEntity;
import com.bl.emp.exception.BadRequestException;
import com.bl.emp.exception.NotFoundException;
import com.bl.emp.model.EmployeeDTO;
import com.bl.emp.model.ResponseDTO;
import com.bl.emp.repository.EmployeeRepository;
import com.bl.emp.service.IEmployeePayrollService;



@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ResponseDTO addEmployee(EmployeeDTO empReqDo) {

		if (empReqDo == null) {
			throw new BadRequestException("Name is not Proper");
		}
		EmployeeEntity empEntity = modelMapper.map(empReqDo, EmployeeEntity.class);
		empEntity = employeeRepository.save(empEntity);
		if (empEntity != null) {
			return new ResponseDTO("Successfully data inserted");
		} else {
			return new ResponseDTO("Failed to insert the Data");
		}

	}
	
//	@Override
//	public List<EmployeeDO> getEmployeeList() {
//		List<EmployeeEntity> empList = employeeRepository.findAll();
//		if(empList == null || empList.isEmpty()) {
//			throw new NotFoundException("No Data Found of any Employee");
//		}
//		return empList.stream().map(employee -> {
//			EmployeeDO emp = new EmployeeDO();
//			emp.setName(employee.getName());
//			emp.setDepartment(employee.getDepartment());
//			emp.setGender(employee.getGender());
//			emp.setImagePath(employee.getImagePath());
//			emp.setNotes(employee.getNotes());
//			emp.setSalary(employee.getSalary());
//			//emp.setStartDate(employee.getStartDate().toString());
//			return emp;
//		}).collect(Collectors.toList());
//	}
	
	@Override
	public List<EmployeeEntity> getEmployeeList(){
		List<EmployeeEntity> empList = employeeRepository.findAll();
		if(empList == null || empList.isEmpty()) {
			throw new NotFoundException("No Data Found of any Employee");
		}
		return empList;
	}
	
	@Override
	public ResponseDTO getEmployee(long empId) {
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity = employeeRepository.findById(empId).get();
		if(empEntity!= null) {
			return new ResponseDTO(empEntity.toString());
		} else {
			return new ResponseDTO("Failure data retrival");
		}
	}
	
	@Override
	public ResponseDTO deleteEmployee(long empId) {
		employeeRepository.deleteById(empId);
		return new ResponseDTO("Deleted");
	}
	
	@Override
	public ResponseDTO updateEmployee(long empId, EmployeeDTO empReqDo) {
		EmployeeEntity empEntity = employeeRepository.findById(empId).get();
		empEntity.setName(empReqDo.getName());
		empEntity.setDepartment(empReqDo.getDepartment());
		empEntity.setSalary(empReqDo.getSalary());
		empEntity.setGender(empReqDo.getGender());
		empEntity.setImagePath(empReqDo.getImagePath());
		empEntity.setStartDate(empReqDo.getStartDate());
		empEntity.setNotes(empReqDo.getNotes());
		empEntity = employeeRepository.save(empEntity);
		System.out.println(empEntity);
		System.out.println(empReqDo);
		if(empEntity!= null) {
			return new ResponseDTO("Success data updation");
		} else {
			return new ResponseDTO("Failure data updation");
		}
		
	}
}
