package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.Hotel.server.dataService.HotelDataService;
import org.Hotel.server.po.HotelPO;

public class HotelDataImpl extends UnicastRemoteObject implements HotelDataService,Serializable{

	public HotelDataImpl() throws RemoteException{
		super();
	}
	
	public void insert(HotelPO hotelpo)throws RemoteException{
		
	}
	
	public void delete(HotelPO hotelpo)throws RemoteException{
		
	}
	
	public void update(HotelPO hotelpo)throws RemoteException{
		
	}
	
	public void find(HotelPO hotelpo)throws RemoteException{
		
	}
	
	public ArrayList<HotelPO> showAll()throws RemoteException{
		return null;
		
	}
	
	public ArrayList<HotelPO> hotelShowAll(int Hotel_id)throws RemoteException{
		return null;
		
	}
	
	public boolean updateRoom(HotelPO roomInfo)throws RemoteException{
		return false;
		
	}
	
	public boolean deleteRoom(HotelPO roomInfo)throws RemoteException{
		return false;
		
	}
	
	public boolean updateState(String stateinfo)throws RemoteException{
		return false;
		
	}


	
}
