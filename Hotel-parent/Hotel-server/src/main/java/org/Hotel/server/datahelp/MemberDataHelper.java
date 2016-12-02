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
	public void updateMemberData(Map<Integer,MemberPO> map);
	
}
