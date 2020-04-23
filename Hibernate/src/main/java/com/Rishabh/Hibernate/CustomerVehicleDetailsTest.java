package com.Rishabh.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerVehicleDetailsTest {

	public static void main(String[] args) {
		
		CustomerDetails customer1 = new CustomerDetails();
		customer1.setCustomerName("First User");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bike");
		
		customer1.getVehicle().add(vehicle1);
		
		/*
		 * for bidirectional mapping we need to add the customer in the vehicle also.
		 */
		
		/* this is for One-to-Many mapping
		 * vehicle1.setCustomer(customer); vehicle2.setCustomer(customer);
		 */
		
		/*
		 * vehicle1.getCustomerList().add(customer1);
		 * vehicle2.getCustomerList().add(customer1);
		 */
		
		/* For @NotFound annotation */
		vehicle1.setCustomer(customer1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/* session.save(customer1); */
		session.persist(customer1);
		
		/* To avoid session.save() every time we do cascading */ 
		
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
	}

}
