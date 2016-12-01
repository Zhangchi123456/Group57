package org.Hotel.server.dataService;

import org.Hotel.server.po.HotelPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HotelDataService {

	public void insert(HotelPO hotelpo)throws RemoteException;
	
	public void delete(HotelPO hotelpo)throws RemoteException;
	
	public void update(HotelPO hotelpo)throws RemoteException;
	
	public void find(HotelPO hotelpo)throws RemoteException;
	
	public ArrayList<HotelPO> showAll()throws RemoteException;
	
	public ArrayList<HotelPO> hotelShowAll(int Hotel_id)throws RemoteException;
	
	public boolean updateRoom(HotelPO roomInfo)throws RemoteException;
	
	public boolean deleteRoom(HotelPO roomInfo)throws RemoteException;
	
	public boolean updateState(String stateinfo)throws RemoteException;
}
