package org.Hotel.server.config;

import java.sql.*;

/**
 * @author Jerry
 *
 */
public class Database {
	
	private static Database db=null;
	
	private Connection conn=null;
	private Statement stat=null;
	
	private String USER;
	private String PASSWORD;
	private String JDBC_DRIVER;
	private String DB_URL;
	
	private Database(){
		USER=DatabaseConfig.getUser();
		PASSWORD=DatabaseConfig.getPassword();
		JDBC_DRIVER=DatabaseConfig.getJDBC_DRIVER();
		DB_URL=DatabaseConfig.getDB_URL();
		
		connect();
	}
	
	public static Database getInstance(){
		if(db==null){
			return new Database();
		}
		else return db;
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
			stat.executeUpdate(query);
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Database db=Database.getInstance();
		String query="UPDATE hotel_strategy SET birthday_discount="+"'"+0.7+"',"
				+ "multiorder_discount="+"'"+1+"',"
				+ "enterprise_discount="+"'"+1+"',"
				+ "date_discount="+"'"+1+"'"
//				+ "start_date="+"'"+startdate+"',"
//				+ "end_date="+"'"+enddate+"'"		
				+ " WHERE hotel_name='南行酒店' and name='生日折扣'";
//		ResultSet rs=db.select(query);
		String s="";
		int i=1;
		try{	
			db.update(query);
//			while(rs.next()){
//				s+="name:"+rs.getString("name")+i+"\n";
//				i++;
//			}
			System.out.println(s);
			}
			catch(Exception e){
				e.printStackTrace();
			}finally{
			}
			db.close();
			String src=null;
			System.out.println(src);
		
	}
		
}

	
	

