package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.MemberPO;

public interface MemberDataService extends Remote{
	public boolean insert(MemberPO po) throws RemoteException;
	
	public boolean delete(MemberPO po) throws RemoteException;
	
	public boolean update(MemberPO po) throws RemoteException;
	
	public MemberPO find(String name) throws RemoteException;
	
	public ArrayList<MemberPO> showAll() throws RemoteException;

}
