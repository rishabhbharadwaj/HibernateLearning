package com.Rishabh.Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDetailsTest {
	
	public static void main(String[] args) {
		
		Address address = new Address();
		address.setCity("Meerut");
		address.setPinCode("250002");
		address.setState("UP");
		address.setStreet("Hapur Road");
		
		UserDetails user1 = new UserDetails();
		//user.setUserId(1); - not using because we are generating keys automatically.
		user1.setUserName("Rishabh");
		user1.setJoinedDate(new Date());
		user1.setDescription("Desc");
		user1.setHomeAddress(address);
		user1.setOfficeAddress(address);
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Prakriti");
		user2.setJoinedDate(new Date());
		user2.setDescription("desc");
		user2.setHomeAddress(address);
		user2.setOfficeAddress(address);
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		// To fetch data from the DB
		/*
		 * user = null; session = sessionFactory.openSession();
		 * session.beginTransaction();
		 * 
		 * user = session.get(UserDetails.class, 1);
		 * System.out.println("Name from table is : "+user.getUserName());
		 */
	}

}
