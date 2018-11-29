package com.demo.earnestbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.earnestbank.models.AccountHolder;

public class AccountHolderDAO {
	private static final String JDBC_URL = "jdbc:mysql://192.168.1.167:3306/earnestbank?";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "$$IT_@dmin";

	private Connection connection;

	public AccountHolderDAO() {
		loadDriver();
		initializeConnection();
	}

	public List<AccountHolder> findAll() {
		List<AccountHolder> accounts = new ArrayList<>();

		try {
			final Connection conn = getConnection();
			PreparedStatement selectAccountSql = conn.prepareStatement("SELECT AccountId, RegistrationId, Balance FROM account_holder");
			final ResultSet result = selectAccountSql.executeQuery();
			while (result.next()) {
				AccountHolder accountHolder = new AccountHolder(result.getString(1), result.getInt(2), result.getFloat(3));
				accounts.add(accountHolder);
			}

			selectAccountSql.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
	}
	
	public List<AccountHolder> findByBalance(float balance) {
		List<AccountHolder> accounts = new ArrayList<>();

		try {
			final Connection conn = getConnection();
			PreparedStatement selectAccountSql = conn.prepareStatement("SELECT AccountId, RegistrationId, Balance FROM account_holder WHERE Balance <= ?");
			selectAccountSql.setFloat(1, balance);
			
			final ResultSet result = selectAccountSql.executeQuery();
			while (result.next()) {
				AccountHolder accountHolder = new AccountHolder(result.getString(1), result.getInt(2), result.getFloat(3));
				accounts.add(accountHolder);
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
