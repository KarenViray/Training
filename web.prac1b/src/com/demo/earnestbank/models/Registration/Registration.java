package com.demo.earnestbank.models.Registration;

public class Registration {
	private int registrationId;
	private String firstName;
		
	public Registration() {
	}

	public Registration(int registrationId, String firstName) {
		this.registrationId = registrationId;
		this.firstName = firstName;
	}
		
	
	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}

