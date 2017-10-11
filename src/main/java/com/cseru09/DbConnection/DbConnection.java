package com.cseru09.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String user= "postgres";
	private static String pass= "password";
	
	private static Connection connection = null;
	
	public static Connection getDbConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, user, pass);
		return connection;
	}
}
