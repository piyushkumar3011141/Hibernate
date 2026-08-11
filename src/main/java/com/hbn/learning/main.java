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
		session.persist(emp);
		transaction.commit();

	}

}
