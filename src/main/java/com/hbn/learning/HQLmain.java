package com.hbn.learning;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.hbn.learning.entity.Employee;

public class HQLmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp = new Employee("Amit","male",25000 ,"Hcl");
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
//		session.persist(emp);
//		transaction.commit();
		
		
		//##### Old version
		//If your are not sure that object exist then use find()method
		Employee employee = session.find(Employee.class, 6);
		System.out.println(employee);
		
		//##### New version
		////If your are sure that object exist then use load()method
		session.load(emp, 27);
		System.out.println(emp);
		
		//######HQL to get all the records
		Query query = session.createQuery("From abc");
		List list = query.list();
		System.out.println(list);
		
		//#####HQL to get record with pagination
		Query query1 = session.createQuery("From abc");
		query.setFirstResult(3);
		query.setMaxResults(6);
		List list1 = query1.list();
		System.out.println(list1);
		
		//#####HCL record Update columns
		MutationQuery query2 = session.createMutationQuery("update abc set name =:n , salary =: s, where id =:i");
		query2.setParameter("n","Arvind");
		query2.setParameter("s","500000");
		query2.setParameter("i",4);
		query2.executeUpdate();
		transaction.commit();
		
		//#####HCL Delete Column
		MutationQuery query3 = session.createMutationQuery("delete from abc where id =:i");
		query3.setParameter("i",9);
		query3.executeUpdate();
		transaction.commit();
		
		
		
		//{***********************************************************
		//Aggregate method
		//#####HCL Sum()
		Query query4 = session.createQuery("Select sum(salary) from abc");
		System.out.println(query4.list());
		
		//#####HCL Max()
		Query query5 = session.createQuery("Select max(salary) from abc");
		System.out.println(query5.list());
		
		//#####HCL Min()
		Query query6 = session.createQuery("Select min(salary) from abc");
		System.out.println(query6.list());
		
		//#####HCL Avg()
		Query query7 = session.createQuery("Select avg(salary) from abc");
		System.out.println(query7.list());
		
		//#####HCL Count()
		Query query8 = session.createQuery("Select count(salary) from abc");
		System.out.println(query8.list());
		
		//}************************************************************
		
		
		
		
		//#####HQL from clause
		Query query9 = session.createQuery("FROM abc AS e WHERE e.salary > 40000 AND e.gender = 'male'");
		System.out.println(query9.list());
		
		
		//#####Select Clause
		Query query10 = session.createQuery("Select e.name from abc e");
		System.out.println(query10.list());
		
		//#####Where Clause
		Query query11 = session.createQuery("From abc e where e.id = 6");
		System.out.println(query11.list());
		
		
		//#####Using name parameter
		Query query12 = session.createQuery("From abc e where e.name=: name");
		query12.setParameter("name","Punit" );
		System.out.println(query12.list());
		
		//#####Order by Clause
		Query query13 = session.createQuery("FROM abc AS e ORDER BY e.salary DESC");
		System.out.println(query13.list());
		
		Query query14 = session.createQuery("FROM abc AS e ORDER BY e.salary ASC");
		System.out.println(query14.list());
		
		
		//#####Insert Clause
		Query query15 = session.createQuery(
			    "INSERT INTO abc (name, gender, salary) " +
			    "SELECT e.name, e.gender, e.salary FROM abc e"
			);
			System.out.println(query15.executeUpdate());
		

	}

}
