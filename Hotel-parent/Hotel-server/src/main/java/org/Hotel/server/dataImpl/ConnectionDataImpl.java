package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.common.dataService.ConnectionDataService;

public class ConnectionDataImpl extends UnicastRemoteObject implements ConnectionDataService,Serializable {

	public ConnectionDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isConnected() throws RemoteException {
		return true;
}

}
