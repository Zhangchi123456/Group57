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
		db=Database.getInstance();
		String query="SELECT * FROM hotel_strategy";
		Map<String, HotelPromotionPO> map= new HashMap<String, HotelPromotionPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				String hotelname=rs.getString("hotel_name");
				String name=rs.getString("name");
				//discount
				double birthdaydiscount=rs.getDouble("birthday_discount");
				double multiorderdiscount=rs.getDouble("multiorder_discount");
				double enterprisediscount=rs.getDouble("enterprise_discount");
				double datediscount=rs.getDouble("date_discount");
				//date
				Date startdate=rs.getDate("start_date");
				Date enddate=rs.getDate("end_date");
			   
				HotelPromotionPO po=new HotelPromotionPO(name, hotelname,birthdaydiscount,
						multiorderdiscount,
						enterprisediscount,datediscount,startdate,enddate);
				map.put(name, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}//end get hotel strategy data 
	/*
	 * update a record of hotel promotion
	 */
	public void updateHotelPromotionData(HotelPromotionPO po) {
		db=Database.getInstance();
		
		double birthdaydiscount=po.getBirthdaydiscount();
		double multiorderdiscount=po.getMultiorderdiscount();
		double enterpricediscount=po.getEnterpricediscount();
		double datediscount=po.getDatediscount();
		Date startdate=po.getStartdate();
		Date enddate=po.getEnddate();
		
		String query="UPDATE hotel_strategy SET bithday_discount="+"'"+birthdaydiscount+"',"
				+ "multiorder_discount="+"'"+multiorderdiscount+"',"
				+ "enterprice_discount_discount="+"'"+enterpricediscount+"',"
				+ "date_discount="+"'"+datediscount+"',"
				+ "start_date="+"'"+startdate+"',"
				+ "end_date="+"'"+enddate+"'"		
				+ " WHERE startdate="+"'"+startdate+"'";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}//end update hotel strategy
	
	public void insertHotelPromotionData(HotelPromotionPO po) {
		db=Database.getInstance();
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
				+ "'"+hotelid+"',"
				+ "'"+birthdaydiscount+"',"
				+ "'"+multiorderdiscount+"',"
				+ "'"+enterpricediscount+"',"
				+ "'"+datediscount+"',"
				+ "'"+startdate+"',"
				+ "'"+enddate+ "',"
				+ "'"+type+"')";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end insert hotel promotion
	
	public void deleteHotelPromotionData(HotelPromotionPO po) {
//		db=Database.getInstance();
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
		db=Database.getInstance();
		
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
	}//end get web strategy data

	public void updateWebPromotionData(WebPromotionPO po) {
		db=Database.getInstance();
		
		double datediscount=po.getDatediscount();
		Date startdate=po.getStartdate();
		Date enddate=po.getEnddate();
		
		String query="UPDATE hotel_strategy SET "
				+ "date_discount="+"'"+datediscount+"',"
				+ "start_date="+"'"+startdate+"',"
				+ "end_date="+"'"+enddate+"'"		
				+ " WHERE start_date="+"'"+startdate+"'";
				
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end update web strategy

	public void deleteWebPromotionData(WebPromotionPO po) {
//		db=Database.getInstance();
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
		db=Database.getInstance();
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
