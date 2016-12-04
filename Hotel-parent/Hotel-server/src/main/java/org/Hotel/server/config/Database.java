package org.Hotel.server.config;

import java.sql.*;

/**
 * @author Jerry
 *
 */
public class Database {
	
	private Connection conn=null;
	private Statement stat=null;
	
	private String USER;
	private String PASSWORD;
	private String JDBC_DRIVER;
	private String DB_URL;
	
	public Database(){
		USER=DatabaseConfig.getUser();
		PASSWORD=DatabaseConfig.getPassword();
		JDBC_DRIVER=DatabaseConfig.getJDBC_DRIVER();
		DB_URL=DatabaseConfig.getDB_URL();
		
		connect();
	}
	
	public void connect(){
		try{
			
		Class.forName(JDBC_DRIVER);
		
		conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		stat=conn.createStatement();
		
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//close statement and connection
	public void close(){
		 try{
	         if(stat!=null)
	            stat.close();
	      }catch(SQLException se){
	    	   se.printStackTrace();
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	     }
	}
	//select query
	public ResultSet select(String query){
		ResultSet rs=null;
		try{
			rs=stat.executeQuery(query);
		}catch(SQLException se){
			se.printStackTrace();
		}
		return rs;
	}
	//update query	
	public void update(String query){
		try{
			stat.executeQuery(query);
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	
	
	
	

}
