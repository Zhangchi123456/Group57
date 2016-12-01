package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.LogPO;

public interface LogDataService extends Remote{
	public void insert(LogPO po) throws RemoteException;
	
	public void delete(LogPO po) throws RemoteException;
}
