package com.hbn.learning;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.hbn.learning.entity.Employee;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee("Piyush kumar","male",100000 ,"Hcl");
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Query<Employee> query = session.createNamedQuery("Employee.findEmployeeById", Employee.class);
		query.setParameter("id", "5");
		List<Employee> employees = query.getResultList();
		System.out.println(employees);

		System.out.println();

		Query<Employee> q = session.createNamedQuery("Employee.findByGender", Employee.class);
		q.setParameter("gender", "male");
		System.out.println(q.list());
		
		session.persist(emp);
		transaction.commit();

	}

}
