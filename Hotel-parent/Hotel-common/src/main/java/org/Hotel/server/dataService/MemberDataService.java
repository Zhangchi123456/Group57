package org.Hotel.server.dataService;

import org.Hotel.server.po.MemberPO;

public interface MemberDataService {
	public boolean insert(MemberPO po){
		return true;
	}
	
	public boolean delete(MemberPO po){
		return true;
	}
	
	public boolean update(MemberPO po){
		return true;
	}
	
	public MemberPO find(long id){
		MemberPO po = new MemberPO();
		return po;
	}
	
	public MemberPO showAll(){
		MemberPO po = new MemberPO();
		return po;
	}

}
