package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.UserPO;

public interface UserDataService extends Remote{
	public void insert(UserPO po) throws RemoteException;
	
	public void delete(UserPO po) throws RemoteException;
	
	public void update(UserPO po) throws RemoteException;
	
	public UserPO find(long id) throws RemoteException;
	
	public UserPO showAll() throws RemoteException;
}
