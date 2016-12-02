package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.po.HotelPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;

public class HotelDataImpl extends UnicastRemoteObject implements HotelDataService,Serializable{

	private Map<Integer, HotelPO> map;
	
	private HotelDataHelper hotelDataHelper;
	
	private DataFactory dataFactory;
	
	private static HotelDataImpl hotelDataImpl;
	
	public static HotelDataImpl getInstance(){
		if(hotelDataImpl == null){
			hotelDataImpl = new HotelDataImpl();
		}
		return hotelDataImpl;
	}
	
	public boolean insert(HotelPO hotelpo)throws RemoteException{
		return false;
		
	}
	
	public boolean delete(HotelPO hotelpo)throws RemoteException{
		return false;
		
	}
	
	public boolean update(HotelPO hotelpo)throws RemoteException{
		return false;
		
	}
	
	public boolean find(HotelPO hotelpo)throws RemoteException{
		return false;
		
	}
	
	public ArrayList<HotelPO> showAll()throws RemoteException{
		return null;
		
	}
	
	public ArrayList<HotelPO> hotelShowAll(int hotel_id)throws RemoteException{
		return null;
		
	}
	
	public ArrayList<HotelPO> roomShowAll(int room_id)throws RemoteException{
		return null;
	}
	
	public boolean updateRoom(int room_id)throws RemoteException{
		return false;
		
	}
	
	public boolean deleteRoom(int room_id)throws RemoteException{
		return false;
		
	}
	
	public boolean updateState(String stateinfo)throws RemoteException{
		return false;
		
	}


	
}
