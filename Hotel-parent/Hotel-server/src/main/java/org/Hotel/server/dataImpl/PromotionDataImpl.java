package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.po.PromotionPO;

public class PromotionDataImpl extends UnicastRemoteObject implements PromotionDataService,Serializable{
	
	public PromotionDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(PromotionPO po) throws RemoteException{

	}
	
	public void delete(PromotionPO po) throws RemoteException{

	}
	
	public void update(PromotionPO po) throws RemoteException{

	}
	
	public PromotionPO findByID(String id) throws RemoteException{
		PromotionPO po = new PromotionPO();
		return po;
	}
	
	public PromotionPO findByType(String type) throws RemoteException{
		PromotionPO po = new PromotionPO();
		return po;
	}
	
	public PromotionPO showAll() throws RemoteException{
		PromotionPO po = new PromotionPO();
		return po;
	}

}
