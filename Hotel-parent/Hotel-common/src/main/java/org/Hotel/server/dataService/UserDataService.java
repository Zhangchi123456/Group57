package org.Hotel.server.dataService;

import org.Hotel.server.po.UserPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserDataService {
	public boolean insert(UserPO po) throws RemoteException;
	
	public boolean delete(UserPO po) throws RemoteException;
	
	public boolean update(UserPO po) throws RemoteException;
	
	public UserPO find(long id) throws RemoteException;
	
	public UserPO showAll() throws RemoteException;
}
