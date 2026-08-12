package com.hbn.learning;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.hbn.learning.entity.Address;
import com.hbn.learning.entity.Employee;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create configuration and build session factory
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // Create session
        Session session = factory.openSession();
        session.beginTransaction();

        // Create addresses
        Address address1 = new Address("New York","USA",002112);
        Address address2 = new Address("San Francisco","USA",002112);

        // Create employees
        Employee emp1 = new Employee("John Doe","USA",002112);
        Employee emp2 = new Employee("Jane Smith","USA",002112);

        // Establish many-to-many relationships
        emp1.addAddress(address1);
        emp1.addAddress(address2);

        emp2.addAddress(address1);  // shared address

        // Save employees (cascades addresses)
        session.persist(emp1);
        session.persist(emp2);

        session.getTransaction().commit();
        session.close();

        factory.close();
		
		
	}

}
