package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;

public interface HotelDataService extends Remote{

	public boolean insert(HotelPO hotelpo)throws RemoteException;
	
	public boolean delete(HotelPO hotelpo)throws RemoteException;
	
	public boolean update(HotelPO hotelpo)throws RemoteException;
	
	public ArrayList<HotelPO> hotelShowAll(String circle, String hotel_id, int star, double grade)throws RemoteException;
	
	public ArrayList<RoomPO> roomShowAll(String hotelid, int room_id, String room_type)throws RemoteException;
	
	public boolean updateRoom(RoomPO roompo)throws RemoteException;
	
	public boolean insertRoom(RoomPO roompo)throws RemoteException;

}
