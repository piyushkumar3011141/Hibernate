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
		Address add1 = new Address("Delhi", "Delhi" , 110032);
		
		Employee emp = new Employee("Piyush","male",100000);
		emp.setAddress(add1);
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
<<<<<<< Updated upstream
		session.persist(emp);
		transaction.commit();
=======
		
		
//		session.persist(emp);
//		session.persist(add1);
//		transaction.commit();
//		
		
		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		
		Address address = session.find(Address.class, 1);
		System.out.println(address);
>>>>>>> Stashed changes

	}

}
