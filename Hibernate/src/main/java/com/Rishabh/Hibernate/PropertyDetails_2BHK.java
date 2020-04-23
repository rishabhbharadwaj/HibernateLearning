package com.Rishabh.Hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/* This is an example of inheritance */

@Entity
/* @DiscriminatorValue("2BHK_Property") */
public class PropertyDetails_2BHK extends PropertyDetails {

	@Column(name="PROPERTYDETAILS_2BHK")
	private String twoRooms;

	public String getTwoRooms() {
		return twoRooms;
	}

	public void setTwoRooms(String twoRooms) {
		this.twoRooms = twoRooms;
	}
	
}
