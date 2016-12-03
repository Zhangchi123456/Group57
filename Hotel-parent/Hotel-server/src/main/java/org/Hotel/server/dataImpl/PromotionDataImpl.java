package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.PromotionDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class PromotionDataImpl extends UnicastRemoteObject implements PromotionDataService,Serializable{
	

	private Map<Integer, WebPromotionPO> map_web;
	
	private Map<Integer, HotelPromotionPO> map_hotel;
	
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
		int webpro_id = po.getId();
		if(map_web.get(webpro_id) == null){
			map_web.put(webpro_id, po);
			webproDataHelper.insertWebPromotionData(po);
			return true;
		}
		return false;

	}
	
	public boolean delete(WebPromotionPO po) throws RemoteException{

		int webpro_id = po.getId();
		if(map_web.get(webpro_id) != null){
			map_web.remove(webpro_id, po);
			webproDataHelper.deleteWebPromotionData(po);
			return true;
		}
		return false;

	}
	public boolean update(WebPromotionPO po) throws RemoteException{

		int webpro_id = po.getId();
		if(map_web.get(webpro_id) != null){
			map_web.put(webpro_id, po);
			webproDataHelper.updateWebPromotionData(po);
			return true;
		}
		return false;

	}
	
	public boolean insert(HotelPromotionPO po) throws RemoteException{
		int hotelpro_id = po.getId();
		if(map_hotel.get(hotelpro_id) == null){
			map_hotel.put(hotelpro_id, po);
			hotelproDataHelper.insertHotelPromotionData(po);
			update(po);
			return true;
		}
		return false;

	}
	
	public boolean delete(HotelPromotionPO po) throws RemoteException{

		int hotelpro_id = po.getId();
		if(map_hotel.get(hotelpro_id) != null){
			map_hotel.remove(hotelpro_id, po);
			hotelproDataHelper.deleteHotelPromotionData(po);
			update(po);
			return true;
		}
		return false;

	}
	
	public boolean update(HotelPromotionPO po) throws RemoteException{

		int hotelpro_id = po.getId();
		if(map_hotel.get(hotelpro_id) != null){
			map_hotel.put(hotelpro_id, po);
			hotelproDataHelper.updateHotelPromotionData(po);
			update(po);
			return true;
		}
		return false;
	}
	
	public ArrayList<WebPromotionPO> findByWebProID(String hotel_id) throws RemoteException{
		ArrayList<WebPromotionPO> webprolist = new ArrayList<WebPromotionPO>();
		Iterator<Map.Entry<Integer,WebPromotionPO>> iterator = map_web.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebPromotionPO> entry = iterator.next();
			WebPromotionPO webpropo = entry.getValue();
			if(hotel_id==webpropo.getHotelid())
			webprolist.add(webpropo);
		}
		return webprolist;
	}
	
	public WebPromotionPO findByWebProType(int type, String hotel_id) throws RemoteException{
		WebPromotionPO webpropo = new WebPromotionPO();
		Iterator<Map.Entry<Integer,WebPromotionPO>> iterator = map_web.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebPromotionPO> entry = iterator.next();
			webpropo = entry.getValue();
			if(type==webpropo.getType()&&hotel_id == webpropo.getHotelid())
			break;
		}
		return webpropo;
	}
	
	public ArrayList<WebPromotionPO> showAllWebPro() throws RemoteException{
		ArrayList<WebPromotionPO> webprolist = new ArrayList<WebPromotionPO>();
		Iterator<Map.Entry<Integer,WebPromotionPO>> iterator = map_web.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebPromotionPO> entry = iterator.next();
			WebPromotionPO webpropo = entry.getValue();
			webprolist.add(webpropo);
	}
		return webprolist;
	}
	
	public ArrayList<HotelPromotionPO> findByHotelProID(String hotel_id) throws RemoteException{
		ArrayList<HotelPromotionPO> hotelprolist = new ArrayList<HotelPromotionPO>();
		Iterator<Map.Entry<Integer,HotelPromotionPO>> iterator = map_hotel.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, HotelPromotionPO> entry = iterator.next();
			HotelPromotionPO hotelpropo = entry.getValue();
			if(hotel_id==hotelpropo.getHotelid())
				hotelprolist.add(hotelpropo);
		}
		return hotelprolist;
	}
	
	public HotelPromotionPO findByHotelProType(int type, String hotel_id) throws RemoteException{
		HotelPromotionPO hotelpropo = new HotelPromotionPO();
		Iterator<Map.Entry<Integer,HotelPromotionPO>> iterator = map_hotel.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, HotelPromotionPO> entry = iterator.next();
			
		    hotelpropo = entry.getValue();
			if(type==hotelpropo.getType()&&hotel_id == hotelpropo.getHotelid())
            break;
		}
		return hotelpropo;
		}
	
	public ArrayList<HotelPromotionPO> showAllHotelPro() throws RemoteException{
		ArrayList<HotelPromotionPO> hotelprolist = new ArrayList<HotelPromotionPO>();
		Iterator<Map.Entry<Integer,HotelPromotionPO>> iterator = map_hotel.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, HotelPromotionPO> entry = iterator.next();
			HotelPromotionPO hotelpropo = entry.getValue();
			hotelprolist.add(hotelpropo);
	}
		return hotelprolist;
	}

	
}
