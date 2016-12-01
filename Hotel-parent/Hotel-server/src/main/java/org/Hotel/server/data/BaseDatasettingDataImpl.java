package org.Hotel.server.data;

import reservationDataImpl.ArrayList;
import reservationDataImpl.BaseDatasettingDataService;
import reservationDataImpl.RemoteException;
import reservationDataImpl.ReservationPO;
import reservationDataImpl.ReservationRecordInPO;
import reservationDataImpl.Serializable;
import reservationDataImpl.UnicastRemoteObject;
import reservationDataImpl.string;

public class BaseDatasettingDataImpl extends UnicastRemoteObject implements BaseDatasettingDataService,Serializable{

	 
	public boolean add(ReservationRecordInPO Reservationrecordinpo)throws RemoteException{
	    	
	    }
	    
	public boolean delete(ReservationRecordInPO Reservationrecordinpo)throws RemoteException{
	    	
	    }
	    
	public boolean update(ReservationRecordInPO Reservationrecordinpo)throws RemoteException{
	    	
	    }
	    
	public  ArrayList<ReservationPO> show(string id)throws RemoteException{
	    	
	    }
}
