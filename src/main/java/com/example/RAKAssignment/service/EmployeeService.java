package com.example.RAKAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.RAKAssignment.Exception.ResourceNotFoundException;
import com.example.RAKAssignment.model.Employee;
import com.example.RAKAssignment.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee createEmployee(Employee emp) throws ResourceNotFoundException {
		Employee existEmp=employeeRepository.getEmp(emp.getEmpNo());
		if(existEmp==null) {
			return employeeRepository.save(emp);
		}else {
			throw new  ResourceNotFoundException("Employee Already Exist with this Number");
		}
	}

	public Employee upadteEmployee(Long empId, Employee employeeDetails) throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
		employee.setEmpName(employeeDetails.getEmpName());
		employee.setEmpDateOfJoin(employeeDetails.getEmpDateOfJoin());
		employee.setEmpNo(employeeDetails.getEmpNo());
		employee.setEmpDepartCode(employeeDetails.getEmpDepartCode());
		employee.setSalary(employeeDetails.getSalary());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}

	public ResponseEntity<Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employeeRepository.delete(employee);
		return ResponseEntity.ok().body(Boolean.TRUE);
	}

	public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	}

	public List<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByName(name);

	}
	
	public Employee getEmployeeByNumber(Long empNumber) {
		return employeeRepository.getEmp(empNumber);

	}

}
