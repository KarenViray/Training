package com.training.demo.util;

public class FormValidator {
	public static boolean isNullOrEmpty(String stringValue) {
		return (stringValue == null || stringValue.trim().equals(""));
	}
}
