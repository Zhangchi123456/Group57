package org.Hotel.server.dataService;

import org.Hotel.server.po.UserPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserDataService extends Remote{
	public void insert(UserPO po) throws RemoteException;
	
	public void delete(UserPO po) throws RemoteException;
	
	public void update(UserPO po) throws RemoteException;
	
	public UserPO find(long id) throws RemoteException;
	
	public UserPO showAll() throws RemoteException;
}
