package com.bl.emp.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public @Data class EmployeeDO {

	@NotEmpty(message = "Name cannot be empty")
	private String name;
	private String gender;
	private String imagePath;
	private int salary;
	private String startDate;
	private String notes;
	private String department;
	
	@Override
	public String toString() {
		return "EmployeeReqDO [name=" + name + ", gender=" + gender + ", imagePath=" + imagePath + ", salary=" + salary
				+ ", startDate=" + startDate + ", notes=" + notes + ", department=" + department + "]";
	}

	public EmployeeDO() {
		super();
	}

	
	
	
}
