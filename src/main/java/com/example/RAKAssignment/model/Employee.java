package com.example.RAKAssignment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String empName;

	@Column(name = "empno")
	private Long empNo;

	@Column(name = "empDateOfJoin")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date empDateOfJoin;

	@Column(name = "empDepartCode")
	private String empDepartCode;

	@Column(name = "salary")
	private double salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public Date getEmpDateOfJoin() {
		return empDateOfJoin;
	}

	public void setEmpDateOfJoin(Date empDateOfJoin) {
		this.empDateOfJoin = empDateOfJoin;
	}

	public String getEmpDepartCode() {
		return empDepartCode;
	}

	public void setEmpDepartCode(String empDepartCode) {
		this.empDepartCode = empDepartCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
