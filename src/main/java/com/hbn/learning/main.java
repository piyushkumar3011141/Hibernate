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
		Address add1 = new Address("Uk", "Uk" , 202984);
		Address add2 = new Address("Ghaziabad", "UP" , 202984);
		Address add3 = new Address("Nodia", "UP" , 202984);
		Address add4 = new Address("Nodia74", "UP" , 209423);
		
		List<Address> listOfAdd = new ArrayList<>();
		listOfAdd.add(add1);
		listOfAdd.add(add2);
		listOfAdd.add(add3);
		listOfAdd.add(add4);
		
		
		Employee emp = new Employee("Punit","male",100000);
		emp.setAddress(listOfAdd);
		
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.persist(emp);
		transaction.commit();

		
		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		
		
	}

}
