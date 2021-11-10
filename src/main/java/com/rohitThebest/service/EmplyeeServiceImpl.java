package com.rohitThebest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohitThebest.dao.EmployeeRepository;
import com.rohitThebest.entity.Employee;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = employeeRepository.findById(id);

		Employee employee = null;

		if (result.isPresent()) {

			employee = result.get();
		} else {

			throw new RuntimeException("Did not find employee id : " + id);
		}

		return employee;
	}

	@Override
	public void save(Employee employee) {

		employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {

		employeeRepository.deleteById(id);
	}

}
