package com.bl.emp.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class EmployeeEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NAME",length = 35)
	private String name;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "IMAGEPATH")
	private String imagePath;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "STARTDATE")
	private Date startDate;
	@Column(name = "NOTES")
	private String notes;
	@Column(name = "DEPARTMENT", length= 35)
	private String department;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		//startDate = new Date();
		this.startDate = startDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", gender=" + gender + ", imagePath=" + imagePath
				+ ", salary=" + salary + ", startDate=" + startDate + ", notes=" + notes + ", department=" + department
				+ "]";
	}
	
	
	
	
}
