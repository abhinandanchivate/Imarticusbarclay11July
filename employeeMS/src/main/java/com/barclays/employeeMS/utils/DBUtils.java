package com.barclays.employeeMS.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // will provide the singleton object 
// it will be applied on the utility classes.

public class DBUtils {
	
	@Autowired
	DataSource dataSource;
	// getting the connection object
	public  Connection getConnection() {
		Properties properties = null;
		Connection connection = null;
		

			try {
				connection = dataSource.getConnection();

			//	return connection;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return connection;
	}
	// closing the connection
	
	public  void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// reading the property file spec.(application.properties)
//	private static Properties readPropertyFile() {
//		FileInputStream fileInputStream = null;
//		try {
//			fileInputStream = new FileInputStream("application.properties");
//			Properties properties = new Properties();
//			properties.load(fileInputStream);
//			// key value pair
//			return properties;
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				fileInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

}
