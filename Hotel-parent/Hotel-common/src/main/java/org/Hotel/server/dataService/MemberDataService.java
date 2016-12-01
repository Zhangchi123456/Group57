package org.Hotel.server.dataService;

import org.Hotel.server.po.MemberPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MemberDataService {
	public boolean insert(MemberPO po);
	
	public boolean delete(MemberPO po);
	
	public boolean update(MemberPO po);
	
	public MemberPO find(long id);
	
	public MemberPO showAll();

}
