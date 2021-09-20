package com.example.RAKAssignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.RAKAssignment.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from EMPLOYEES e where e.name like %:name% ", nativeQuery = true)
	List<Employee> findByName(@Param("name") String name);

	@Query(value = "select * from EMPLOYEES where empno =:empNo ", nativeQuery = true)
	Employee getEmp(@Param("empNo") Long empNo);

}
