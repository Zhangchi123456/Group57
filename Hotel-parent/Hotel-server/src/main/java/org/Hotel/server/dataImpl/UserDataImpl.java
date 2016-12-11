package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebStaffPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.UserDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService,Serializable{
	

	private Map<String, HotelStaffPO> map_hotels;
	
	private Map<String, WebStaffPO> map_webs;
	
	private Map<String, WebManagerPO> map_webm;
	
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
		String name = po.getName();
		if(map_hotels.get(name) == null){
			map_hotels.put(name, po);
			hotelsDataHelper.insertHotelStaffData(po);
			return true;
		}else
		return false;
	}
	
	public boolean insert(WebStaffPO po) throws RemoteException{
		String name = po.getName();
		if(map_webs.get(name) == null){
			map_webs.put(name, po);
			websDataHelper.insertWebStaffData(po);
			return true;
		}else
		return false;
	}
	
	public boolean insert(WebManagerPO po) throws RemoteException{
		String name = po.getName();
		if(map_webm.get(name) == null){
			map_webm.put(name, po);
			webmDataHelper.insertWebManagerData(po);
			return true;
		}else
		return false;
	}
	
	public boolean delete(HotelStaffPO po) throws RemoteException{
			String name = po.getName();
			if(map_hotels.get(name) != null){
				map_hotels.remove(name, po);
				hotelsDataHelper.deleteHotelStaffData(po);
				return true;
			}else
			return false;
		}
	
	public boolean delete(WebStaffPO po) throws RemoteException{
		String name = po.getName();
		if(map_webs.get(name) != null){
			map_webs.remove(name, po);
			websDataHelper.deleteWebStaffData(po);
			return true;
		}else
		return false;
	}
	
	public boolean delete(WebManagerPO po) throws RemoteException{
		String name = po.getName();
		if(map_webm.get(name) != null){
			map_webm.remove(name, po);
			webmDataHelper.deleteWebManagerData(po);
			return true;
		}else
		return false;
	}
	
	public boolean update(HotelStaffPO po) throws RemoteException{
		String name = po.getName();
		if(map_hotels.get(name) != null){
			map_hotels.put(name, po);
			hotelsDataHelper.updateHotelStaffData(po);
			return true;
		}else
		return false;
	}
	
	public boolean update(WebStaffPO po) throws RemoteException{
		String name = po.getName();
		if(map_webs.get(name) != null){
			map_webs.put(name, po);
			websDataHelper.updateWebStaffData(po);
			return true;
		}else
		return false;
	}
	
	public boolean update(WebManagerPO po) throws RemoteException{
		String name = po.getName();
		if(map_webm.get(name) != null){
			map_webm.put(name, po);
			webmDataHelper.updateWebManagerData(po);
			return true;
		}else
		return false;
	}
	
	public HotelStaffPO findByHotelStaff(String name) throws RemoteException{
		HotelStaffPO po = new HotelStaffPO();
		Iterator<Entry<String, HotelStaffPO>> iterator = map_hotels.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelStaffPO> entry = iterator.next();
			po = entry.getValue();
			if(name.equals(po.getName()))
			break;
		}
		return po;
	}
	
	public WebStaffPO findByWebStaff(String name) throws RemoteException{
		System.out.println(name);
		WebStaffPO po = new WebStaffPO();
		Iterator<Entry<String, WebStaffPO>> iterator = map_webs.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, WebStaffPO> entry = iterator.next();
			po = entry.getValue();
			if(name.equals(po.getName())){
				return po;
			}
			
		}
		return null;
	}
	
	public WebManagerPO findByWebManager(String name) throws RemoteException{
		WebManagerPO po = new WebManagerPO();
		Iterator<Entry<String, WebManagerPO>> iterator = map_webm.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, WebManagerPO> entry = iterator.next();
			po = entry.getValue();
			if(name.equals(po.getName()))
			break;
		}
		return po;
	}
	
	public ArrayList<HotelStaffPO> showAllHotelStaff() throws RemoteException{
		ArrayList<HotelStaffPO> hotelslist = new ArrayList<HotelStaffPO>();
		Iterator<Entry<String, HotelStaffPO>> iterator = map_hotels.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, HotelStaffPO> entry = iterator.next();
			HotelStaffPO hotelspo = entry.getValue();
			hotelslist.add(hotelspo);
		}
		return hotelslist;
	}
	
	public ArrayList<WebStaffPO> showAllWebStaff() throws RemoteException{
		ArrayList<WebStaffPO> webslist = new ArrayList<WebStaffPO>();
		Iterator<Entry<String, WebStaffPO>> iterator = map_webs.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, WebStaffPO> entry = iterator.next();
			WebStaffPO webspo = entry.getValue();
			webslist.add(webspo);
		}
		return webslist;
	}
	
	public ArrayList<WebManagerPO> showAllWebManager() throws RemoteException{
		ArrayList<WebManagerPO> webmlist = new ArrayList<WebManagerPO>();
		Iterator<Entry<String, WebManagerPO>> iterator = map_webm.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, WebManagerPO> entry = iterator.next();
			WebManagerPO webmpo = entry.getValue();
			webmlist.add(webmpo);
		}
		return webmlist;
	}

}
