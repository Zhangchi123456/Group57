package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberLevelPO;
import org.Hotel.common.po.MemberPO;

public interface MemberDataService extends Remote{
	public boolean insert(MemberPO po) throws RemoteException;
	
	public boolean delete(MemberPO po) throws RemoteException;
	
	public boolean update(MemberPO po) throws RemoteException;
	
	public boolean update(MemberLevelPO po) throws RemoteException;
	
	public boolean insert(CreditPO po) throws RemoteException;
	
	public boolean update(CreditPO po) throws RemoteException;
	
	public MemberPO find(String name) throws RemoteException;
	
	public MemberLevelPO findLV(int level) throws RemoteException;
	
	public CreditPO findCreditRecord(int orderid) throws RemoteException;
	
	public ArrayList<MemberPO> showAll() throws RemoteException;
	
	public ArrayList<MemberLevelPO> showAllLV() throws RemoteException;
	
	public ArrayList<CreditPO> findCreditByName(String name) throws RemoteException;

}
