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
	
	public ArrayList<HotelPO> hotelShowAll(String circle, int hotel_id, HotelPO hotelpo, double price, int star, double grade, String room_type)throws RemoteException{	
		ArrayList<HotelPO> hotellist=new ArrayList<HotelPO>();
		if(circle == hotelpo.getCircle()||hotel_id==hotelpo.getID()||price==hotelpo.getPrice()||star==hotelpo.getStar()||grade==hotelpo.getGrade()||room_type==hotelpo.getRoomtype()){
			hotellist.add(hotelpo);
			return hotellist;
		}
		return null;		
	}//显示所有酒店信息
	
	public ArrayList<RoomPO> roomShowAll(RoomPO roompo, int room_id, int room_num, int room_type)throws RemoteException{
		ArrayList<RoomPO> roomlist=new ArrayList<RoomPO>();
		if(room_id==roompo.getID()||room_num==roompo.getNum()||room_type==roompo.getRoomtype()){
			roomlist.add(roompo);
			return roomlist;
		}
		return null;
	}//显示所有客房信息
	
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
