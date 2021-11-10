package com.rohitThebest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohitThebest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// add a method sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
