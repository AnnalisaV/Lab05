package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	
	 	
		public static Connection getConnection() throws SQLException {

			String jdbcURL= "jdbc:mysql://localhost/dizionario?user=root&password=mary"; 
			return DriverManager.getConnection(jdbcURL); 
		}

	
}
