package org.Hotel.server.datahelp.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

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
			db=new Database();
			ResultSet hotelrs=db.select(query);
			
			while(hotelrs.next()){
				//hotel info
				int id=hotelrs.getInt("id");
				String name=hotelrs.getString("name");
				//get circle from circle table from mysql
				int circle_id=hotelrs.getInt("circle");
				String circle=getCircle(db,circle_id);
				
				int star=hotelrs.getInt("star");
				double grade=hotelrs.getInt("score");
				String introduction=hotelrs.getString("introduction");
				String facility=hotelrs.getString("facility");
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

	private String getCircle(Database db, int circle_id) {
		String query="SELECT name FROM circle WHERE id="+String.valueOf(circle_id);
		ResultSet rs;
		String res=null;
		try{
			rs=db.select(query);
			if(rs.next()){
				res=rs.getString("name");
				return res;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	/*
	 * updata a hotel record 
	 */
	public void updateHotelData(HotelPO hotelpo){
		db=new Database();
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
			db=new Database();
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}
	
	/*
	 * insert a hotel record 
	 */
	public void insertHotelData(HotelPO hotelpo){
		db=new Database();
		//hotelinfo
		String name=hotelpo.getName();
		int star=hotelpo.getStar();
		double score=hotelpo.getGrade();
		String city=hotelpo.getCity();
		String address=hotelpo.getAddress();
		String introduction=hotelpo.getIntroduction();
		//get circle id from mysql
		String circle=hotelpo.getCircle();
		int circleID=getCircleID(db,circle);
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
			String query="INSERT INTO hotel(name,star,score,city,address,introduction,circle_id,"
					+ "single_room,single_room_left,single_room_price,standard_room,standard_room_left,"
					+ "standard_room_price,family_room,family_room_left,family_room_price,"
					+ "suite_room,suite_room_left,suite_room_price) VALUE("
					+ "'"+name+"',"+
					"'"+String.valueOf(star)+"',"+
					"'"+String.valueOf(score)+"',"+
					"'"+city+"',"+
					"'"+address+"',"+
					"'"+String.valueOf(circleID)+"',"+
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
					"'"+String.valueOf(psuiteRoom)+"',"+")";
			
			db.update(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end insert
	//get circle id from my sql by circle name
	private int getCircleID(Database db,String name){
		String query="SELECT id FROM circle WHERE name="+"'"+name+"'";
		ResultSet rs;
		int res;
		try{
			rs=db.select(query);
			if(rs.next()){
				res=rs.getInt("id");
				return res;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return -1;
	}
	
	/*
	 * delete a hotel record 
	 */
	public void deleteHotelData(HotelPO hotelpo){
		db=new Database();
		String name=hotelpo.getName();
		String query="DELETE FROM hotel WHERE name='"+name+"'";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}

	public Map<Integer, RoomPO> getRoomData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateRoomData(RoomPO roompo) {
		// TODO Auto-generated method stub
		
	}

	public void insertRoomData(RoomPO roompo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRoomData(RoomPO roompo) {
		// TODO Auto-generated method stub
		
	}

	public Map<String, CirclePO> getCircleData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCircleData(CirclePO circlepo) {
		// TODO Auto-generated method stub
		
	}

	public void insertCircleData(CirclePO circlepo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCircleData(CirclePO circlepo) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	

}