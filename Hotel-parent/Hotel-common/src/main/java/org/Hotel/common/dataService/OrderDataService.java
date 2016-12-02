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
	
	public ArrayList<OrderPO> orderShowAll(int order_id)throws RemoteException;
}
