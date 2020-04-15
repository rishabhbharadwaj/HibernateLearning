package com.Rishabh.Hibernate;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
//import javax.persistence.Transient;
import javax.persistence.TemporalType;

@Entity 
@Table (name="USER_DETAILS")
public class UserDetails {
	
	/* This is an example for the basic annotations of HIBERNATE. */
	
	/*
	 * Primary key can be of two ways 
	 * 1. Natural : which we will use in our business such as an authenticator in the login 
	 * 2. Surrogate : which we use just for the unique purpose. In present case we can assume that 
	 * userId is a surrogate key because it is just for the unique purpose.
	 */
	@Id @GeneratedValue // @GenetarerValue generates a unique value automatically.
	@Column (name="USER_ID")
	private int userId;
	/*
	 * We can use @EmbeddedId annotation to make a composite primary key. It
	 * requires a class in which all the variable(whose combination makes primary
	 * key) should present and the class should be annotated as @Embeddable
	 */
	
	public int getUserId() {
		return userId;
	}
		
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name="USER_NAME")
	private String userName;
	// we can add annotations on the getter methods of the columns also.
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="JOINED_DATE")
	private Date joinedDate;
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	/*
	 * It is basically large object. There are two types of large objects. 
	 * 1. Character large object CLOB 
	 * 2. Byte stream that is BLOB
	 * If LOB is on top of a String variable then it assumes it as CLOB
	 * If LOB is on top of a Byte array so in that case it assume it as BLOB
	 */
	@Lob
	@Column(name="DESCRIPTION")
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	/* Scenario: We have two types of address one is home address and one is office address. 
	 * We are using the same Address class to get the address values.
	 * In the address class we have defined the column names by annotation @Column.
	 * So if we use the same class for home address then it will generate the columns in DB with those names
	 * And it will not allow us to generate columns again with the same name in DB. 
	 * To over come this situation we use annotation @AttributesOverride 
	 */ 
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="Street", column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="City", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="State", column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="PinCode", column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="Street", column=@Column(name="OFFICE_STREET_NAME")),
		@AttributeOverride(name="City", column=@Column(name="OFFICE_CITY_NAME")),
		@AttributeOverride(name="State", column=@Column(name="OFFICE_STATE_NAME")),
		@AttributeOverride(name="PinCode", column=@Column(name="OFFICE_PIN_CODE"))
	})
	private Address officeAddress;
	
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	//@Transient - to not store the particular field in the data base we use Transient
	/* private String address; 
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 */	
}

