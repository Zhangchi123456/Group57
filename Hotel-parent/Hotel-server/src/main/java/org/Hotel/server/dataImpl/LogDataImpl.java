package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.common.dataService.LogDataService;
import org.Hotel.common.po.LogPO;

public class LogDataImpl extends UnicastRemoteObject implements LogDataService,Serializable{
	
	public LogDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(LogPO po) throws RemoteException{
	}
	
	public void delete(LogPO po) throws RemoteException{
	}
	
}
