package com.Rishabh.Hibernate_Mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/*This class is an example of one-to-one, one-to-many, many-to-one and many-to-many mapping*/

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	
	@Id @GeneratedValue
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	@Column(name="VEHICLE_NAME")
	private String vehicleName;

	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	/*
	 * @ManyToOne
	 * @JoinColumn(name="USER_ID") private CustomerDetails customer;
	 * public CustomerDetails getCustomer() { return customer; } public void
	 * setCustomer(CustomerDetails customer) { this.customer = customer; }
	 */
	
	/*
	 * Assume that this vehicle is not having any owner. So what would happen if we
	 * have ManyToOne association here and vehicle don't have any customer then
	 * HIBERNATE will throw an exception.
	 * This exception can be overcome by @NotFound annotation
	 */
	
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private CustomerDetails customer;
	public CustomerDetails getCustomer() { return customer; } 
	public void setCustomer(CustomerDetails customer) { this.customer = customer; }
	
	
	/*
	 * @ManyToMany(mappedBy="vehicle") private Collection<CustomerDetails>
	 * customerList = new ArrayList<CustomerDetails>();
	 * public Collection<CustomerDetails> getCustomerList() { return customerList; }
	 * public void setCustomerList(Collection<CustomerDetails> customerList) {
	 * this.customerList = customerList; }
	 */
	
}
