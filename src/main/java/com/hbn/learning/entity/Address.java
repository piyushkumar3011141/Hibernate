package com.hbn.learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity(name = "hbn")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	OneToOne Mapping Bidirectional Mapping
	@OneToOne(mappedBy = "address")
	private Employee employee;
	
	private String city , state;
	private int pincode;
	

	public Address(String city , String state , int pincode ) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	

	
}

