package com.Rishabh.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDetailsTest {

	public static void main(String[] args) {
		
		Address addr1 = new Address();
		addr1.setCity("Meerut");
		addr1.setState("UP");
		addr1.setPinCode("250002");
		addr1.setStreet("Hapur Road");
		
		Address addr2 = new Address();
		addr2.setCity("Kanpur");
		addr2.setPinCode("450012");
		addr2.setState("UP");
		addr2.setStreet("Rawatpur pullia");
		
		StudentDetails student = new StudentDetails();
		student.setStudentName("Rishabh");
		student.getListOfAddresses().add(addr1);
		student.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
		student = null;
		
		session = sessionFactory.openSession();
		student = session.get(StudentDetails.class, 1);
		/*
		 * HIBERNATE proxy class - hibernate insteed of getting the actual object that you are looking for, 
		 * it gets you a proxy, it is a dynamic subclass of your actual object
		 * When we do StudentDetails.get() then what hibernate does is, instead of giving the StudentClass directly 
		 * which means pulling all the values and then packaging all the values in the student class and then handling it to you,
		 * it create a proxy student class which is a sub class of the student class and hence the same methods. 
		 * It fills all the first level values not the lists associated with the student class and it hands you the object of the proxy user class.
		 * You would not know because proxy class implements the same methods.
		 * Talking about the list, proxy object doesn't provide the values for the list.
		 * When you make a call to fetch the details of the list object, proxy method is coded in such a way that first it fetches the data from the DB
		 * and then provide it to the the studentDetails.get().
		 */    
		// lets do a quick check first close the session and check it will throw an error: failed to lazily initialize a collection of role 
		session.close();
		System.out.println(student.getStudentName()); // getting value of the first level variable but not getting the value of lists. 
		System.out.println(student.getListOfAddresses().size());
		/*
		 * There is still a possibility to get the list value after the closure of the session.
		 * It is called eager fetch type
		 * by default it is set to lazy fetch type.
		 * @ElementCollection(fetch=FetchType.EAGER)
		 */
		
	}

}
