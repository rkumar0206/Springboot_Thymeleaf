package com.rohitThebest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohitThebest.entity.Employee;
import com.rohitThebest.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model model) {

		// get employee from db
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);

		// this will go to templates/employees/list-employees
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee theEmployee = new Employee();
		
		model.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		// save the employee
		employeeService.save(employee);

		// post/redirect/get
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		// get the employee from the service
		Employee employee = employeeService.findById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		
		// send over to our form
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		// delete the employee
		employeeService.delete(id);
		
		// redirect to /employee/list
		
		return "redirect:/employees/list";
	}
	
}
