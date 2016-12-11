package org.Hotel.server.datahelp.impl;

import java.util.Date;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.Hotel.common.po.OrderPO;
import org.Hotel.server.config.Database;
import org.Hotel.server.datahelp.OrderDataHelper;

public class OrderDataMysqlHelper implements OrderDataHelper {
	Database db;
	public Map<Integer, OrderPO> getOrderData() {
		db=Database.getInstance();
		Map<Integer, OrderPO> map=new HashMap<Integer, OrderPO>();
		
		String query="SELECT * FROM order1";
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				//order info
				int id=rs.getInt("id");
				int peoplenum=rs.getInt("people_num");
				double price=rs.getDouble("price");
				boolean havekids=rs.getBoolean("have_kids");
				
				String hotelname=rs.getString("hotel_name");
				String membername=rs.getString("member_name");
				String state=rs.getString("status");
				//date
				String starttime=rs.getString("start_time");
				String endtime=rs.getString("end_time");
				String lasttime=rs.getString("last_time");
				String dischargetime=rs.getString("remove_time");
				//room
				int singleRoom=rs.getInt("single_room");
				int standardRoom=rs.getInt("standard_room");
				int familyRoom=rs.getInt("family_room");
				int suiteRoom=rs.getInt("suite_room");
				//comment
				String comment=rs.getString("comment");
				double grade=rs.getDouble("score");
				//initial order po
				OrderPO po=new OrderPO(id, membername, hotelname, starttime,
						endtime, state, price, lasttime,
						dischargetime, peoplenum,  havekids, singleRoom,
						standardRoom, familyRoom, suiteRoom, comment,grade);
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

	public void updateOrderData(OrderPO orderpo) {
		db=Database.getInstance();
		//order info
		int id=orderpo.getId();
		double grade=orderpo.getGrade();
		
		String state=orderpo.getState();
		String comment=orderpo.getComment();
		//date
		String dischargetime=orderpo.getDischargetime();
		//comment
		String query="UPDATE order1 SET status='"+state+"',"
				+ "remove_time='"+dischargetime+"',"
				+ "comment='"+comment+"',"
				+ "score='"+grade+"'"
				+ " WHERE id='"+id+"'";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end update order

	public void insertOrderData(OrderPO po) {
		db=Database.getInstance();
		// order info
		int id=po.getId();
		int peoplenum=po.getPeoplenum();
		boolean havekids1=po.isHavekids();
		int havekids=0;
		if(havekids1){
			havekids=1;
		}
		double price=po.getPrice();
		double grade=po.getGrade();
		
		String comment=po.getComment();
		String hotelname=po.getHotelid();
		String membername=po.getName();
		String state=po.getState();
		//date
		String starttime=po.getStarttime();
		String endtime=po.getLeavetime();
		String lasttime=po.getLasttime();
		
		String dischargetime=po.getDischargetime();
		//room
		int singleRoom=po.getSingleRoom();
		int standardRoom=po.getStandardRoom();
		int familyRoom=po.getFamilyRoom();
		int suiteRoom=po.getSuiteRoom();
		
		String query="INSERT INTO order1(hotel_name,member_name,start_time,end_time,last_time,"
				+"remove_time,people_num,have_kids,single_room,standard_room,family_room"
				+",suite_room,status,comment,score) VALUE("
				
				+"'"+hotelname+"',"+ "'"+membername+"',"+ "'"+starttime+"',"
				+"'"+endtime+"',"+ "'"+lasttime+"',"
				+"'"+dischargetime+"',"+"'"+peoplenum+"',"
				+"'"+havekids+"',"+"'"+singleRoom+"',"
				+"'"+standardRoom+"',"+"'"+familyRoom+"',"
				+"'"+suiteRoom+"',"+"'"+state+"',"
				+"'"+comment+"',"+"'"+grade+"'"
				+ ")";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}//end insert order data
	
	//get member id by member name
	//add member name to order table so no need to call member id
	private int getmemberid(Database db, String membername) {
		return 0;
	}

	//no such feature
	public void deleteOrderData(OrderPO orderpo) {
	}

}
