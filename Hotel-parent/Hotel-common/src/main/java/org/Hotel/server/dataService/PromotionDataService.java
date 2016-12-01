package org.Hotel.server.dataService;

import org.Hotel.server.po.PromotionPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PromotionDataService {
	public void insert(PromotionPO po) throws RemoteException;
	
	public void delete(PromotionPO po) throws RemoteException;
	
	public void update(PromotionPO po) throws RemoteException;
	
	public PromotionPO findByID(String id) throws RemoteException;
	
	public PromotionPO findByType(String type) throws RemoteException;
	
	public PromotionPO showAll() throws RemoteException;
}
