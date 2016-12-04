package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class HotelDataImpl extends UnicastRemoteObject implements HotelDataService,Serializable{

	private Map<String, HotelPO> map;
	
	private Map<Integer, RoomPO> map_room;
	
	private HotelDataHelper hotelDataHelper;
	
	private HotelDataHelper roomDataHelper;
	
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
		if(map_room == null){
			dataFactory = new DataFactoryImpl();
			roomDataHelper = dataFactory.getHotelDataHelper();
			map_room = roomDataHelper.getRoomData();
		}
	}
	
	public boolean insert(HotelPO hotelpo)throws RemoteException{
		String hotel_id = hotelpo.getName();
		if(map.get(hotel_id) == null){
			map.put(hotel_id, hotelpo);
			hotelDataHelper.insertHotelData(hotelpo);
			return true;
		}
		return false;	
	}//添加酒店信息
	
	public boolean delete(HotelPO hotelpo)throws RemoteException{
		String hotel_id = hotelpo.getName();
		if(map.get(hotel_id) != null){
			map.remove(hotel_id);
			hotelDataHelper.deleteHotelData(hotelpo);
			return true;
		}
		return false;
		
	}//删除酒店信息
	
	public boolean update(HotelPO hotelpo)throws RemoteException{
		String hotel_id = hotelpo.getName();
		if(map.get(hotel_id) != null){
			map.put(hotel_id, hotelpo);
			hotelDataHelper.updateHotelData(hotelpo);
			return true;
		}
		return false;	
	}//更新酒店信息
	
	public ArrayList<HotelPO> hotelShowAll(String circle, String hotel_id, int star, double grade)throws RemoteException{	
		ArrayList<HotelPO> hotellist=new ArrayList<HotelPO>();
		Iterator<Entry<String, HotelPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelPO> entry = iterator.next();
			HotelPO hotelpo = entry.getValue();
		if(circle == hotelpo.getCircle()||hotel_id==hotelpo.getName()||star==hotelpo.getStar()||grade==hotelpo.getGrade()){
			hotellist.add(hotelpo);
			return hotellist;
		}
		}
		return null;		
	}//显示所有酒店信息
	
	public ArrayList<RoomPO> roomShowAll(String hotel_id, int room_id, int room_num, String room_type)throws RemoteException{
		ArrayList<RoomPO> roomlist=new ArrayList<RoomPO>();
		Iterator<Map.Entry<Integer,RoomPO>> iterator = map_room.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, RoomPO> entry = iterator.next();
			RoomPO roompo = entry.getValue();
		if(hotel_id==roompo.getHotelid()||room_id==roompo.getId()||room_num==roompo.getRoomnum()||room_type==roompo.getRoomtype()){
			roomlist.add(roompo);
			return roomlist;
		}
		}
		return null;
	}//显示所有客房信息
	
	public boolean updateRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) != null){
			map_room.put(room_id, roompo);
			hotelDataHelper.updateRoomData(roompo);
			return true;
		}
		return false;
		
	}
	
	public boolean deleteRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) != null){
			map_room.remove(room_id, roompo);
			hotelDataHelper.deleteRoomData(roompo);
			return true;
		}
		return false;
		
	}
	public boolean insertRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) == null){
			map_room.put(room_id, roompo);
			hotelDataHelper.insertRoomData(roompo);
			return true;
		}
        return false;
		
	}

}
