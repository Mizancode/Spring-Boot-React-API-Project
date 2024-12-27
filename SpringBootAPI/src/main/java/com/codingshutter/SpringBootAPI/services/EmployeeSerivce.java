package com.codingshutter.SpringBootAPI.services;

import java.util.List;

import com.codingshutter.SpringBootAPI.model.Employee;

public interface EmployeeSerivce {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(int id);
    String updateEmployee(int id, Employee employee);
    Employee readEmployee(int id);

}
