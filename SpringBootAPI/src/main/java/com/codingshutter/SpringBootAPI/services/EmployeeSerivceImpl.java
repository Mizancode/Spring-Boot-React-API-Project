package com.codingshutter.SpringBootAPI.services;

import java.util.ArrayList;
import java.util.List;

import com.codingshutter.SpringBootAPI.entity.EmployeeEntity;
import com.codingshutter.SpringBootAPI.model.Employee;
import com.codingshutter.SpringBootAPI.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSerivceImpl implements EmployeeSerivce{

    private final EmployeeRepository employeeRepository;


    EmployeeSerivceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
       // employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public Employee readEmployee(int id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
     
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);

        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees= new ArrayList<>();
   //    for(int i=0;i<employeesList.size();i++){
        for (EmployeeEntity employeeEntity : employeesList) {
            
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setFirstName(employeeEntity.getFirstName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setLastName(employeeEntity.getLastName());
          
            employees.add(emp);
        }
        return employees;     
    }

    @Override
    public boolean deleteEmployee(int id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
        EmployeeEntity exestingEmployee = employeeRepository.findById(id).get();
        
        exestingEmployee.setEmail(employee.getEmail());
        exestingEmployee.setFirstName(employee.getFirstName());
        exestingEmployee.setLastName(employee.getLastName());

        employeeRepository.save(exestingEmployee);
        
       return "Update Succesfully";
    }
   
}
