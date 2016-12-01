package org.Hotel.server.dataImpl;

import orderDataImpl.Date;
import orderDataImpl.OrdersDataService;
import orderDataImpl.RemoteException;
import orderDataImpl.ResultMessage;
import orderDataImpl.Serializable;
import orderDataImpl.Type;
import orderDataImpl.UnicastRemoteObject;
import orderDataImpl.orderlist;

public class OrdersDataImpl extends UnicastRemoteObject implements OrdersDataService,Serializable{

	public orderlist view(int Userid, Type Asktype)throws RemoteException{
		
	}
	
	public ResultMessage add(int userId,String hotelName, String roomType,int roomNum, int peopleNum, Date beginDate, Date endDate, Date deadline)throws RemoteException{
		
	}
	
	public ResultMessage revoke(int orderId)throws RemoteException{
		
	}
	
	public void confirm()throws RemoteException{
		
	}
	
	public void cancel()throws RemoteException{
		
	}
	
	public void recover(int orderId)throws RemoteException{
		
	}

	public void changeError(int orderId)throws RemoteException{
		
	}
}
