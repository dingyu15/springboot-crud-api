package com.example.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcrudapi.model.Employee;
import com.example.springbootcrudapi.service.EmployeeService;

@RestController
//@RequestMapping("/api")//this is the base url for api
//this api will be accessible from http://localhost:8080/
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(empId));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PostMapping("/employees/bulk")
    public ResponseEntity<List<Employee>> addBulkEmployees(@RequestBody List<Employee> list) {
        return ResponseEntity.ok(employeeService.createEmployeeList(list));
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.updateEmployeeById(empId, employee));
    }

    @DeleteMapping("/employees/{empId}")
    public HttpStatus deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployeeById(empId);
        return HttpStatus.OK;
    }
}
