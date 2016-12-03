package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.UserPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebPromotionPO;
import org.Hotel.common.po.WebStaffPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.PromotionDataHelper;
import org.Hotel.server.datahelp.UserDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService,Serializable{
	

	private Map<Integer, HotelStaffPO> map_hotels;
	
	private Map<Integer, WebStaffPO> map_webs;
	
	private Map<Integer, WebManagerPO> map_webm;
	
	private UserDataHelper hotelsDataHelper,websDataHelper,webmDataHelper;
	
	private DataFactory dataFactory;
	
	private static UserDataImpl userDataImpl;
	
	public static UserDataImpl getInstance() throws RemoteException{
		if(userDataImpl == null){
			userDataImpl = new UserDataImpl();
		}
		return userDataImpl;
	}
	
	public UserDataImpl()throws RemoteException{
		if(map_hotels == null){
			dataFactory = new DataFactoryImpl();
			hotelsDataHelper = dataFactory.getUserDataHelper();
			map_hotels = hotelsDataHelper.getHotelStaffData();
		}

		if(map_webs == null){
			dataFactory = new DataFactoryImpl();
			websDataHelper = dataFactory.getUserDataHelper();
			map_webs = websDataHelper.getWebStaffData();
		}
		
		if(map_webm == null){
			dataFactory = new DataFactoryImpl();
			webmDataHelper = dataFactory.getUserDataHelper();
			map_webm = webmDataHelper.getWebManagerData();
		}
	}

	public boolean insert(HotelStaffPO po) throws RemoteException{
		int hotels_id = po.getId();
		if(map_hotels.get(hotels_id) == null){
			map_hotels.put(hotels_id, po);
			hotelsDataHelper.insertHotelStaffData(po);
			return true;
		}
		return false;
	}
	
	public boolean insert(WebStaffPO po) throws RemoteException{
		int webs_id = po.getId();
		if(map_webs.get(webs_id) == null){
			map_webs.put(webs_id, po);
			websDataHelper.insertWebStaffData(po);
			return true;
		}
		return false;
	}
	
	public boolean insert(WebManagerPO po) throws RemoteException{
		int webm_id = po.getId();
		if(map_webm.get(webm_id) == null){
			map_webm.put(webm_id, po);
			webmDataHelper.insertWebManagerData(po);
			return true;
		}
		return false;
	}
	
	public boolean delete(HotelStaffPO po) throws RemoteException{
			int hotels_id = po.getId();
			if(map_hotels.get(hotels_id) != null){
				map_hotels.remove(hotels_id, po);
				hotelsDataHelper.deleteHotelStaffData(po);
				return true;
			}
			return false;
		}
	
	public boolean delete(WebStaffPO po) throws RemoteException{
		int webs_id = po.getId();
		if(map_webs.get(webs_id) != null){
			map_webs.remove(webs_id, po);
			websDataHelper.deleteWebStaffData(po);
			return true;
		}
		return false;
	}
	
	public boolean delete(WebManagerPO po) throws RemoteException{
		int webm_id = po.getId();
		if(map_webm.get(webm_id) != null){
			map_webm.remove(webm_id, po);
			webmDataHelper.deleteWebManagerData(po);
			return true;
		}
		return false;
	}
	
	public boolean update(HotelStaffPO po) throws RemoteException{
		int hotels_id = po.getId();
		if(map_hotels.get(hotels_id) != null){
			map_hotels.put(hotels_id, po);
			hotelsDataHelper.updateHotelStaffData(po);
			return true;
		}
		return false;
	}
	
	public boolean update(WebStaffPO po) throws RemoteException{
		int webs_id = po.getId();
		if(map_webs.get(webs_id) != null){
			map_webs.put(webs_id, po);
			websDataHelper.updateWebStaffData(po);
			return true;
		}
		return false;
	}
	
	public boolean update(WebManagerPO po) throws RemoteException{
		int webm_id = po.getId();
		if(map_webm.get(webm_id) != null){
			map_webm.put(webm_id, po);
			webmDataHelper.updateWebManagerData(po);
			return true;
		}
		return false;
	}
	
	public ArrayList<HotelStaffPO> findByHotelStaff(int id) throws RemoteException{
		ArrayList<HotelStaffPO> hotelslist = new ArrayList<HotelStaffPO>();
		Iterator<Map.Entry<Integer,HotelStaffPO>> iterator = map_hotels.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, HotelStaffPO> entry = iterator.next();
			HotelStaffPO hotelspo = entry.getValue();
			if(id==hotelspo.getId())
			hotelslist.add(hotelspo);
		}
		return hotelslist;
	}
	
	public ArrayList<WebStaffPO> findByWebStaff(int id) throws RemoteException{
		ArrayList<WebStaffPO> webslist = new ArrayList<WebStaffPO>();
		Iterator<Map.Entry<Integer,WebStaffPO>> iterator = map_webs.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebStaffPO> entry = iterator.next();
			WebStaffPO webspo = entry.getValue();
			if(id==webspo.getId())
			webslist.add(webspo);
		}
		return webslist;
	}
	
	public ArrayList<WebManagerPO> findByWebManager(int id) throws RemoteException{
		ArrayList<WebManagerPO> webmlist = new ArrayList<WebManagerPO>();
		Iterator<Map.Entry<Integer,WebManagerPO>> iterator = map_webm.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebManagerPO> entry = iterator.next();
			WebManagerPO webmpo = entry.getValue();
			if(id==webmpo.getId())
			webmlist.add(webmpo);
		}
		return webmlist;
	}
	
	public ArrayList<HotelStaffPO> showAllHotelStaff() throws RemoteException{
		ArrayList<HotelStaffPO> hotelslist = new ArrayList<HotelStaffPO>();
		Iterator<Map.Entry<Integer,HotelStaffPO>> iterator = map_hotels.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, HotelStaffPO> entry = iterator.next();
			HotelStaffPO hotelspo = entry.getValue();
			hotelslist.add(hotelspo);
		}
		return hotelslist;
	}
	
	public ArrayList<WebStaffPO> showAllWebStaff() throws RemoteException{
		ArrayList<WebStaffPO> webslist = new ArrayList<WebStaffPO>();
		Iterator<Map.Entry<Integer,WebStaffPO>> iterator = map_webs.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebStaffPO> entry = iterator.next();
			WebStaffPO webspo = entry.getValue();
			webslist.add(webspo);
		}
		return webslist;
	}
	
	public ArrayList<WebManagerPO> showAllWebManager() throws RemoteException{
		ArrayList<WebManagerPO> webmlist = new ArrayList<WebManagerPO>();
		Iterator<Map.Entry<Integer,WebManagerPO>> iterator = map_webm.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, WebManagerPO> entry = iterator.next();
			WebManagerPO webmpo = entry.getValue();
			webmlist.add(webmpo);
		}
		return webmlist;
	}

}
