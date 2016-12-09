package org.Hotel.server.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.Hotel.common.po.WebManagerPO;

import junit.framework.TestCase;

public class TestDatabaseConnection  {
	public static void main(String[] args){
		Database db=Database.getInstance();
		String query="SELECT * FROM web_manager";
		Map<String, WebManagerPO> map= new HashMap<String, WebManagerPO>();
		ResultSet rs=db.select(query);
		String s="";
		int i=1;
		try{	
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
			    
				WebManagerPO po=new WebManagerPO(name,password);
				map.put(name, po);
				System.out.println(po.getPassword());
			}
			}
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
			getWebManagerData();
		}
	public static Map<String, WebManagerPO> getWebManagerData() {
		Database db=Database.getInstance();
		
		String query="SELECT * FROM web_manager";
		Map<String, WebManagerPO> map= new HashMap<String, WebManagerPO>();
		
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
			    
				WebManagerPO po=new WebManagerPO(name,password);
				map.put(name, po);
				System.out.println(po.getPassword());
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}
	

}
