package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.PromotionDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class PromotionDataImpl extends UnicastRemoteObject implements PromotionDataService,Serializable{
	

	private Map<Date, WebPromotionPO> map_web;
	
	private Map<String, HotelPromotionPO> map_hotel;
	
	private PromotionDataHelper webproDataHelper,hotelproDataHelper;
	
	private DataFactory dataFactory;
	
	private static PromotionDataImpl proDataImpl;
	
	public static PromotionDataImpl getInstance() throws RemoteException{
		if(proDataImpl == null){
			proDataImpl = new PromotionDataImpl();
		}
		return proDataImpl;
	}
	
	public PromotionDataImpl()throws RemoteException{
		if(map_web == null){
			dataFactory = new DataFactoryImpl();
			webproDataHelper = dataFactory.getPromotionDataHelper();
			map_web = webproDataHelper.getWebPromotionData();
		}

		if(map_hotel == null){
			dataFactory = new DataFactoryImpl();
			hotelproDataHelper = dataFactory.getPromotionDataHelper();
			map_hotel = hotelproDataHelper.getHotelPromotionData();
		}
	}
	
	public boolean insert(WebPromotionPO po) throws RemoteException{
		Date date = po.getStartdate();
		if(map_web.get(date)==null)	
		map_web.put(date, po);
			webproDataHelper.insertWebPromotionData(po);
			return true;

	}
	
	public boolean delete(WebPromotionPO po) throws RemoteException{
			map_web.remove(po);
			webproDataHelper.deleteWebPromotionData(po);
			return true;

	}
	
	public boolean insert(HotelPromotionPO po) throws RemoteException{
		String hotelpro_id = po.getId();
		if(map_hotel.get(hotelpro_id) != null){
			map_hotel.put(hotelpro_id, po);
			hotelproDataHelper.insertHotelPromotionData(po);
			update(po);
			return true;
		}
		return false;

	}
	
	public boolean delete(HotelPromotionPO po) throws RemoteException{

		String hotelpro_id = po.getId();
		if(map_hotel.get(hotelpro_id) != null){
			map_hotel.remove(hotelpro_id, po);
			hotelproDataHelper.deleteHotelPromotionData(po);
			update(po);
			return true;
		}
		return false;

	}
	
	public boolean update(HotelPromotionPO po) throws RemoteException{

		String hotelpro_id = po.getId();
		if(map_hotel.get(hotelpro_id) != null){
			map_hotel.put(hotelpro_id, po);
			hotelproDataHelper.updateHotelPromotionData(po);
			update(po);
			return true;
		}
		return false;
	}
	
	public ArrayList<WebPromotionPO> showAllWebPro() throws RemoteException{
		ArrayList<WebPromotionPO> webprolist = new ArrayList<WebPromotionPO>();
		Iterator<Entry<Date, WebPromotionPO>> iterator = map_web.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Date, WebPromotionPO> entry = iterator.next();
			WebPromotionPO webpropo = entry.getValue();
			webprolist.add(webpropo);
	}
		return webprolist;
	}
	
	public ArrayList<HotelPromotionPO> findByHotelProID(String hotel_id) throws RemoteException{
		ArrayList<HotelPromotionPO> hotelprolist = new ArrayList<HotelPromotionPO>();
		Iterator<Entry<String, HotelPromotionPO>> iterator = map_hotel.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelPromotionPO> entry = iterator.next();
			HotelPromotionPO hotelpropo = entry.getValue();
			if(hotel_id==hotelpropo.getHotelid())
				hotelprolist.add(hotelpropo);
		}
		return hotelprolist;
	}
	
	public HotelPromotionPO findByHotelProType(String type, String hotel_id) throws RemoteException{
		HotelPromotionPO hotelpropo = new HotelPromotionPO();
		Iterator<Entry<String, HotelPromotionPO>> iterator = map_hotel.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelPromotionPO> entry = iterator.next();
			
		    hotelpropo = entry.getValue();
			if(type==hotelpropo.getType()&&hotel_id == hotelpropo.getHotelid())
            break;
		}
		return hotelpropo;
		}
	
	public ArrayList<HotelPromotionPO> showAllHotelPro() throws RemoteException{
		ArrayList<HotelPromotionPO> hotelprolist = new ArrayList<HotelPromotionPO>();
		Iterator<Entry<String, HotelPromotionPO>> iterator = map_hotel.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelPromotionPO> entry = iterator.next();
			HotelPromotionPO hotelpropo = entry.getValue();
			hotelprolist.add(hotelpropo);
	}
		return hotelprolist;
	}

	
}
