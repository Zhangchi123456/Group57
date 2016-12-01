package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.UserPO;

public interface UserDataHelper {

	public Map<Integer,UserPO> getUserData();
	
	public void updateUserData(Map<Integer,UserPO> map);
}
