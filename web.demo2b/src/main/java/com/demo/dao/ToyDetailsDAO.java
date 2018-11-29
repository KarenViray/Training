package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Product;

public class ToyDetailsDAO {
	
	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;

	private Connection connection;

	public ToyDetailsDAO(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		this.jdbcUrl = jdbcUrl;

		loadDriver();
		initializeConnection();
	}
	
	
	public List<Product> findToy() {
		List<Product> products = new ArrayList<>();

		try {
			final Connection conn = getConnection();
			PreparedStatement selectAccountSql = conn.prepareStatement("SELECT TID, TName, TDesc, TPrice FROM toysdetails");
			final ResultSet result = selectAccountSql.executeQuery();
			while (result.next()) {
				Product toyDetails = new Product(result.getString(1), result.getString(2), result.getString(3), result.getInt(4));
				products.add(toyDetails);
			}

			selectAccountSql.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	
	public boolean addToy(Product product) {
		String id = product.getId(); 
		String name = product.getName(); 
		String desc = product.getDesc();
		int price = product.getPrice();
		boolean success = false;
		try {
			final Connection conn = getConnection();
			String statement = "INSERT INTO toysdetails VALUES(?,?,?)";
			PreparedStatement addToySql = conn.prepareStatement(statement);
			addToySql.setString(1, id);
			addToySql.setString(2, name);
			addToySql.setString(3, desc);
			//addToySql.setInt(4, price);
			success =  addToySql.execute(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	
	private void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load MySQL JDBC driver.");
		}
	}

	private void initializeConnection() {
		try {
			if (connection == null) {
				this.connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
			}
		} catch (SQLException e) {
			System.out.println("Failed to create sql connection.");
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
