package org.Hotel.server.dataService;

import org.Hotel.server.po.UserPO;

public interface UserDataService {
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
