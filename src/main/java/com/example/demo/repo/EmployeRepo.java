package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
public interface EmployeRepo extends JpaRepository<Employee, Integer> {

}
