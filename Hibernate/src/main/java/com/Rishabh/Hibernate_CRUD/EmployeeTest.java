package com.Rishabh.Hibernate_CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.omg.PortableServer.POAManagerPackage.State;

/*This class is also used for the Transient, persistent and detached objects.*/ 

public class EmployeeTest {

	public static void main(String[] args) {

		/*
		 * Employee employee = new Employee();
		 * employee.setEmployeeName("Test Employee");
		 */

		/*
		 * To enter data in DB is a two step process. 
		 * 1. we need to instantiate the object of entity class. 
		 * 2. We need to save the object in the session.
		 */

		/* If we don't save the object of entity class in session then this object is called Transient object. */

		/* To track the object let's don't save the object and run the code: 
		 * it didn't entered any data but table is created.*/

		SessionFactory sessionFactory = new	Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();

		Employee employee = session.get(Employee.class, 1);
		
		/* After saving the object it is called the persisted object */

		//session.save(employee);

		/* If I want to update the user after saving the object it will allow me. */

		//employee.setEmployeeName("Updated Employee");

		/* If I update it again it will update it but in console you will see only one update query. */

		/* How does hibernate know what change to get reflected in data base? */
		/* After passing an entity object to session.save(object), if you do any change
		 * into that object it will trigger an update statement for that object. */ 

		//employee.setEmployeeName("Updated Employee Again");

		/*========== Data insertion (Create) ==========*/

		/*
		 * for(int i=1; i<=10; i++) { Employee employee = new Employee();
		 * employee.setEmployeeName("Employee "+i); session.save(employee); }
		 */

		/*========== Data retrieval (Read) ==========*/
		/*
		 * Employee employee = session.get(Employee.class, 6);
		 * System.out.println("Employee name from database is :"+employee.
		 * getEmployeeName());
		 */

		/*========== Data update (Update) ==========*/

		/* To update the data first we need to get the data and then update it. */

		/*
		 * Employee employee = session.get(Employee.class, 5);
		 * employee.setEmployeeName("Updated Employee Name"); session.update(employee);
		 */

		/*========== Data deletion (Delete) ==========*/

		/* To delete an object first we need to pull that object and then perform delete action.*/

		/*
		 * Employee employee = session.get(Employee.class, 6); session.delete(employee);
		 */

		session.getTransaction().commit();
		session.close();
		
		employee.setEmployeeName("Updated employee after session close");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.update(employee);
		
		/*
		 * If we don't update anything in the object and trying to update the object in
		 * next session then hibernate will run a update query because it doesn't know
		 * whether something is updated or not.
		 * To overcome this situation we can use hibernate @Entity(selectBeforeUpdate=true) annotation 
		 * on the Entity class.
		 */  
		/*
		 * Here two selects are happening first is for session.get() and second is for
		 * checking the current state of the object. 
		 * If no changes have been made then it will not do any other operation. 
		 */   
		
		
		//employee.setEmployeeName("Employee promoted after getting updated");
		session.update(employee);
		session.getTransaction().commit();
		session.close();
		
		/*
		 * After session.close() object is in detached State. It means first this object
		 * was entertained by hibernate but now it is not.
		 */ 
	}

}
