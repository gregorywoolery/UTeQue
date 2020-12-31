package com.connectionFactories.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.*;



public class SessionFactoryBuilder {
	
	private static final Configuration config = new Configuration();
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() throws HibernateException{
		if(sessionFactory == null) {
			config.configure("hibernate.cfg.xml");
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(StudentServicesAgent.class)
					.addAnnotatedClass(StudentServicesRep.class)
					.addAnnotatedClass(Issue.class)
					.addAnnotatedClass(Response.class)
					.addAnnotatedClass(Service.class)
					.buildSessionFactory();
		}
		
	return sessionFactory;
		
	}
	
	public static Session getSession() {
		if(sessionFactory != null)
			return sessionFactory.openSession();
		else return null;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
	
}
