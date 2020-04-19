package com.Rishabh.Hibernate;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*This class is an example of One-to-one, One-to-many and Many-to-many mapping*/

@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails {
	@Id @GeneratedValue
	@Column(name="CUSTOMER_ID")
	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/*
	 * @OneToOne is used for the one to one mapping. It generates a foreign key in the table in which 
	 * other table is mapped. 
	 * Here it created a default column in the main table, name as VEHICLE_VEHICLEID
	 * Again to change this column name we use @JoinColumn annotation.
	 */
	
	/*
	 * @OneToOne
	 * @JoinColumn(name="VEHICLE_ID") private Vehicle vehicle;
	 * 
	 * public Vehicle getVehicle() { return vehicle; } public void
	 * setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
	 */
	
	/*
	 * @OneToMany is used for one to many mapping. It generates an additional table
	 * with the primary keys of both the tables. Name of the table will be
	 * CUSTOMER_DETAILS_VEHICLE and that of columns will be
	 * CUSTOMERDETAILS_CUSTOMER_ID and VEHICLE_VEHICLE_ID
	 */ 
	
	/* @OneToMany(mappedBy="customer") */
	/*
	 * @JoinTable(name="CUSTOMER_VEHICLE" , joinColumns
	 * = @JoinColumn(name="CUSTOMER_ID"), inverseJoinColumns
	 * = @JoinColumn(name="VEHICLE_ID"))
	 */
	
	
	@OneToMany
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
	/*
	 * This way of establishing OneToMany relationship creates a new table which have
	 * primary keys of both CUSTOMER_DETAILS and VEHICLE table. There is one more
	 * way to represent OneToMany and ManyToOne relationship i.e. the object on the
	 * many side of the relationship has a reference of the other object.
	 * We can do it by other way using mappedBy  
	 */
	
	/* Many-to-Many mapping always creates a separate table. */
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name="CUSTOMERDETAILS_VEHICLE", joinColumns
	 * = @JoinColumn(name="CUSTOMER_ID"), inverseJoinColumns
	 * = @JoinColumn(name="VEHICLE_ID")) private Collection<Vehicle> vehicle = new
	 * ArrayList<Vehicle>();
	 * 
	 * public Collection<Vehicle> getVehicle() { return vehicle; } public void
	 * setVehicle(Collection<Vehicle> vehicle) { this.vehicle = vehicle; }
	 */
	
}
