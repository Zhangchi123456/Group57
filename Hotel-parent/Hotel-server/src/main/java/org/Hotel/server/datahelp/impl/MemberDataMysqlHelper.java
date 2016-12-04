package org.Hotel.server.datahelp.impl;

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
				int id=memrs.getInt("id");
				int credit=memrs.getInt("credit");
				String name=memrs.getString("name");
			}//end while
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}

	public void updateMemberData(Map<Integer, MemberPO> map) {
		// TODO Auto-generated method stub
		
	}

	public void updateMemberData(MemberPO memberpo) {
		// TODO Auto-generated method stub
		
	}

	public void insertMemberData(MemberPO memberpo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMemberData(MemberPO meberpo) {
		// TODO Auto-generated method stub
		
	}

	public Map<String, MemberLevelPO> getMemberLevelData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMemberLevelData(MemberLevelPO memberlvpo) {
		// TODO Auto-generated method stub
		
	}

	public void insertMemberLevelData(MemberLevelPO memberlvpo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMemberLevelData(MemberLevelPO meberlvpo) {
		// TODO Auto-generated method stub
		
	}

	public Map<Integer, CreditPO> getCreditData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCreditData(CreditPO creditpo) {
		// TODO Auto-generated method stub
		
	}

	public void insertCreditData(CreditPO creditpo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCreditData(CreditPO creditpo) {
		// TODO Auto-generated method stub
		
	}

}
