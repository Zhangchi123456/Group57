package org.Hotel.server.dataService;

import org.Hotel.server.po.UserPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserDataService {
	public boolean insert(UserPO po);
	
	public boolean delete(UserPO po);
	
	public boolean update(UserPO po);
	
	public UserPO find(long id);
	
	public UserPO showAll();
}
