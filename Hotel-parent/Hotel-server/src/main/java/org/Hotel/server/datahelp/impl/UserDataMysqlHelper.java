package org.Hotel.server.datahelp.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.*;
import org.Hotel.server.config.Database;
import org.Hotel.server.datahelp.UserDataHelper;

public class UserDataMysqlHelper implements UserDataHelper {
	Database db;
	public Map<String, WebStaffPO> getWebStaffData() {
		db=Database.getInstance();
		String query="SELECT * FROM web_staff";
		Map<String, WebStaffPO> map= new HashMap<String, WebStaffPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
			    
				WebStaffPO po=new WebStaffPO(name,password);
				map.put(name, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}

	public void updateWebStaffData(WebStaffPO po) {
		db=Database.getInstance();
		
		int id=po.getId();
		String name=po.getName();
		String password=po.getPassword();
		
		String query="UPDATE web_staff SET name="+"'"+name+"',"
				+ "password="+"'"+password+"'"
				+ " WHERE id="+"'"+String.valueOf(id)+"'";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}
	//System do not has such feature
	public void deleteWebStaffData(WebStaffPO webstaffpo) {
		// TODO Auto-generated method stub
		
	}

	public void insertWebStaffData(WebStaffPO po) {
		db=Database.getInstance();
		
		String name=po.getName();
		String password=po.getPassword();
		
		String query="INSERT INTO web_staff(name,password) VALUE("+"'"+name+"',"
				+"'"+password+"')";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}
	/*
	 * return all hotel staff data
	 */
	public Map<String, HotelStaffPO> getHotelStaffData() {
		db=Database.getInstance();
		String query="SELECT * FROM hotel_staff";
		Map<String, HotelStaffPO> map= new HashMap<String, HotelStaffPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				String hotelname=rs.getString("hotel_name");
				String name=rs.getString("name");
				String password=rs.getString("password");
				    
				HotelStaffPO po=new HotelStaffPO(name,hotelname,password);
				map.put(name, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}

	public void updateHotelStaffData(HotelStaffPO po) {
		db=Database.getInstance();
		
		int id=po.getId();
		String name=po.getName();
		String password=po.getPassword();
		
		String query="UPDATE hotel_staff SET name="+"'"+name+"',"
				+ "password="+"'"+password+"'"
				+ " WHERE id="+"'"+id+"'";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}

	public void insertHotelStaffData(HotelStaffPO po) {
		db=Database.getInstance();
		
		String name=po.getName();
		String password=po.getPassword();
		String hotelname=po.getHotelName();
		
		String query="INSERT INTO hotel_staff(name,password,hotel_name) VALUE("+"'"+name+"',"
				+"'"+password+"','"+hotelname+"')";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}
	//System has no such feature
	public void deleteHotelStaffData(HotelStaffPO hotelstaffpo) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, WebManagerPO> getWebManagerData() {
		db=Database.getInstance();
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
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}
	

	//no further operation on web manager 
	public void updateWebManagerData(WebManagerPO webmanagerpo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteWebManagerData(WebManagerPO webmanagerpo) {
		// TODO Auto-generated method stub
		
	}

	public void insertWebManagerData(WebManagerPO webmanagerpo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteWebManagerData(WebStaffPO webmanagerpo) {
		// TODO Auto-generated method stub
		
	}

}
