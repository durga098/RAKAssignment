package com.example.RAKAssignment.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.RAKAssignment.Exception.ResourceNotFoundException;
import com.example.RAKAssignment.model.Employee;
import com.example.RAKAssignment.service.EmployeeService;

@Controller
public class MvcController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/")
	public String homePage() {
		return "index";
	}

	@GetMapping(value = "/employee")
	public ModelAndView showForm(Model model) {
		Employee employee = new Employee();
		List<Employee> employees = empService.getAllEmployee();
		model.addAttribute("employee", employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee");
		mv.addObject("employees", employees);
		return mv;
	}

	@PostMapping("/employee")
	public ModelAndView submitForm(@ModelAttribute("employee") Employee employee) throws ResourceNotFoundException {
		empService.createEmployee(employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee");
		List<Employee> employees = empService.getAllEmployee();
		mv.addObject("employees", employees);
		return mv;

	}

	@GetMapping("/{id}")
	public ModelAndView updateEmployee(@PathVariable Long id) throws ResourceNotFoundException {
		Employee employee = empService.getEmployeeById(id);
		ModelAndView mav = new ModelAndView("employee_update");
		mav.addObject("employee", employee);
		return mav;
	}

	@GetMapping("/employee/{id}")
	public ModelAndView deteletEmployee(@PathVariable Long id) throws ResourceNotFoundException {
		empService.deleteEmployee(id);
		return new ModelAndView("redirect:/employee");

	}

	@GetMapping("/employee/search/{id}")
	public ModelAndView getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
		Employee searchemployee = empService.getEmployeeById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee");
		mv.addObject("searchemployee", searchemployee);
		return mv;

	}

	@GetMapping("/employee/withName")
	public ModelAndView getEmployeeByName(@RequestParam( value="empName" ,required = true) String empName) {
		List<Employee> emplist= empService.getEmployeeByName(empName);
		Employee employee = emplist.get(0);
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("employee",employee);
		mv.addObject("searchemployee", emplist);
		return mv;

	}

	@GetMapping("/employee/withNumber")
	public ModelAndView getEmployeeByNumber(@RequestParam( value="empNo" ,required = true) Long empNo) {
		Employee emp =empService.getEmployeeByNumber(empNo);
		List<Employee> emplist=new ArrayList<>();
		emplist.add(emp);
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("employee",emp);
		mv.addObject("searchemployee", emplist);
		return mv;
	}

}
