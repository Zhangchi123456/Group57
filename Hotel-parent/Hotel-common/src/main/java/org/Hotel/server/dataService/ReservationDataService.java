package org.Hotel.server.dataService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import org.Hotel.server.po.ReservationPO;

public interface ReservationDataService {

	public boolean add(ReservationPO reservationpo)throws RemoteException;

    public boolean delete(ReservationPO reservationpo)throws RemoteException;
    
    public boolean show(ReservationPO reservationpo)throws RemoteException;
    
    public boolean update(ReservationPO reservationpo)throws RemoteException;
    
    public boolean find(String id)throws RemoteException;
}
