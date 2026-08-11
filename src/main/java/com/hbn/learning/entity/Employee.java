package com.hbn.learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(
	name = "Employee.findEmployeeById", 
	query = "FROM abc E WHERE E.id > :id"
	)
@NamedQuery(
    name = "Employee.findByGender",
    query = "SELECT e FROM abc e WHERE e.gender = :gender"
)




@Entity(name = "abc")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name , gender;
	private int salary;
	@Transient
	private String compName;

	public Employee(String name , String gender , int salary , String compName) {
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}
	

	
}

