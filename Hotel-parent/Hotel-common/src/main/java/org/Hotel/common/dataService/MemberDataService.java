package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.MemberPO;

public interface MemberDataService extends Remote{
	public void insert(MemberPO po) throws RemoteException;
	
	public void delete(MemberPO po) throws RemoteException;
	
	public void update(MemberPO po) throws RemoteException;
	
	public MemberPO find(long id) throws RemoteException;
	
	public MemberPO showAll() throws RemoteException;

}
