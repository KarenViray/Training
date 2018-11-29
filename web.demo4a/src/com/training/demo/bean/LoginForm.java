package com.training.demo.bean;

import com.training.demo.util.FormValidator;

public class LoginForm extends AbstractForm {
	private String username;
	private String password;
	
	public LoginForm() {
		username = "";
		password = "";
	}
	
	@Override
	public void validate() {
		if(FormValidator.isNullOrEmpty(getUsername())) {
			setError("username", "Username required.");
		}
		
		if(FormValidator.isNullOrEmpty(getPassword())) {
			setError("password", "Password required.");
		}		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
