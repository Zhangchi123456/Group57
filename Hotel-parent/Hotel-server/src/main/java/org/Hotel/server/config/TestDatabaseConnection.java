package org.Hotel.server.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.OrderPO;
import org.Hotel.common.po.WebManagerPO;

import junit.framework.TestCase;

public class TestDatabaseConnection  {
	public static Database db=Database.getInstance();
	public static void main(String[] args){
		
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
//			getWebManagerData();
			getOrderData();
			getHotelData();
		}
//	public static Map<String, WebManagerPO> getWebManagerData() {
//		Database db=Database.getInstance();
//		
//		String query="SELECT * FROM web_manager";
//		Map<String, WebManagerPO> map= new HashMap<String, WebManagerPO>();
//		
//		try{
//			ResultSet rs=db.select(query);
//			while(rs.next()){
//				int id=rs.getInt("id");
//				String name=rs.getString("name");
//				String password=rs.getString("password");
//			    
//				WebManagerPO po=new WebManagerPO(name,password);
//				map.put(name, po);
//				System.out.println(po.getPassword());
//			}
//			return map;
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			db.close();
//		}
//		return null;
//	}
//	
//	
	public static Map<Integer, OrderPO> getOrderData() {
		Database db=Database.getInstance();
		Map<Integer, OrderPO> map=new HashMap<Integer, OrderPO>();
	String query="SELECT * FROM order1";
	try{
		ResultSet rs=db.select(query);
		while(rs.next()){
			//info
			int id=rs.getInt("id");
		
			int peoplenum=rs.getInt("people_num");
			double price=rs.getDouble("price");
			boolean havekids=rs.getBoolean("have_kids");
			
			String hotelname=rs.getString("hotel_name");
			String membername=rs.getString("member_name");
			String state=rs.getString("status");
			//date
			Date starttime=rs.getDate("start_time");
			Date endtime=rs.getDate("end_time");
			Date lasttime=rs.getDate("last_date");
			Date dischargetime=rs.getDate("remove_date");
			//room
			int singleRoom=rs.getInt("single_room");
			int standardRoom=rs.getInt("standard_room");
			int familyRoom=rs.getInt("family_room");
			int suiteRoom=rs.getInt("suite_room");
			//comment
			String comment=rs.getString("comment");
			double grade=rs.getDouble("score");
			
			OrderPO po=new OrderPO(id, membername, hotelname, starttime,
					endtime, state, price, lasttime,
					dischargetime, peoplenum,  havekids, singleRoom,
					standardRoom, familyRoom, suiteRoom, comment,grade);
			System.out.println(po.getName());
			map.put(id, po);
		}//end while
		return map;
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		db.close();
	}
	return null;
}//end get order data

	
	
	public static Map<String, HotelPO> getHotelData() {
		Map<String, HotelPO> map=new HashMap<String,HotelPO>();
		String query="SELECT * FROM hotel";
		try{
			db=Database.getInstance();
			ResultSet hotelrs=db.select(query);
			
			while(hotelrs.next()){
				//hotel info
				int id=hotelrs.getInt("id");
				String name=hotelrs.getString("name");
				String circle=hotelrs.getString("circle_name");
				double grade=hotelrs.getDouble("score");
				int star=hotelrs.getInt("star");
				String introduction=hotelrs.getString("introduction");
//				String facility=hotelrs.getString("facility");  facility attribute was emerged with introduction
				String city=hotelrs.getString("city");
				String address=hotelrs.getString("address");
				//room
				//room nums
				int singleRoom=hotelrs.getInt("single_room");
				int standardRoom=hotelrs.getInt("standard_room");
				int familyRoom=hotelrs.getInt("family_room");
				int suiteRoom=hotelrs.getInt("suite_room");
				//left room nums
				int leftSingleRoom=hotelrs.getInt("single_room_left");
				int leftStandardRoom=hotelrs.getInt("standard_room_left");
				int leftFamilyRoom=hotelrs.getInt("family_room_left");
				int leftSuiteRoom=hotelrs.getInt("suite_room_left");
				//room prices
				double singleRoomPrice=hotelrs.getDouble("single_room_price");
				double standardRoomPrice=hotelrs.getDouble("standard_room_price");
				double familyRoomPrice=hotelrs.getDouble("family_room_price");
				double suiteRoomPrice=hotelrs.getDouble("suite_room_price");
				
				HotelPO hotelpo=new HotelPO(name, circle, 
						star, grade,
						introduction,city,address,
						singleRoom,leftSingleRoom,
						standardRoom,leftStandardRoom,
						familyRoom,leftFamilyRoom,
						suiteRoom,leftSuiteRoom,
						singleRoomPrice,standardRoomPrice,
						familyRoomPrice,suiteRoomPrice);
				
				map.put(name, hotelpo);
				System.out.println(hotelpo.getName());
			}//end while
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		 db.close();
		}
		return null;
	}//end getHotelData


}
