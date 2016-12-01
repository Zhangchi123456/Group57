package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.server.dataService.MemberDataService;
import org.Hotel.server.po.MemberPO;

public class MemberDataImpl extends UnicastRemoteObject implements MemberDataService,Serializable{
	
	public MemberDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(MemberPO po) throws RemoteException{
	
	}
	
	public void delete(MemberPO po) throws RemoteException{
	
	}
	
	public void update(MemberPO po) throws RemoteException{

	}
	
	public MemberPO find(long id) throws RemoteException{
		MemberPO po = new MemberPO();
		return po;
	}
	
	public MemberPO showAll() throws RemoteException{
		MemberPO po = new MemberPO();
		return po;
	}

}
