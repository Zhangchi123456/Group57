package org.Hotel.server.dataService;

import org.Hotel.server.po.MemberPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MemberDataService {
	public void insert(MemberPO po) throws RemoteException;
	
	public void delete(MemberPO po) throws RemoteException;
	
	public void update(MemberPO po) throws RemoteException;
	
	public MemberPO find(long id) throws RemoteException;
	
	public MemberPO showAll() throws RemoteException;

}
