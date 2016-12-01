package org.Hotel.server.dataService;

import org.Hotel.server.po.LogPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogDataService {
	public boolean insert(LogPO po);
	
	public boolean delete(LogPO po);
}
