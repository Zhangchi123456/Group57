package org.Hotel.server.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.TestCase;

public class TestDatabaseConnection extends TestCase {
	public static void main(String[] args){
		Database db=Database.getInstance();
		String query="SELECT * FROM hotel";
		ResultSet rs=db.select(query);
		String s="";
		int i=1;
		try{	
			while(rs.next()){
				s+="name:"+rs.getString("name")+i+"\n";
				i++;
			}
			System.out.println(s);}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			db.close();
			String src=null;
			System.out.println(src);
		}
		

}
