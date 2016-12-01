package org.Hotel.common.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.ReservationPO;

public interface ReservationDataService extends Remote{

	public void add(ReservationPO reservationpo)throws RemoteException;

    public void delete(ReservationPO reservationpo)throws RemoteException;
    
    public void show(ReservationPO reservationpo)throws RemoteException;
    
    public void update(ReservationPO reservationpo)throws RemoteException;
    
    public void find(String id)throws RemoteException;
}
