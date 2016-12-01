package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelPO;

public interface HotelDataService extends Remote{

	public void insert(HotelPO hotelpo)throws RemoteException;
	
	public void delete(HotelPO hotelpo)throws RemoteException;
	
	public void update(HotelPO hotelpo)throws RemoteException;
	
	public void find(HotelPO hotelpo)throws RemoteException;
	
	public ArrayList<HotelPO> showAll()throws RemoteException;
	
	public ArrayList<HotelPO> hotelShowAll(int Hotel_id)throws RemoteException;
	
	public void updateRoom(HotelPO roomInfo)throws RemoteException;
	
	public void deleteRoom(HotelPO roomInfo)throws RemoteException;
	
	public void updateState(String stateinfo)throws RemoteException;
}