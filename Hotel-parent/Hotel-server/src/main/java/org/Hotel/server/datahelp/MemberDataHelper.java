package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberLevelPO;
import org.Hotel.common.po.MemberPO;

public interface MemberDataHelper {
	/**
	 * @return	从数据文件读入会员信息
	 */
	public Map<Integer,MemberPO> getMemberData();
	/**
	 * 从数据文件中写入会员信息
	 * @param map	
	 */
	public void updateMemberData(MemberPO memberpo);
	
	public void insertMemberData(MemberPO memberpo);
	
	public void deleteMemberData(MemberPO memberpo);
	
	/**
	 * @return	从数据文件读入会员信息
	 */
	public Map<Integer, MemberLevelPO> getMemberLevelData();
	/**
	 * 从数据文件中写入会员信息
	 * @param map	
	 */
	public void updateMemberLevelData(MemberLevelPO memberlvpo);
	
	public void insertMemberLevelData(MemberLevelPO memberlvpo);
	
	public void deleteMemberLevelData(MemberLevelPO memberlvpo);
	
	/**
	 * @return	从数据文件读入信用信息
	 */
	public Map<String,CreditPO> getCreditData();
	/**
	 * 从数据文件中写入信用信息
	 * @param map	
	 */
	public void updateCreditData(CreditPO creditpo);
	
	public void insertCreditData(CreditPO creditpo);
	
	public void deleteCreditData(CreditPO creditpo);
	
}
