package com.Rishabh.Hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/* This is an example of inheritance */

@Entity
/* @DiscriminatorValue("3BHK_Property") */
public class PropertyDetails_3BHK extends PropertyDetails {

	@Column(name="PROPERTYDETAILS_3BHK")
	private String threeRooms;

	public String getThreeRooms() {
		return threeRooms;
	}

	public void setThreeRooms(String threeRooms) {
		this.threeRooms = threeRooms;
	}
	
}
