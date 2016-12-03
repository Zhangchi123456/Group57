package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.OrderPO;

public interface OrderDataService extends Remote{

    public boolean insert(OrderPO orderpo)throws RemoteException;
	
	public boolean delete(OrderPO orderpo)throws RemoteException;
	
	public boolean update(OrderPO orderpO)throws RemoteException;
	
	public ArrayList<OrderPO> showAll()throws RemoteException;
	
	public ArrayList<OrderPO> orderShowAllByName(String name)throws RemoteException;
	
	public ArrayList<OrderPO> orderShowAllByHotel(String hotel_id)throws RemoteException;
	
	public ArrayList<OrderPO> orderShowAllByName(String name, String state)throws RemoteException;
	
	public ArrayList<OrderPO> orderShowAllByHotel(String hotel_id, String name)throws RemoteException;
}
