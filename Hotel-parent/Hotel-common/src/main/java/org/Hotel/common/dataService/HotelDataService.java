package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;

public interface HotelDataService extends Remote{

	public boolean insert(HotelPO hotelpo)throws RemoteException;
	public boolean delete(HotelPO hotelpo)throws RemoteException;
	public boolean update(HotelPO hotelpo)throws RemoteException;
	
	public boolean update(CirclePO po)throws RemoteException;
	
	public ArrayList<HotelPO> hotelShowAll(String circle, String hotel_id,
			int star, double grade)throws RemoteException;
	
	public ArrayList<RoomPO> roomShowAll(String hotelid)throws RemoteException;
	public boolean updateRoom(RoomPO roompo)throws RemoteException;
	public boolean deleteRoom(RoomPO roompo)throws RemoteException;
	public boolean insertRoom(RoomPO roompo)throws RemoteException;
    
	public ArrayList<String> cityShowAll()throws RemoteException;
	public CirclePO circleFind(String city, String circle)throws RemoteException;
	
	public HotelPO Findhotelbyname(String hotelname)throws RemoteException;
	
	public ArrayList<HotelPO> FindhotelByCircle(String circle)throws RemoteException;
	
	public ArrayList<CirclePO> circleShowAll(String city)throws RemoteException;
	
	public RoomPO FindroombyID(int roomid)throws RemoteException;
}
