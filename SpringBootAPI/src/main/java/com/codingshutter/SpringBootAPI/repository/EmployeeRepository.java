package com.codingshutter.SpringBootAPI.repository;

import com.codingshutter.SpringBootAPI.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    
}
