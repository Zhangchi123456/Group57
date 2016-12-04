package org.Hotel.server.datahelp.impl;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.Hotel.server.config.Database;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;
import org.Hotel.common.po.WebStaffPO;
import org.Hotel.server.datahelp.PromotionDataHelper;

public class PromotionDataMysqlHelper implements PromotionDataHelper {
	Database db;
	public Map<String, HotelPromotionPO> getHotelPromotionData() {
		db=new Database();
		String query="SELECT * FROM web_staff";
		Map<String, WebStaffPO> map= new HashMap<String, WebStaffPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
			   
				HotelPromotionPO po=new HotelPromotionPO(type, hotelid,birthdaydiscount,multiorderdiscount,
						enterpricediscount,datediscount,startdate,enddate);
//				map.put(id, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}
	/*
	 * update a record of hotel promotion
	 */
	public void updateHotelPromotionData(HotelPromotionPO po) {
		db=new Database();
		
		int id=0;
//		int id=po.getID();
		double birthdaydiscount=po.getBirthdaydiscount();
		double multiorderdiscount=po.getMultiorderdiscount();
		double enterpricediscount=po.getEnterpricediscount();
		double datediscount=po.getDatediscount();
		Date startdate=po.getStartdate();
		Date enddate=po.getEnddate();
		
		String query="UPDATE hotel_strategy SET bithday_discount="+"'"+String.valueOf(birthdaydiscount)+"',"
				+ "multiorder_discount="+"'"+String.valueOf(multiorderdiscount)+"',"
				+ "enterprice_discount_discount="+"'"+String.valueOf(enterpricediscount)+"',"
				+ "date_discount="+"'"+String.valueOf(datediscount)+"',"
				+ "start_date="+"'"+String.valueOf(startdate)+"',"
				+ "end_date="+"'"+String.valueOf(enddate)+"'"		
				+ " WHERE id="+"'"+String.valueOf(id)+"'"	;
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}
	
	public void insertHotelPromotionData(HotelPromotionPO po) {
		db=new Database();
		//hotel promotion info
		String type=po.getType();
		String hotelid=po.getHotelid();
		double birthdaydiscount=po.getBirthdaydiscount();
		double multiorderdiscount=po.getMultiorderdiscount();
		double enterpricediscount=po.getEnterpricediscount();
		double datediscount=po.getDatediscount();
		Date startdate=po.getStartdate();
		Date enddate=po.getEnddate();
		
		String query="INSERT INTO hotel_strategy(hotel_name,birthday_discount,"
				+ "multiorder_discount,enterprice_discount,date_discount"
				+ "start_date,end_date,name) VALUE("
				+ "'"+hotelid+"',"+ "'"+String.valueOf(birthdaydiscount)+"',"+ "'"
				+String.valueOf(multiorderdiscount)+"',"+ 
				"'"+String.valueOf(enterpricediscount)+"',"+ "'"+
				String.valueOf(datediscount)+"',"+
				"'"+String.valueOf(startdate)+"',"+"'"+String.valueOf(enddate)
				+"',"+"'"+type+"')";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end insert hotel promotion
	
	public void deleteHotelPromotionData(HotelPromotionPO po) {
//		db=new Database();
//		int id=po.getId();
//		String query="DELETE hotel_strategy WHERE id='"+id+"'";
//		try{
//			db.update(query);
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			db.close();
//		}
//		
	}
	
	public Map<Date, WebPromotionPO> getWebPromotionData() {
		db=new Database();
		String query="SELECT * FROM web_strategy";
		Map<Date, WebPromotionPO> map= new HashMap<Date, WebPromotionPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				double datediscount=rs.getDouble("date_discount");
				Date startdate=rs.getDate("start_date");
				Date enddate=rs.getDate("end_date");
				
				WebPromotionPO po=new WebPromotionPO(datediscount,startdate,enddate);
				map.put(startdate, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}

	public void updateWebPromotionData(WebPromotionPO po) {
		db=new Database();
		
		double datediscount=po.getDatediscount();
		Date startdate=po.getStartdate();
		Date enddate=po.getEnddate();
		
		String query="UPDATE hotel_strategy SET date_discount="+"'"+String.valueOf(datediscount)+"',"
				+ "start_date="+"'"+String.valueOf(startdate)+"',"
				+ "end_date="+"'"+String.valueOf(enddate)+"'"		
				+ " WHERE start_date="+"'"+String.valueOf(startdate)+"'";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}

	public void deleteWebPromotionData(WebPromotionPO po) {
//		db=new Database();
//		Date startdate=po.getStartdate();
//		String query="DELETE hotel_strategy WHERE start_date='"+startdate+"'";
//		try{
//			db.update(query);
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			db.close();
//		}
		
	}

	public void insertWebPromotionData(WebPromotionPO po) {
		db=new Database();
		//hotel promotion info
		double datediscount=po.getDatediscount();
		Date startdate=po.getStartdate();
		Date enddate=po.getEnddate();
		
		String query="INSERT INTO web_strategy(date_discount"
				+ "start_date,end_date,name) VALUE('"+
				String.valueOf(datediscount)+"',"+
				"'"+String.valueOf(startdate)+"',"+"'"+String.valueOf(enddate)
				+"')";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}

}
