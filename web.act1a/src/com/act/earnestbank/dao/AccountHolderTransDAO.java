package com.act.earnestbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.act.earnestbank.models.AccountHolderTrans;

public class AccountHolderTransDAO {
	private static final String JDBC_URL = "jdbc:mysql://192.168.1.167:3306/earnestbank?";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "$$IT_@dmin";

	private Connection connection;

	public AccountHolderTransDAO() {
		loadDriver();
		initializeConnection();
	}
	
	
	public List<AccountHolderTrans> findById(String id) {
		List<AccountHolderTrans> accounts = new ArrayList<>();

		try {
			final Connection conn = getConnection();
			PreparedStatement selectAccountSql = conn.prepareStatement("SELECT Account_Id, Date_of_Transaction, Amount FROM account_holder_transaction WHERE Account_Id = ?");
			selectAccountSql.setString(1, id);
									
			final ResultSet result = selectAccountSql.executeQuery();
			while (result.next()) {
				AccountHolderTrans accountHolderTrans = new AccountHolderTrans(result.getString(1),result.getDate(2), result.getFloat(3));
				accounts.add(accountHolderTrans);
			}

			selectAccountSql.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
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
				this.connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
			}
		} catch (SQLException e) {
			System.out.println("Failed to create sql connection.");
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
}

