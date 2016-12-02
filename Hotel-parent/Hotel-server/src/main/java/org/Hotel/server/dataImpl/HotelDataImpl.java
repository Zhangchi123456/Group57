package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class HotelDataImpl extends UnicastRemoteObject implements HotelDataService,Serializable{

	private Map<Integer, HotelPO> map;
	
	private Map<Integer, RoomPO> map_room;
	
	private HotelDataHelper hotelDataHelper;
	
	private DataFactory dataFactory;
	
	private static HotelDataImpl hotelDataImpl;
	
	public static HotelDataImpl getInstance() throws RemoteException{
		if(hotelDataImpl == null){
			hotelDataImpl = new HotelDataImpl();
		}
		return hotelDataImpl;
	}
	
	public HotelDataImpl()throws RemoteException{
		if(map == null){
			dataFactory = new DataFactoryImpl();
			hotelDataHelper = dataFactory.getHotelDataHelper();
			map = hotelDataHelper.getHotelData();
		}
	}
	
	public boolean insert(HotelPO hotelpo)throws RemoteException{
		int hotel_id = hotelpo.getId();
		if(map.get(hotel_id) == null){
			map.put(hotel_id, hotelpo);
			hotelDataHelper.updateHotelData(map);
			return true;
		}
		return false;	
	}//添加酒店信息
	
	public boolean delete(HotelPO hotelpo)throws RemoteException{
		int hotel_id = hotelpo.getId();
		if(map.get(hotel_id) != null){
			map.remove(hotel_id);
			hotelDataHelper.updateHotelData(map);
			return true;
		}
		return false;
		
	}//删除酒店信息
	
	public boolean update(HotelPO hotelpo)throws RemoteException{
		int hotel_id = hotelpo.getId();
		if(map.get(hotel_id) != null){
			map.put(hotel_id, hotelpo);
			hotelDataHelper.updateHotelData(map);
			return true;
		}
		return false;	
	}//更新酒店信息
	
	public ArrayList<HotelPO> showAll()throws RemoteException{
		return null;
		
	}
	
	public ArrayList<HotelPO> hotelShowAll(int hotel_id)throws RemoteException{
		return null;
		
	}
	
	public ArrayList<HotelPO> roomShowAll(HotelPO hotelpo, int room_id)throws RemoteException{
		return null;
	}
	
	public boolean updateRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) != null){
			map_room.put(room_id, roompo);
			hotelDataHelper.updateRoomData(map_room);
			return true;
		}
		return false;
		
	}
	
	public boolean insertRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) == null){
			map_room.put(room_id, roompo);
			hotelDataHelper.updateRoomData(map_room);
			return true;
		}
        return false;
		
	}

}
