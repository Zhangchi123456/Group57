package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.MemberPO;

public interface MemberDataHelper {

	public Map<Integer,MemberPO> getMemberData();
	
	public void updateMemberData(Map<Integer,MemberPO> map);
	
}
