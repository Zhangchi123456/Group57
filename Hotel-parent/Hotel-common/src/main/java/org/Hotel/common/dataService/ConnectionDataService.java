package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConnectionDataService extends Remote{
	
	public boolean isConnected() throws RemoteException;

}
