package com.Rishabh.Hibernate;

import java.util.ArrayList;
import java.util.Collection;
/*import java.util.HashSet;
import java.util.Set;*/
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
/*import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;*/

@Entity
@Table(name="STUDENT_DETAILS")
public class StudentDetails {
	
	/* This is an example for working on the collections and the HIBERNATE proxy */ 
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	private int studentId;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/*
	 * used to tell HIBERNATE that this is a collection element It generates a new
	 * table which is having studentId as foreign key
	 * Name of the table will be StudentDetails_listOfAddresses and student Id column will be names as 
	 * StudentDetails_STUDENT_ID
	 */
	
	/*
	 * In order to have a index in the new table we need a collection which support indexing. We can't use Set.
	 */	
	/*
	 * @ElementCollection
	 * 
	 * @JoinTable(name="STUDENT_ADDRESS",
	 * joinColumns=@JoinColumn(name="STUDENT_ID")) private Set<Address>
	 * listOfAddresses = new HashSet<Address>();
	 * 
	 * public Set<Address> getListOfAddresses() { return listOfAddresses; } public
	 * void setListOfAddresses(Set<Address> listOfAddresses) { this.listOfAddresses
	 * = listOfAddresses; }
	 */
	@ElementCollection 
	@JoinTable(name="STUDENT_ADDRESS", joinColumns=@JoinColumn(name="STUDENT_ID"))
	/*
	 * @GenericGenerator(name = "increment-gen", strategy = "increment")
	 * @CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator =
	 * "increment-gen", type = @Type(type="long"))
	 */
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}
