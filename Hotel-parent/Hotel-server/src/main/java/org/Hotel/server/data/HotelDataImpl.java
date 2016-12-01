package org.Hotel.server.data;

import hotelDataImpl.ArrayList;
import hotelDataImpl.HotelDataService;
import hotelDataImpl.HotelPO;
import hotelDataImpl.RemoteException;
import hotelDataImpl.Serializable;
import hotelDataImpl.UnicastRemoteObject;

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
		
	}
	
	public ArrayList<HotelPO> hotelShowAll(int Hotel_id)throws RemoteException{
		
	}
	
	public boolean update(HotelPO roomInfo)throws RemoteException{
		
	}
	
	public boolean delete(HotelPO roomInfo)throws RemoteException{
		
	}
	
	public boolean showAll()throws RemoteException{
		
	}
	
	public boolean update(String stateinfo)throws RemoteException{
		
	}
	
}
