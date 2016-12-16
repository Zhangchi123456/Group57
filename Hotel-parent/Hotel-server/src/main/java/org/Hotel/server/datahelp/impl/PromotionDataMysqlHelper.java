package org.Hotel.server.datahelp.impl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.Hotel.server.config.Database;
import org.Hotel.server.dataImpl.PromotionDataImpl;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;
import org.Hotel.common.po.WebStaffPO;
import org.Hotel.server.datahelp.PromotionDataHelper;

public class PromotionDataMysqlHelper implements PromotionDataHelper {
	Database db;
	/*
	 * hotel promotion operation
	 */
	public Map<Integer, HotelPromotionPO> getHotelPromotionData() {
		db=Database.getInstance();
		String query="SELECT * FROM hotel_strategy";
		Map<Integer, HotelPromotionPO> map= new HashMap<Integer, HotelPromotionPO>();
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
				String startdate=rs.getString("start_date");
				String enddate=rs.getString("end_date");
			   
				HotelPromotionPO po=new HotelPromotionPO(name, hotelname,birthdaydiscount,
						multiorderdiscount,
						enterprisediscount,datediscount,startdate,enddate,id);
				map.put(id, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}//end get hotel strategy data 
	// update a record of hotel promotion
	public void updateHotelPromotionData(HotelPromotionPO po) {
		db=Database.getInstance();
		//hotel strategy info
		int id=po.getId();
		double birthdaydiscount=po.getBirthdaydiscount();
		double multiorderdiscount=po.getMultiorderdiscount();
		double enterpricediscount=po.getEnterpricediscount();
		double datediscount=po.getDatediscount();
		
		String query="UPDATE hotel_strategy SET birthday_discount="+"'"+birthdaydiscount+"',"
				+ "multiorder_discount="+"'"+multiorderdiscount+"',"
				+ "enterprise_discount="+"'"+enterpricediscount+"',"
				+ "date_discount="+"'"+datediscount+"'"
				+ " WHERE id="+"'"+id+"'";
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
		//hotel strategy info
		String type=po.getType();
		String hotelid=po.getHotelid();
		//discount
		double birthdaydiscount=po.getBirthdaydiscount();
		double multiorderdiscount=po.getMultiorderdiscount();
		double enterpricediscount=po.getEnterpricediscount();
		double datediscount=po.getDatediscount();
		//date
		String startdate=po.getStartdate();
		String enddate=po.getEnddate();
		
		String query="INSERT INTO hotel_strategy(hotel_name,birthday_discount,"
				+ "multiorder_discount,enterprise_discount,date_discount,"
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
		db=Database.getInstance();
		
		int id=po.getId();
		String query="DELETE FROM hotel_strategy WHERE id="+id+"";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end delete hotel promotion
	/*
	 * web strategy operation
	 */
	public Map<Integer, WebPromotionPO> getWebPromotionData() {
		db=Database.getInstance();
		
		String query="SELECT * FROM web_strategy";
		Map<Integer, WebPromotionPO> map= new HashMap<Integer, WebPromotionPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				double datediscount=rs.getDouble("date_discount");
				String startdate=rs.getString("start_date");
				String enddate=rs.getString("end_date");
				
				WebPromotionPO po=new WebPromotionPO(datediscount,startdate,enddate,id);
				map.put(id, po);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}//end get web strategy data

	//has no such feature
	public void updateWebPromotionData(WebPromotionPO po) {
	}//end update web strategy

	public void deleteWebPromotionData(WebPromotionPO po) {
		db=Database.getInstance();
		
		int id=po.getID();
		String query="DELETE FROM web_strategy WHERE id='"+id+"'";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end delete web promotion data

	public void insertWebPromotionData(WebPromotionPO po) {
		db=Database.getInstance();
		//hotel promotion info
		double datediscount=po.getDatediscount();
		String startdate=po.getStartdate();
		String enddate=po.getEnddate();
		
		String query="INSERT INTO web_strategy(date_discount,"
				+ "start_date,end_date) VALUE('"+
				datediscount+"',"+
				"'"+startdate+"',"+"'"+enddate
				+"')";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
	}//end insert web promotion
}