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

	public boolean insert(MemberPO po) throws RemoteException{
		return true;
	}
	
	public boolean delete(MemberPO po) throws RemoteException{
		return true;
	}
	
	public boolean update(MemberPO po) throws RemoteException{
		return true;
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
