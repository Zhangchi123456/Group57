package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class HotelDataImpl extends UnicastRemoteObject implements HotelDataService,Serializable{

	private Map<String, HotelPO> map;
	
	private Map<Integer, RoomPO> map_room;
	
	private Map<String, CirclePO> map_circle;
	
	private HotelDataHelper hotelDataHelper;
	
	private HotelDataHelper roomDataHelper;
	
	private HotelDataHelper circleDataHelper;
	
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
		if(map_circle == null){
			dataFactory = new DataFactoryImpl();
			circleDataHelper = dataFactory.getHotelDataHelper();
			map_circle = circleDataHelper.getCircleData();
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
	
	public boolean update(CirclePO po)throws RemoteException{
		String name = po.getName();
		if(map_circle.get(name) != null){
			map_circle.put(name, po);
			circleDataHelper.updateCircleData(po);
			return true;
		}
		return false;	
	}
	
	public ArrayList<HotelPO> hotelShowAll(String circle, String hotel_id, int star, double grade)throws RemoteException{	
		ArrayList<HotelPO> hotellist=new ArrayList<HotelPO>();
		Iterator<Entry<String, HotelPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelPO> entry = iterator.next();
			HotelPO hotelpo = entry.getValue();
		if(circle.equals(hotelpo.getCircle())||hotel_id.equals(hotelpo.getName())||star == hotelpo.getStar()||grade == hotelpo.getGrade()){
			hotellist.add(hotelpo);
		
		}
		}
		return hotellist;		
	}//显示所有酒店信息
	
	public ArrayList<HotelPO> FindhotelByCircle(String circle)throws RemoteException{	
		ArrayList<HotelPO> hotellist=new ArrayList<HotelPO>();
		Iterator<Entry<String, HotelPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelPO> entry = iterator.next();
			HotelPO hotelpo = entry.getValue();
		if(circle.equals(hotelpo.getCircle())){
			hotellist.add(hotelpo);
		}
		}
		return hotellist;		
	}//显示商圈内所有酒店信息
	
	public ArrayList<RoomPO> roomShowAll(String hotel_id)throws RemoteException{
		ArrayList<RoomPO> roomlist=new ArrayList<RoomPO>();
		Iterator<Map.Entry<Integer,RoomPO>> iterator = map_room.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, RoomPO> entry = iterator.next();
			RoomPO roompo = entry.getValue();
		if(hotel_id.equals(roompo.getHotelid())){
			roomlist.add(roompo);
			
		}
		}
		return roomlist;
	}//显示所有客房信息
	
	
	public boolean updateRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) != null){
			map_room.put(room_id, roompo);
			roomDataHelper.updateRoomData(roompo);
			return true;
		}else
		return false;
		
	}
	
	public boolean deleteRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) != null){
			map_room.remove(room_id, roompo);
			roomDataHelper.deleteRoomData(roompo);
			return true;
		}else
		return false;
		
	}
	public boolean insertRoom(RoomPO roompo)throws RemoteException{
		int room_id = roompo.getId();
		if(map_room.get(room_id) == null){
			map_room.put(room_id, roompo);
			roomDataHelper.insertRoomData(roompo);
			return true;
		}else
        return false;
		
	}
	
	public ArrayList<CirclePO> circleShowAll(String city)throws RemoteException{
		ArrayList<CirclePO> list=new ArrayList<CirclePO>();
		Iterator<Map.Entry<String,CirclePO>> iterator = map_circle.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, CirclePO> entry = iterator.next();
			CirclePO po = entry.getValue();
		if(city.equals(po.getCity())){
			list.add(po);
		}
		}

		return list;
	}
	
	public CirclePO circleFind(String city, String circle)throws RemoteException{
		CirclePO po = new CirclePO();
		Iterator<Map.Entry<String,CirclePO>> iterator = map_circle.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, CirclePO> entry = iterator.next();
			po = entry.getValue();
		if(city.equals(po.getCity())&&circle.equals(po.getName()))
        break;
		}
			return po;
	
	}
	
	public HotelPO Findhotelbyname(String hotelname)throws RemoteException{
		HotelPO po=new HotelPO();
		Iterator<Map.Entry<String, HotelPO>> iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String,HotelPO> entry=iterator.next();
			po=entry.getValue();
			if(hotelname.equals(po.getName())){
				break;
			}
			
		}
		return po;
	}
	
	public RoomPO FindroombyID(int roomid)throws RemoteException{
		RoomPO po=new RoomPO();
		Iterator<Entry<Integer, RoomPO>> iterator=map_room.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, RoomPO> entry=iterator.next();
			po=entry.getValue();
			if(roomid == po.getRoomid()){
				break;
			}
			
		}
		return po;
	}
	
	public ArrayList<String> cityShowAll()throws RemoteException{
		ArrayList<String> citylist = new ArrayList<String>();
		CirclePO po = new CirclePO();
		Iterator<Map.Entry<String,CirclePO>> iterator = map_circle.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, CirclePO> entry = iterator.next();
			po = entry.getValue();
			if(!citylist.contains(po.getCity()))
			citylist.add(po.getCity());

		}
		return citylist;
		
	}
	public static void main(String[] args) throws RemoteException{
		HotelDataImpl data =HotelDataImpl.getInstance();
		
		ArrayList<String> city=data.cityShowAll();
		for(String c:city){
			System.out.println(c);
		}
	}
}
