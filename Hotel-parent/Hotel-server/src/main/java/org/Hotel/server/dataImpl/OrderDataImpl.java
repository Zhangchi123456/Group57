package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.Hotel.server.dataService.OrderDataService;
import org.Hotel.server.po.OrderPO;

public class OrderDataImpl extends UnicastRemoteObject implements OrderDataService,Serializable{

	    protected OrderDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

		public void insert(OrderPO orderpo)throws RemoteException{
	    	
	    }
		
		public void delete(OrderPO orderpo)throws RemoteException{
			
		}
		
		public void update(OrderPO orderPO)throws RemoteException{
			
		}
		
		public void find(OrderPO orderpo)throws RemoteException{
			
		}
		
	    public ArrayList<OrderPO> showAll()throws RemoteException{
			return null;
	    	
	    }
		
		public ArrayList<OrderPO> orderShowAll(int Order_id)throws RemoteException{
			return null;
			
		}
}
