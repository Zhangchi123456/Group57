package org.Hotel.server.dataService;

import org.Hotel.server.po.LogPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogDataService {
	public void insert(LogPO po) throws RemoteException;
	
	public void delete(LogPO po) throws RemoteException;
}
