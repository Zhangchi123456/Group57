package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.RoomVO;

public interface HotelStaffLogicService {

	public ArrayList<RoomVO> roomShowAll(String hotelid, int room_id, String room_type)throws RemoteException;
}
