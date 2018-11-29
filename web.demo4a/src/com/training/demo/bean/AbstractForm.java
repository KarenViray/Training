package com.training.demo.bean;
import java.util.Hashtable;
import java.util.Map;

public abstract class AbstractForm {
	private Map<String, String> errors;	

	public AbstractForm() {
		errors = new Hashtable<String, String>();
	}
	
	public abstract void validate();	

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setError(String errorField, String errorMessage) {
		this.errors.put(errorField, errorMessage);
	}

	public String getError(String errorField) {
		String errorMessage = "";

		if (this.errors.get(errorField) != null) {
			errorMessage = this.errors.get(errorField);
		}

		return errorMessage;
	}	
	
	public boolean isFormValid() {
		return !(errors.size() > 0);
	}
	
}
