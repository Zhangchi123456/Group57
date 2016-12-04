package org.Hotel.server.config;

/**
 * @author Jerry
 *mysql configuration
 */
public abstract class DatabaseConfig {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost/ohrsdata?autoReconnect=true&useSSL=false";
	private static String USER="root";
	private static String PASSWORD="5386317439";
	
	/**
	 *set up User,Password,JDBC driver,database URL
	 */
	public static void setUser(String user){
		USER=user;
	}
	
	public static void setPassword(String password){
		PASSWORD=password;
	}
	
	public static void setJDBC_DRIVER(String driver){
		JDBC_DRIVER=driver;
	}
	
	public static void setDB_URL(String URL){
		DB_URL=URL;
	}
	
	//getter
	public static String getDB_URL(){
		return DB_URL;
	}
	
	public static String getUser(){
		return USER;
	}
	
	public static String getPassword(){
		return PASSWORD;
	}
	
	public static String getJDBC_DRIVER(){
		return JDBC_DRIVER;
	}

}
