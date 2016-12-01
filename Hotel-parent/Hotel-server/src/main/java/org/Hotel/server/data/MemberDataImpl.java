package org.Hotel.server.data;

import org.Hotel.server.po.MemberPO;

public class MemberDataImpl {
	
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
