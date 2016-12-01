package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.server.dataService.LogDataService;
import org.Hotel.server.po.LogPO;

public class LogDataImpl extends UnicastRemoteObject implements LogDataService,Serializable{
	
	public LogDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insert(LogPO po) throws RemoteException{
		return true;
	}
	
	public boolean delete(LogPO po) throws RemoteException{
		return true;
	}
	
}
