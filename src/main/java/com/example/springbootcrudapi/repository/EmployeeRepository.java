package com.example.springbootcrudapi.repository;

import com.example.springbootcrudapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}