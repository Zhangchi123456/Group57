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
		
//		String query="SELECT order.id,order.hotel_name,order.statr_time"
//				+ ",order.end_time,order.last_time,order.remove_time,order.people_num,order.have_kids,"
//				+ "order.single_room,order.standard_room,order.family_room,order.suite_room,"
//				+ "order.status,order.price,order.comment,order.score,member.name AS member_name"
//				+ " FROM order,member WHERE order.member_id=member.id";
		String query="SELECT * FROM order";
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				//info
				int id=rs.getInt("id");
				String hotelname=rs.getString("hotel_name");
				int memberid=rs.getInt("member_id");
				String membername=null;
				String state=rs.getString("status");
				double price=rs.getDouble("price");
				int peoplenum=rs.getInt("people_num");
				boolean havekids=rs.getBoolean("have_kids");
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
	}

	

	public void updateOrderData(OrderPO orderpo) {
		db=Database.getInstance();
		//order info
		int id=orderpo.getId();
		String state=orderpo.getState();
		//date
		Date dischargetime=orderpo.getDischargetime();
		//comment
		String comment=orderpo.getComment();
		double grade=orderpo.getGrade();
		
		String query="UPDATE order SET status='"+state+"',"
				+ "remove_time='"+String.valueOf(dischargetime)+"',"
				+ "comment='"+comment+"',"
				+ "score='"+String.valueOf(grade)+"'"
				+ " WHERE id='"+String.valueOf(id)+"'";
		try{
			db.select(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}

	public void insertOrderData(OrderPO po) {
		db=Database.getInstance();
		//info
		int id=po.getId();
		String hotelname=po.getHotelid();
		String membername=po.getName();
		int memberid=getmemberid(db,membername);
		String state=po.getState();
		double price=po.getPrice();
		int peoplenum=po.getPeoplenum();
		boolean havekids=po.isHavekids();
		//date
		Date starttime=po.getStarttime();
		Date endtime=po.getLeavetime();
		Date lasttime=po.getLasttime();
		Date dischargetime=po.getDischargetime();
		//room
		int singleRoom=po.getSingleRoom();
		int standardRoom=po.getStandardRoom();
		int familyRoom=po.getFamilyRoom();
		int suiteRoom=po.getSuiteRoom();
		//comment
		String comment=po.getComment();
		double grade=po.getGrade();
		
		String query="INSERT INTO member(hotel_name,member_id,start_time,end_time,last_time,"
				+ "remove_time,people_num,have_kids,single_room,standard_room,family_room"
				+ ",suite_room,status,comment,score) VALUE("
				+ "'"+hotelname+"',"+ "'"+String.valueOf(memberid)+"',"+ "'"+String.valueOf(starttime)+"',"+ 
				"'"+String.valueOf(endtime)+"',"+ "'"+String.valueOf(lasttime)+"',"+
				"'"+String.valueOf(dischargetime)+"',"+"'"+String.valueOf(peoplenum)
				+"',"+"'"+String.valueOf(havekids)+"',"+"'"+String.valueOf(singleRoom)+"',"
				+"'"+String.valueOf(standardRoom)+"',"+"'"+String.valueOf(familyRoom)+"',"
				+"'"+String.valueOf(suiteRoom)+"',"+"'"+state+"',"
				+"'"+comment+"',"+"'"+String.valueOf(grade)+"'"
				+ ")";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}
	//get member id by member name
	private int getmemberid(Database db, String membername) {
		String query="SELECT id FROM member WHERE name='"+membername+"'";
		try{
			ResultSet rs=db.select(query);
			if(rs.next()){
				int id=rs.getInt("id");
				return id;			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}



	//no such feature
	public void deleteOrderData(OrderPO orderpo) {
		// TODO Auto-generated method stub
		
	}

}
