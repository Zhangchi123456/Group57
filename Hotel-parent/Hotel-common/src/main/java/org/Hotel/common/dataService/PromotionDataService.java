package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.PromotionPO;

public interface PromotionDataService extends Remote{
	public void insert(PromotionPO po) throws RemoteException;
	
	public void delete(PromotionPO po) throws RemoteException;
	
	public void update(PromotionPO po) throws RemoteException;
	
	public PromotionPO findByID(String id) throws RemoteException;
	
	public PromotionPO findByType(String type) throws RemoteException;
	
	public PromotionPO showAll() throws RemoteException;
}
