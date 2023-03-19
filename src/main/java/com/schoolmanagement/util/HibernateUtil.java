package com.schoolmanagement.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

private static SessionFactory  sessionFactory = null;
private static Session session = null;

static {
	
	if(sessionFactory == null) {
		System.out.println("--> Generating Session Factory ");
		//Create Standard Service Registery  
		StandardServiceRegistry standardService = new StandardServiceRegistryBuilder().configure().build();
		
		//Create Meta Data source
		MetadataSources metaDataSource = new MetadataSources(standardService);
		
		//Create Meta Data 
		Metadata  metaData = metaDataSource.getMetadataBuilder().build();
		
		//Create Session Factory 
		sessionFactory = metaData.buildSessionFactory();
		
		//creating session 
		session = sessionFactory.openSession();
	}
	
}

public static SessionFactory getHiberNateMySqlSessionFactory() {
	if(sessionFactory != null) {
		System.out.println("--> getHiberNateMySqlSessionFactory");
		return sessionFactory;
	}
	return null;
}
	
	public static Session getHiberNateMySqlSession() {
		if(session != null) {
			System.out.println("--> getHiberNateMySqlSession");
			return session;
		}
		System.out.println("--> getting new current session");
		return sessionFactory.openSession();
	}
	
	public static boolean closeHibernateMySqlSession() {
		try {
			if(session != null) {
				session.close();
				System.out.println("--> closeHibernateMySqlSession ");
				return true;
			}
		} catch (Exception e) {
			System.out.println("--> Exception in closing HibernateMySqlSession");
			e.printStackTrace();
	    }
		return false;
		}
	

}
