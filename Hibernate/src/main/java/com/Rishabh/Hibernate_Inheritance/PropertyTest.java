package com.Rishabh.Hibernate_Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* This is an example of inheritance */

public class PropertyTest {
	
	public static void main(String[] args) {
		
		PropertyDetails property = new PropertyDetails();
		property.setPropertyName("Appartment");
		
		PropertyDetails_2BHK twoBHK = new PropertyDetails_2BHK();
		twoBHK.setPropertyName("B501");
		twoBHK.setTwoRooms("two");
		
		PropertyDetails_3BHK threeBHK = new PropertyDetails_3BHK();
		threeBHK.setPropertyName("C2-704");
		threeBHK.setThreeRooms("three");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(property);
		session.save(twoBHK);
		session.save(threeBHK);
		session.getTransaction().commit();
		session.close();
		
	}

}
