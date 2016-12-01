package org.Hotel.server.dataService;

import org.Hotel.server.po.LogPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogDataService extends Remote{
	public void insert(LogPO po) throws RemoteException;
	
	public void delete(LogPO po) throws RemoteException;
}
