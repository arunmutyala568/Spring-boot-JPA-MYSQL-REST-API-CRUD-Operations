package com.deloche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloche.models.Employee;

public interface EmployeRepo extends JpaRepository<Employee,Long> {

}
