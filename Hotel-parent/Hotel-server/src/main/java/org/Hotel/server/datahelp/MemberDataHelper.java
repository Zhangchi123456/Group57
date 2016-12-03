package org.Hotel.server.datahelp;

import java.util.Map;

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
	
	public void deleteMemberData(MemberPO meberpo);
	
}
