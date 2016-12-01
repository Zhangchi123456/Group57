package org.Hotel.server.dataService;

import org.Hotel.server.po.OrderPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderDataService {

    public void insert(OrderPO orderpo)throws RemoteException;
	
	public void delete(OrderPO orderpo)throws RemoteException;
	
	public void update(OrderPO orderPO)throws RemoteException;
	
	public void find(OrderPO orderpo)throws RemoteException;
	
    public ArrayList<OrderPO> showAll()throws RemoteException;
	
	public ArrayList<OrderPO> orderShowAll(int Order_id)throws RemoteException;
}
