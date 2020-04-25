package com.Rishabh.Hibernate_BasicAnnotation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // - used to define that this class is not an Entity
public class Address {
	@Column(name = "STREET_NAME")
	private String Street;
	@Column(name = "CITY_NAME")
	private String City;
	@Column(name = "STATE_NAME")
	private String State;
	@Column(name = "PIN_CODE")
	private String PinCode;
	
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	
	

}
