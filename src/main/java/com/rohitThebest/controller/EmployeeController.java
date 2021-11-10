package com.rohitThebest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rohitThebest.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees;

	@PostConstruct
	public void loadData() {

		employees = new ArrayList<>();

		Employee e1 = new Employee(1, "Rohit", "Kumar", "rohit.kumar@rtb.com");
		Employee e2 = new Employee(2, "Mohit", "Kumar", "mohit.kumar@rtb.com");
		Employee e3 = new Employee(1, "Sagar", "Singh", "sagar.singh@rtb.com");

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {

		model.addAttribute("employees", employees);

		return "list-employees";
	}

}
