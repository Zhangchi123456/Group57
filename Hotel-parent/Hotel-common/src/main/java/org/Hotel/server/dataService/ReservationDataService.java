package org.Hotel.server.dataService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import org.Hotel.server.po.ReservationPO;

public interface ReservationDataService {

	public void add(ReservationPO reservationpo)throws RemoteException;

    public void delete(ReservationPO reservationpo)throws RemoteException;
    
    public void show(ReservationPO reservationpo)throws RemoteException;
    
    public void update(ReservationPO reservationpo)throws RemoteException;
    
    public void find(String id)throws RemoteException;
}
