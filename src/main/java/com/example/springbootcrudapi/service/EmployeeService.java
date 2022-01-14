package com.example.springbootcrudapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrudapi.model.Employee;
import com.example.springbootcrudapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Create
    public List<Employee> createEmployeeList(List<Employee> list) {
        return employeeRepository.saveAll(list);
    }

    // Read
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    // Read
    public Employee getEmployeeById(int empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    // Update
    public Employee updateEmployeeById(int empId, Employee employee) {
        Optional<Employee> employeeFound = employeeRepository.findById(empId);

        if (employeeFound.isPresent()) {
            Employee employeeUpdate = employeeFound.get();
            employeeUpdate.setFirstName(employee.getFirstName());
            employeeUpdate.setLastName(employee.getLastName());
            employeeUpdate.setEmail(employee.getEmail());

            return employeeRepository.save(employeeUpdate);
        } else {
            return null;
        }
    }

    // Delete
    public String deleteEmployeeById(int empId) {
        employeeRepository.deleteById(empId);
        return "Employee "+ empId +" deleted";
    }
}
