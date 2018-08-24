package com.deloche.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloche.models.Employee;
import com.deloche.repository.EmployeRepo;


@Service
public class EmpoyeeDAO {
	
	
	
	@Autowired
	EmployeRepo employeerepo;
	
	
	
	//save an employee
	
	
    public Employee save(Employee ey) {
    	
    	
    	return employeerepo.save(ey);
    	
    }
	
	
	
	
	
	// get an employee by id
	
	
	
	public Employee findOne(Long id) {
		
		return employeerepo.findOne(id);
		
		
		
	}
	
	
	//update an employee
	
	
	
	
	
	
	
	
	
	
	// delete an employee
	
	public void delete(Employee ey) {
		
		
		employeerepo.delete(ey);
		
	}
	
	
	
	//get lsit of employees
	
	public List<Employee> findAll(){
		
		return employeerepo.findAll();
		
	}
	
	
}
