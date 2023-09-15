package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
	
	public static String dbName = "doc_connect";
	public static String user = "root";
	public static String pass = "";
	public static String hostName = "localhost";
	public static String dbDriver = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			
			Class.forName(dbDriver);
			String url = "jdbc:mysql://" + hostName + "/" + dbName;
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected Database...");
			return connection;
			
		} catch (Exception e) {
			System.out.println("Not Connected Database...");
		}
		
		return null;
	}
}