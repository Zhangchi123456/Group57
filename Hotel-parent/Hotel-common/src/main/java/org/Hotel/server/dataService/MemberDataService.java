package org.Hotel.server.dataService;

import org.Hotel.server.po.MemberPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MemberDataService {
	public boolean insert(MemberPO po) throws RemoteException;
	
	public boolean delete(MemberPO po) throws RemoteException;
	
	public boolean update(MemberPO po) throws RemoteException;
	
	public MemberPO find(long id) throws RemoteException;
	
	public MemberPO showAll() throws RemoteException;

}
