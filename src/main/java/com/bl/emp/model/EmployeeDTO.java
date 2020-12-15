package com.bl.emp.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

	@NotEmpty(message = "Name cannot be empty")
	private String name;
	private String gender;
	private String imagePath;
	private int salary;
	private Date startDate;
	private String notes;
	private String department;
	
	@Override
	public String toString() {
		return "EmployeeReqDO [name=" + name + ", gender=" + gender + ", imagePath=" + imagePath + ", salary=" + salary
				 + ", notes=" + notes + ", department=" + department + "]";
	}

	public EmployeeDTO() {
		super();
	}

	
	
	
}
