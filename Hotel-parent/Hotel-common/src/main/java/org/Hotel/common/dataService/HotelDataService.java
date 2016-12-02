package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelPO;

public interface HotelDataService extends Remote{

	public boolean insert(HotelPO hotelpo)throws RemoteException;
	
	public boolean delete(HotelPO hotelpo)throws RemoteException;
	
	public boolean update(HotelPO hotelpo)throws RemoteException;
	
	public boolean find(HotelPO hotelpo)throws RemoteException;
	
	public ArrayList<HotelPO> showAll()throws RemoteException;
	
	public ArrayList<HotelPO> hotelShowAll(int hotel_id)throws RemoteException;
	
	public ArrayList<HotelPO> roomShowAll(int room_id)throws RemoteException;
	
	public boolean updateRoom(int room_id)throws RemoteException;
	
	public boolean deleteRoom(int room_id)throws RemoteException;
	
	public boolean updateState(String stateinfo)throws RemoteException;
}
