package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;

public interface PromotionDataService extends Remote{
	public boolean insert(WebPromotionPO po) throws RemoteException;
	
	public boolean delete(WebPromotionPO po) throws RemoteException;
	
	public boolean update(WebPromotionPO po) throws RemoteException;
	
	
	public boolean insert(HotelPromotionPO po) throws RemoteException;
	
	public boolean delete(HotelPromotionPO po) throws RemoteException;
	
	public boolean update(HotelPromotionPO po) throws RemoteException;
	
	
	public ArrayList<WebPromotionPO> findByWebProID(String hotel_id) throws RemoteException;
	
	public WebPromotionPO findByWebProType(int type, String hotel_id) throws RemoteException;
	
	public ArrayList<WebPromotionPO> showAllWebPro() throws RemoteException;
	

	public ArrayList<HotelPromotionPO> findByHotelProID(String hotel_id) throws RemoteException;
	
	public HotelPromotionPO findByHotelProType(int type, String hotel_id) throws RemoteException;
	
	public ArrayList<HotelPromotionPO> showAllHotelPro() throws RemoteException;
}
