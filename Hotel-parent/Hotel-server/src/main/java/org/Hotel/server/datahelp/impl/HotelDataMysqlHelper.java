package org.Hotel.server.datahelp.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.config.Database;
import org.Hotel.server.datahelp.HotelDataHelper;

public class HotelDataMysqlHelper implements HotelDataHelper {
	Database db;
	/*
	 * get all hotel data from mysql
	 * return map
	 */
	public Map<String, HotelPO> getHotelData() {
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
			}//end while
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}//end getHotelData

	/*
	 * updata a hotel record 
	 */
	public void updateHotelData(HotelPO hotelpo){
		db=Database.getInstance();
		//get attributes
		String name=hotelpo.getName();
		int star=hotelpo.getStar();
		double score=hotelpo.getGrade();
		String address=hotelpo.getAddress();
		String introduction=hotelpo.getIntroduction();
		int lsingler=hotelpo.getLeftSingleRoom();
		int lstandardr=hotelpo.getLeftStandardRoom();
		int lfamilyr=hotelpo.getLeftFamilyRoom();
		int lsuiter=hotelpo.getLeftSuiteRoom();
		
		String query="UPDATE hotel SET star="+"'"+star+"',"
				+ "score="+"'"+score+"',"
				 + "address="+"'"+address+"',"
				 + "introduction="+"'"+introduction+"',"
				+ "single_room_left="+"'"+lsingler+"',"
				+ "standard_room_left="+"'"+lstandardr+"',"
				+ "family_room_left="+"'"+lfamilyr+"',"
				+ "suite_room_left="+"'"+lsuiter+"'"
				+" WHERE name="+"'"+name+"'";
		
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end update hotel data
	/*
	 * insert a hotel record 
	 */
	public void insertHotelData(HotelPO hotelpo){
		db=Database.getInstance();
		//hotelinfo
		String name=hotelpo.getName();
		int star=hotelpo.getStar();
		double score=hotelpo.getGrade();
		String city=hotelpo.getCity();
		String address=hotelpo.getAddress();
		String introduction=hotelpo.getIntroduction();
		String circle=hotelpo.getCircle();
		//Room
		//room nums
		int singleRoom=hotelpo.getSingleRoom();
		int standardRoom=hotelpo.getStandardRoom();
		int familyRoom=hotelpo.getFamilyRoom();
		int	suiteRoom=hotelpo.getSuiteRoom();
		//left room nums
		int lsingleRoom=hotelpo.getLeftSingleRoom();
		int lstandardRoom=hotelpo.getLeftStandardRoom();
		int lfamilyRoom=hotelpo.getLeftFamilyRoom();
		int lsuiteRoom=hotelpo.getLeftSuiteRoom();
		//double room price
		double psingleRoom=hotelpo.getSingleRoomPrice();
		double pstandardRoom=hotelpo.getSingleRoomPrice();
		double pfamilyRoom=hotelpo.getFamilyRoomPrice();
		double psuiteRoom=hotelpo.getSuiteRoomPrice();
		
		try{
			String query="INSERT INTO hotel(name,star,score,city,address,introduction,circle,"
					+ "single_room,single_room_left,single_room_price,standard_room,standard_room_left,"
					+ "standard_room_price,family_room,family_room_left,family_room_price,"
					+ "suite_room,suite_room_left,suite_room_price) VALUE("
					+ "'"+name+"',"+
					"'"+String.valueOf(star)+"',"+
					"'"+String.valueOf(score)+"',"+
					"'"+city+"',"+
					"'"+address+"',"+
					"'"+circle+"',"+
					"'"+String.valueOf(singleRoom)+"',"+
					"'"+String.valueOf(lsingleRoom)+"',"+
					"'"+String.valueOf(psingleRoom)+"',"+
					"'"+String.valueOf(standardRoom)+"',"+
					"'"+String.valueOf(lstandardRoom)+"',"+
					"'"+String.valueOf(pstandardRoom)+"',"+
					"'"+String.valueOf(familyRoom)+"',"+
					"'"+String.valueOf(lfamilyRoom)+"',"+
					"'"+String.valueOf(pfamilyRoom)+"',"+
					"'"+String.valueOf(suiteRoom)+"',"+
					"'"+String.valueOf(lsuiteRoom)+"',"+
					"'"+String.valueOf(psuiteRoom)+"'"+")";
			
			db.update(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end insert hotel data
	
	/*
	 * delete a hotel record 
	 * not such feature in system
	 */
	public void deleteHotelData(HotelPO hotelpo){
	}
	// return all roominfo
	public Map<Integer, RoomPO> getRoomData() {
		db=Database.getInstance();
		Map<Integer, RoomPO> map=new HashMap<Integer,RoomPO>();
		String query="SELECT * FROM room";
		try{
			db=Database.getInstance();
			ResultSet roomrs=db.select(query);
			
			while(roomrs.next()){
				//room info
				int id=roomrs.getInt("id");
				int orderid=roomrs.getInt("order_id");
				String roomtype=roomrs.getString("type");
				String roomstate=roomrs.getString("state");
				String hotelname=roomrs.getString("hotel_id");
				//time
				String starttime=roomrs.getString("start_time");
				String leavetime=roomrs.getString("leave_time");
				
				RoomPO po=new RoomPO(roomtype,id, hotelname, roomstate,starttime, leavetime, orderid);
				map.put(id, po);
			}//end while
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}//end getRoomData
	
	/*
	 * system have no such feature
	 */
			
	public void updateRoomData(RoomPO po) {
		db=Database.getInstance();
		String state=po.getRoomstate();
		String starttime=po.getStarttime();
		String leavetime=po.getLeavetime();
		int orderid=po.getOrderid();
		String query="UPDATE room SET state="+"'"+state+"',"
				+ "start_time="+"'"+starttime+"',"
				 + "leave_time="+"'"+leavetime+"',"
				 + "order_id="+"'"+orderid+"'";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}		
	}//end update

	public void insertRoomData(RoomPO po) {
		db=Database.getInstance();
		String hotelName=po.getHotelid();
		String type=po.getRoomtype();
		
		String query="INSERT INTO room(hotel_name,type,state) VALUE("
				+"'"+ hotelName+"',"
				+"'"+ type+"',"
				+"'不可用'"
				+")";
	}
	//room don't have to delete
	public void deleteRoomData(RoomPO roompo) {
	}

	public Map<String, CirclePO> getCircleData() {
		String query="SELECT * FROM circle";
		db=Database.getInstance();
		Map<String,CirclePO> map=new HashMap<String,CirclePO>();
		ResultSet rs=db.select(query);
		try{
			while(rs.next()){
				String name=rs.getString("name");
				double discount=rs.getDouble("discount");
				String city = rs.getString("city");
				CirclePO po=new CirclePO(discount,  city,  name) ;
				map.put(name, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		// TODO Auto-generated method stub
		return null;
	}//end get circle data

	public void updateCircleData(CirclePO po) {
		db=Database.getInstance();
		
		String name=po.getName();
		String city=po.getCity();
		double discount=po.getDiscount();
		
		String query="UPDATE circle SET name="+"'"+name+"',"
				+ "city='"+city+"',"
				+ "discount='"+discount+"'";
		
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		// TODO Auto-generated method stub
		
	}//end update circle data

	//system has no such feature
	public void insertCircleData(CirclePO po) {
	}

	//system has no such feacher
	public void deleteCircleData(CirclePO po) {
	}
	
	

	
	
	

}