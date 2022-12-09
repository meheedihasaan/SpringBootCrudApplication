package com.crud.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.application.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
