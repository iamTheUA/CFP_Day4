package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeRepo;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeRepo er;
	
	/**
	 *url:"/emp/23"
	 *to get Employee Details
	 * @param id
	 * @return employee json obj
	 */
	@GetMapping("/{id}")
	public Employee get(@PathVariable int id) {
		return er.findById(id).orElse(null);
	}
	
	@PostMapping(path="/add",consumes = "application/json")
	public String post(@RequestBody Employee emp) {
		er.save(emp);
		return "added!";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		er.delete( er.findById(id).orElse(null));
		return "Deleted";
	}
	
	@PostMapping("/update")
	public String update(@RequestBody Employee emp) {
		er.deleteById(emp.getId());
		er.save(emp);
		return "updated!";
	}
	
}
