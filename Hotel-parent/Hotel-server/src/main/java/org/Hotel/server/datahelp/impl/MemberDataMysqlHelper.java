package org.Hotel.server.datahelp.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberLevelPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.server.config.Database;
import org.Hotel.server.datahelp.*;

/**
 * @author Jerry
 *
 */
/**
 * @author Jerry
 *
 */
/**
 * @author Jerry
 *
 */
/**
 * @author Jerry
 *
 */
/**
 * @author Jerry
 *
 */
public class MemberDataMysqlHelper implements MemberDataHelper{
	Database db;
	//Member
	/* 
	 * return all member data from member table
	 */
	public Map<Integer, MemberPO> getMemberData() {
		db=new Database();
		Map<Integer,MemberPO> map=new HashMap<Integer,MemberPO>();
		String query="SELECT * FROM member";
		try{
			ResultSet memrs=db.select(query);
			while(memrs.next()){
				//memberinfo
				int id=memrs.getInt("id");
				int credit=memrs.getInt("credit");
				int level=memrs.getInt("level");
				boolean isEnterpriseMember=memrs.getBoolean("is_enterprise_member");
				String phonenums=memrs.getString("phone_num");
				String name=memrs.getString("name");
				String password=memrs.getString("password");
				Date birthday=memrs.getDate("birthday");
				
				MemberPO mempo=new MemberPO(id, password, phonenums, birthday, name, credit, isEnterpriseMember, level);
				map.put(id, mempo);
				
			}//end while
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}
	/*
	 * update member data:password,credit,birthday,level,phone_num,name
	 */	
	public void updateMemberData(MemberPO memberpo) {
		db=new Database();
		int id=memberpo.getId();
		int credit=memberpo.getCredit();
		int level=memberpo.getLevel();
		
		String password=memberpo.getPassword();
		String name=memberpo.getName();
		String phoneNums=memberpo.getConnection();
		Date birthday=memberpo.getBirthday();
		
		String query="UPDATE member SET "+
				 "name="+"'"+name+"',"+
				 "phone_num="+"'"+phoneNums+"',"+
				 "password="+"'"+password+"',"+
				 "birthbday="+"'"+String.valueOf(birthday)+"',"+
				 "level="+"'"+String.valueOf(level)+"',"+
				 "credit="+"'"+String.valueOf(credit)+"' "+
				 "WHERE id='"+String.valueOf(id)+"'";
		try{
			db.update(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}

	public void insertMemberData(MemberPO memberpo) {
		db=new Database();
		
		int credit=memberpo.getCredit();
		int level=memberpo.getLevel();
		
		String password=memberpo.getPassword();
		String name=memberpo.getName();
		String phoneNums=memberpo.getConnection();
		boolean isEnterpriseMember=memberpo.isEnterprise();
		Date birthday=memberpo.getBirthday();
		
		String query="INSERT INTO member(name,password,phone_num,credit,level,is_enterprise_member,birthday) "
				+" VALUE("
				+ "'"+name+"',"+
				"'"+password+"',"+
				"'"+phoneNums+"',"+
				"'"+credit+"',"+
				"'"+String.valueOf(level)+"',"+
				"'"+String.valueOf(isEnterpriseMember)+"',"+
				"'"+String.valueOf(birthday)+"'"+")";
		try{
			db.update(query);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}
	//not such feature in System
	public void deleteMemberData(MemberPO meberpo) {
		
	}

	public Map<Integer, MemberLevelPO> getMemberLevelData() {
		db=new Database();
		String query="SELECT * FROM member_level";
		Map<Integer,MemberLevelPO> map=new HashMap<Integer,MemberLevelPO>();
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int level=rs.getInt("level");
				int credit=rs.getInt("credit");
				double discount=rs.getDouble("discount");
				
				MemberLevelPO memLevelPO=new MemberLevelPO(level, credit, discount);
				
				map.put(level, memLevelPO);
			}//end while
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}

	public void updateMemberLevelData(MemberLevelPO memberlevelpo) {
		db=new Database();
		double discount=memberlevelpo.getDiscount();
		int level=memberlevelpo.getLevel();
		int credit=memberlevelpo.getCredit();
		String query="UPDATE member_level SET discount='"+String.valueOf(discount)+"',"
				+ "credit='"+String.valueOf(credit)+"' WHERE level='"+String.valueOf(level)+"'";
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}
	//System don't have this feature
	public void insertMemberLevelData(MemberLevelPO memberlvpo) {
		
	}
	//System don't hava this feature
	public void deleteMemberLevelData(MemberLevelPO meberlvpo) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * return member credit record
	 */
	public Map<Integer, CreditPO> getCreditData() {
		
		db=new Database();
		Map<Integer,CreditPO> map=new HashMap<Integer,CreditPO>();
		String query="SELECT * FROM credit_record";
		try{
			ResultSet rs=db.select(query);
			while(rs.next()){
				int id=rs.getInt("id");
				int orderID=rs.getInt("order_id");
				int credit=rs.getInt("credit");
				int creditchange=rs.getInt("credit_change");
				
				String action=rs.getString("action");
				Date time=rs.getDate("time");
				//get member name
				int memID=rs.getInt("member_id");
				String name=getMemberName(db,memID);
				
				CreditPO po=new CreditPO(name, id, orderID,creditchange, credit, time, action);
				
				map.put(id, po);
			}//end while
			
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			db.close();
		}
		return null;
	}
	//get member name by member id
	private String getMemberName(Database db2, int memID) {
		String query="Select name FROM member WHERE id='"+String.valueOf(memID)+"'";
		try{
			ResultSet rs=db.select(query);
			if(rs.next()){
				String name=rs.getString("name");
				return name;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}
	//System have no such feature
	public void updateCreditData(CreditPO creditpo) {
		// TODO Auto-generated method stub
		
	}

	public void insertCreditData(CreditPO creditpo) {
		db=new Database();
		//credit record info
		int id=creditpo.getId();
		int orderID=creditpo.getOrderid();
		int credit=creditpo.getCredit();
		int creditchange=creditpo.getCreditchange();
		
		String action=creditpo.getAction();
		Date time=creditpo.getTime();
		//get member id by name
		String name=creditpo.getName();
		int memID=getMemberID(db,name);
		
		String query="INSERT INTO member(id,member_id,action,credit,credit_change,order_id"
				+" VALUE("
				+ "'"+String.valueOf(id)+"',"+
				"'"+String.valueOf(memID)+"',"+
				"'"+action+"',"+
				"'"+String.valueOf(credit)+"',"+
				"'"+String.valueOf(creditchange)+"',"+
				"'"+String.valueOf(orderID)+"'"+
				")";
		
		try{
			db.update(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		
	}
	private int getMemberID(Database db,String name){
		String query="Select id FROM member WHERE name='"+name+"'";
		try{
			ResultSet rs=db.select(query);
			if(rs.next()){
				int id=rs.getInt("id");
				return id;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return 0;
	}
	//System have no such feature
	public void deleteCreditData(CreditPO creditpo) {
		// TODO Auto-generated method stub
		
	}

}
