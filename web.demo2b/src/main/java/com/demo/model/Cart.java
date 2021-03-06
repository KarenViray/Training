package com.demo.model;

	public class Cart {
		private String id;
		private String name;
		private String desc;
		private int price;
		private int qty;
		private int total;
		
		
		public Cart() {		
		}
		
		
		public Cart(String id, String name, String desc, int price, int qty, int total) {
			this.id = id;
			this.name = name;
			this.desc =desc;
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
		
						
		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}
		
		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}


}
