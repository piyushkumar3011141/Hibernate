package com.hbn.learning;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfig {
	
	
	public static SessionFactory getSessionFactory()
	{
		
		Properties properties = new Properties();
		
		properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");	
		properties.put("jakarta.persistence.jdbc.url","jdbc:mysql://localhost:3306/java13");
		properties.put(Environment.JAKARTA_JDBC_USER,"root");
		properties.put(Environment.JAKARTA_JDBC_PASSWORD,"root");
		properties.put(Environment.HBM2DDL_AUTO,"update");
		properties.put(Environment.SHOW_SQL,"true");
		properties.put(Environment.FORMAT_SQL,"true");
		
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(properties).build();
		
		Metadata meta = new MetadataSources(ssr).addAnnotatedClasses(com.hbn.learning.entity.Employee.class,com.hbn.learning.entity.Address.class).getMetadataBuilder().build();
		
		return meta.buildSessionFactory();
		 
	}

}