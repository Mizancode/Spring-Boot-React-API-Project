package com.codingshutter.SpringBootAPI.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.codingshutter.SpringBootAPI.model.Employee;
import com.codingshutter.SpringBootAPI.services.EmployeeSerivce;



@RestController
@CrossOrigin("http://localhost:3000/")
public class EmpController {
    
    private final EmployeeSerivce employeeSerivce;

    EmpController(EmployeeSerivce employeeSerivce) {
        this.employeeSerivce = employeeSerivce;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeSerivce.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        System.out.println("Yes me a raha hu ");
        return employeeSerivce.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        //employees.add(employee);
        return employeeSerivce.createEmployee(employee);
        
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeSerivce.deleteEmployee(id))
            return "Delete Succesfully";
        return "Not found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Employee employee) {
        return employeeSerivce.updateEmployee(id, employee);
    }
    
    
}
