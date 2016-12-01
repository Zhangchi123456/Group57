package org.Hotel.server.dataImpl;

import org.Hotel.server.po.UserPO;

public class UserDataImpl {
	
	public boolean insert(UserPO po){
		return true;
	}
	
	public boolean delete(UserPO po){
		return true;
	}
	
	public boolean update(UserPO po){
		return true;
	}
	
	public UserPO find(long id){
		UserPO po = new UserPO();
		return po;
	}
	
	public UserPO showAll(){
		UserPO po = new UserPO();
		return po;
	}

}
