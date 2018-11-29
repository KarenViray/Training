package com.demo.model;

import java.util.List;

import javax.servlet.annotation.WebServlet;


public class ShoppingCart {
	private List<Cart> items;
	private int totalQty;
	private int totalPrice;
	
	
	public  ShoppingCart()
	{		
	}
	

	public ShoppingCart(List<Cart> items, int totalQty, int totalPrice) {
		this.items = items;
		this.totalQty = totalQty;
		this.totalPrice = totalPrice;
	}
	
	public void addToCart(Cart item) {	
		boolean isAdded = false;
		Cart addItem = null;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(item.getId())) {
				addItem = items.get(i);
				addItem.setQty(addItem.getQty() + item.getQty());
				addItem.setTotal(addItem.getQty() * addItem.getPrice());
				items.set(i, addItem);
				isAdded = true;
				break;
			}
		}
		if(!isAdded) {
			items.add(item);
		}
		totalQty += item.getQty();
		totalPrice += item.getTotal();	
	}
	
	public void removeItem(String itemId) {
		Cart removeItem = null;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(itemId)) {
				removeItem = items.get(i);
				items.remove(i);
				break;
			}
		}
		totalQty -= removeItem.getQty();
		totalPrice -= removeItem.getQty() * removeItem.getPrice();
	}
	
	
	public List<Cart> getItems() {
		return items;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
	
	
}	