package com.demo.model;

import java.util.Map;

public class Product {
	private String id;
	private String name;
	private String desc;
	private String authorId;
	private int price;
	private Map<String, String> errors;	
	
	
	public Product() {		
	}
	
	
	public Product(String id, String name, String desc, int price) {
		this.id = id;
		this.name = name;
		this.desc =desc;
		this.price= price;				
	}
	
	public Product(String id, String name, String desc, String authorId, int price) {
		this.id = id;
		this.name = name;
		this.desc =desc;
		this.authorId=authorId;
		this.price= price;				
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getAuthor() {
		return authorId;
	}

	public void setAuthor(String authorId) {
		this.authorId = authorId;
	}
			
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public boolean isFormValid() {
		return !(errors.size() > 0);
	}
	
}
