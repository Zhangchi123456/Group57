package org.Hotel.server.dataService;

import org.Hotel.server.dataImpl.Date;
import org.Hotel.server.dataImpl.RemoteException;
import org.Hotel.server.dataImpl.ResultMessage;
import org.Hotel.server.dataImpl.Type;
import org.Hotel.server.dataImpl.orderlist;

public interface OrderDataService {
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
