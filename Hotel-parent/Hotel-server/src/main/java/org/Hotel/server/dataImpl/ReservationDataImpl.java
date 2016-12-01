package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.Hotel.server.dataService.ReservationDataService;
import org.Hotel.server.po.ReservationPO;

public class ReservationDataImpl extends UnicastRemoteObject implements ReservationDataService,Serializable{

	
	public ReservationDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(ReservationPO reservationpo)throws RemoteException{
		
	}

    public void delete(ReservationPO reservationpo)throws RemoteException{
		
	}
    
    public void show(ReservationPO reservationpo)throws RemoteException{
		
	}
    
    public void update(ReservationPO reservationpo)throws RemoteException{
		
	}
    
    public void find(String id)throws RemoteException{
    	
    }
    
}
