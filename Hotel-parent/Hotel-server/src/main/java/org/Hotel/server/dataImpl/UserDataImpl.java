package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.server.dataService.UserDataService;
import org.Hotel.server.po.UserPO;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService,Serializable{
	
	public UserDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insert(UserPO po) throws RemoteException{
		return true;
	}
	
	public boolean delete(UserPO po) throws RemoteException{
		return true;
	}
	
	public boolean update(UserPO po) throws RemoteException{
		return true;
	}
	
	public UserPO find(long id) throws RemoteException{
		UserPO po = new UserPO();
		return po;
	}
	
	public UserPO showAll() throws RemoteException{
		UserPO po = new UserPO();
		return po;
	}

}
