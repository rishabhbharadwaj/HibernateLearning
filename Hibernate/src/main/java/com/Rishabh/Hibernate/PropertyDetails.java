package com.Rishabh.Hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/* This is an example of inheritance */

/* This class is extended by two other classes PropertyDetails_2BHK and PropertyDetails_3BHK
 * HIBERNATE create a common class for all the classes and create a column name as "DTYPE"(discriminator) and 
 * provide the class name to understand to which class this object belong.
 * We can change the discriminator column properties by using @DiscrimnatorColumn.  
 * Discriminator is required only for the Single table inheritance strategy.
 * It is least normalized strategy.
 */

@Entity
/* @Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
 * By default it has single table strategy.
 * / 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
/*
 * It creates separate tables for all the classes. Parent class properties are
 * inherited and a separate column was created. It creates normalized form of data.
 * While creating separate tables, vehicleID and vehicleName columns are repeating for each table.
 * we can design this better by using JOINED strategy.  
 * It generates table of child class with a specified column in it and an inherited column from the parent class, 
 * which acts as a primary key.
 * We can check the complete data by using "join".
 * SELECT *
		FROM PropertyDetails
        JOIN PropertyDetails_2BHK
        ON PropertyDetails.PROPERTY_ID= PropertyDetails_2BHK.PROPERTY_ID 
 */
/*
 * @DiscriminatorColumn( name="PROPERTY_TYPE",
 * discriminatorType=DiscriminatorType.STRING // by default it is string. )
 */
@Inheritance(strategy=InheritanceType.JOINED)
public class PropertyDetails {
	@Id @GeneratedValue
	@Column(name="PROPERTY_ID")
	private int PropertyId;
	public int getPropertyId() {
		return PropertyId;
	}
	public void setPropertyId(int propertyId) {
		PropertyId = propertyId;
	}
	@Column(name="PROPERTY_NAME")
	private String PropertyName;
	public String getPropertyName() {
		return PropertyName;
	}
	public void setPropertyName(String propertyName) {
		PropertyName = propertyName;
	}
	
}
