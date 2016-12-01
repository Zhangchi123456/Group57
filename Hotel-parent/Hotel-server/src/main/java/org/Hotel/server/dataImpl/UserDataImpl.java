package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.UserPO;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService,Serializable{
	
	public UserDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(UserPO po) throws RemoteException{

	}
	
	public void delete(UserPO po) throws RemoteException{

	}
	
	public void update(UserPO po) throws RemoteException{

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
