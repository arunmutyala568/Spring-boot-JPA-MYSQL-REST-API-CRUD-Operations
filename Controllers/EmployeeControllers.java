package com.deloche.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloche.dao.EmpoyeeDAO;
import com.deloche.models.Employee;



@RestController
@RequestMapping("/details")
public class EmployeeControllers {
	
	@Autowired
	EmpoyeeDAO empoyeedao;
	
	
	//ssave an employee object to arun employee data base
	
	@PostMapping("/saveemployee")
	
	
	public Employee createemployee(@Valid @RequestBody Employee emp) {
		
		
		return empoyeedao.save(emp);
		
	}
	
	
	//get list of all employees
	
	@GetMapping("/employees")
	public List<Employee> getallEmployees(){
		
		return empoyeedao.findAll();
		
		
	}
	

	//get employee detail by id
	
	
	@GetMapping("/employees/{id}")
	
	public ResponseEntity<Employee> getemployeById(@PathVariable(value="id") Long empid){
		
		
		Employee emp=empoyeedao.findOne(empid);
		
		
		 if(empid==null)
			 
			 return ResponseEntity.notFound().build();
		 
		 
		 else
			 
			 return ResponseEntity.ok().body(emp);
		
		
		
	}
	
	
	
	//update employee in  arun data base
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateindividualemployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp2=empoyeedao.findOne(empid);
		
		if(emp2==null)
			
			return ResponseEntity.notFound().build();
		
		
		else
			
			emp2.setName(empDetails.getName());
		
		    emp2.setDesig(empDetails.getDesig());
		
		    Employee update=empoyeedao.save(emp2);
		    
		    return ResponseEntity.ok().body(update);
		
		
	}
	
	
	//Delete Employee in arun table
	
	
	@DeleteMapping("/employees/{id}")
	
	public ResponseEntity<Employee> deleteemployee(@PathVariable(value="id") Long empid){
		
		Employee emp1=empoyeedao.findOne(empid);
		
		if(empid==null) {
			
			
			ResponseEntity.notFound().build();
			
			
		}
		
		
		else {
			
			
			empoyeedao.delete(emp1);
			
			
		}
		
		return ResponseEntity.ok().build();
		
		
		
		
		
	}
	
	
	
	
	
}
