package com.hbn.learning.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity(name = "abc")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	// Many-to-Many relationship with Address
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_address")
	private Set<Address> addresses = new HashSet<>();
	
	
	private String name , gender;
	private int salary;
	

	public Employee(String name , String gender , int salary) {
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}
	public void addAddress(Address address) {
		this.addresses.add(address);
		address.getEmployees().add(this); // ensure bi-directional mapping
	}
	
	
}

