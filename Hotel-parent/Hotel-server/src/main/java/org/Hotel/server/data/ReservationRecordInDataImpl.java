package org.Hotel.server.data;

import reservationDataImpl.RemoteException;
import reservationDataImpl.ReservationPO;
import reservationDataImpl.ReservationRecordInDataService;
import reservationDataImpl.Serializable;
import reservationDataImpl.UnicastRemoteObject;
import reservationDataImpl.string;

public class ReservationRecordInDataImpl extends UnicastRemoteObject implements ReservationRecordInDataService,Serializable{

	
	public boolean add(ReservationPO reservationpo)throws RemoteException{
		
	}

    public boolean delete(ReservationPO reservationpo)throws RemoteException{
		
	}
    
    public boolean show(ReservationPO reservationpo)throws RemoteException{
		
	}
    
    public boolean update(ReservationPO reservationpo)throws RemoteException{
		
	}
    
    public boolean find(string id)throws RemoteException{
    	
    }
    
}
