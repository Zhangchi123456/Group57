package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.OrderPO;

public interface OrderDataService extends Remote{

    public void insert(OrderPO orderpo)throws RemoteException;
	
	public void delete(OrderPO orderpo)throws RemoteException;
	
	public void update(OrderPO orderPO)throws RemoteException;
	
	public void find(OrderPO orderpo)throws RemoteException;
	
    public ArrayList<OrderPO> showAll()throws RemoteException;
	
	public ArrayList<OrderPO> orderShowAll(int Order_id)throws RemoteException;
}
