package com.barclays.employeeMS.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	// getting the connection object
	public static Connection getConnection() {
		Properties properties = readPropertyFile();
		Connection connection = null;
		if (properties != null) {

			try {
				connection = DriverManager.getConnection(
						properties.getProperty("db.url"),
						properties.getProperty("db.username"), 
						properties.getProperty("db.password"));

				return connection;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return connection;
	}
	// closing the connection
	
	public static void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// reading the property file spec.(application.properties)
	private static Properties readPropertyFile() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("application.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			// key value pair
			return properties;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
