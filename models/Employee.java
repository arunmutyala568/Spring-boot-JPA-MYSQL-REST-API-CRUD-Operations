package com.deloche.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;



@Entity
@Table(name="employee")
public class Employee {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	private String name;

	private String desig;
	
	
	
	
	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	
	private Date created;
	
	
	
	
	public Date getCreated() {
		return created;
	}




	public void setCreated(Date created) {
		this.created = created;
	}




	public Employee() {
		
		
	}


	

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesig() {
		return desig;
	}


	public void setDesig(String desig) {
		this.desig = desig;
	}
	

}
