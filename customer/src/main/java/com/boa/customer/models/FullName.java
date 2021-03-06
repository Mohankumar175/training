package com.boa.customer.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class FullName {

	@Column(name="First_Name",length = 50,nullable = false)
	private String firstName;
	@Column(name="Last_Name",length = 50,nullable = false)
	private String lastName;
	@Column(name="Middle_Name",length = 50)
	private String middleName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
}
