package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebStaffPO;

public interface UserDataService extends Remote{

	public boolean insert(HotelStaffPO po) throws RemoteException;
	
	public boolean insert(WebStaffPO po) throws RemoteException;
	
	public boolean insert(WebManagerPO po) throws RemoteException;
	
	public boolean delete(HotelStaffPO po) throws RemoteException;
	
	public boolean delete(WebStaffPO po) throws RemoteException;
	
	public boolean delete(WebManagerPO po) throws RemoteException;
	
	public boolean update(HotelStaffPO po) throws RemoteException;
	
	public boolean update(WebStaffPO po) throws RemoteException;
	
	public boolean update(WebManagerPO po) throws RemoteException;
	
	public HotelStaffPO findByHotelStaff(String name) throws RemoteException;
	
	public WebStaffPO findByWebStaff(String name) throws RemoteException;
	
	public WebManagerPO findByWebManager(String name) throws RemoteException;
	
	public ArrayList<HotelStaffPO> showAllHotelStaff() throws RemoteException;
	
	public ArrayList<WebStaffPO> showAllWebStaff() throws RemoteException;
	
	public ArrayList<WebManagerPO> showAllWebManager() throws RemoteException;
}
