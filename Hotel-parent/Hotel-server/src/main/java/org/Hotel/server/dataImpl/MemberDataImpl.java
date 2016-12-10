package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.MemberLevelPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.MemberDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class MemberDataImpl extends UnicastRemoteObject implements MemberDataService,Serializable{
	

	private Map<Integer, MemberPO> map;
	
	private Map<Integer, MemberLevelPO> map_lv;
	
	private Map<String, CreditPO> map_cre;
	
	private MemberDataHelper memberDataHelper, memberlvDataHelper, creditDataHelper;
	
	private DataFactory dataFactory;
	
	private static MemberDataImpl memberDataImpl;
	
	public static MemberDataImpl getInstance() throws RemoteException{
		if(memberDataImpl == null){
			memberDataImpl = new MemberDataImpl();
		}
		return memberDataImpl;
	}
	
	public MemberDataImpl()throws RemoteException{
		if(map == null){
			dataFactory = new DataFactoryImpl();
			memberDataHelper = dataFactory.getMemberDataHelper();
			map = memberDataHelper.getMemberData();
		}
		
		if(map_lv == null){
			dataFactory = new DataFactoryImpl();
			memberlvDataHelper = dataFactory.getMemberDataHelper();
			map_lv = memberlvDataHelper.getMemberLevelData();
		}
		
		if(map_cre == null){
			dataFactory = new DataFactoryImpl();
			creditDataHelper = dataFactory.getMemberDataHelper();
			map_cre = creditDataHelper.getCreditData();
		}
		
	}

	public boolean insert(MemberPO po) throws RemoteException{
		int member_id = po.getId();
		if(map.get(member_id) == null){
			map.put(member_id, po);
			memberDataHelper.insertMemberData(po);
			return true;
		}
		return false;
	}
	
	public boolean delete(MemberPO po) throws RemoteException{
		int member_id = po.getId();
		if(map.get(member_id) != null){
			map.remove(member_id, po);
			memberDataHelper.deleteMemberData(po);
			return true;
		}
		return false;
	
	}
	
	public boolean update(MemberPO po) throws RemoteException{
		int member_id = po.getId();
		if(map.get(member_id) != null){
			map.put(member_id, po);
			memberDataHelper.updateMemberData(po);
			return true;
		}
		return false;

	}
	
	public boolean insert(CreditPO po) throws RemoteException{
		String name = po.getName();
		if(map_cre.get(name) == null){
			map_cre.put(name, po);
			creditDataHelper.insertCreditData(po);
			return true;
		}
		return false;
	}
	
	public boolean delete(CreditPO po) throws RemoteException{
		String name = po.getName();
		if(map_cre.get(name) != null){
			map_cre.remove(name, po);
			creditDataHelper.deleteCreditData(po);
			return true;
		}
		return false;
	
	}
	
	public boolean update(CreditPO po) throws RemoteException{
		String name = po.getName();
		if(map_cre.get(name) != null){
			map_cre.put(name, po);
			creditDataHelper.updateCreditData(po);
			return true;
		}
		return false;

	}
	
	public boolean update(MemberLevelPO po) throws RemoteException{
		int member_lv = po.getLevel();
		if(map_lv.get(member_lv) != null){
			map_lv.put(member_lv, po);
			memberlvDataHelper.updateMemberLevelData(po);
			return true;
		}
		return false;

	}

	
	public MemberPO find(String name) throws RemoteException{
		MemberPO po = new MemberPO();
		Iterator<Entry<Integer, MemberPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, MemberPO> entry = iterator.next();
			po = entry.getValue();
		if(name.equals(po.getName()))
        break;
		}
			return po;
	
	}
	
	public CreditPO findCreditByName(String name) throws RemoteException{
		CreditPO po = new CreditPO();
		Iterator<Entry<String, CreditPO>> iterator = map_cre.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, CreditPO> entry = iterator.next();
			po = entry.getValue();
		if(name.equals(po.getName()))
        break;
		}
			return po;
	}
	
	public MemberLevelPO findLV(int level) throws RemoteException{
		MemberLevelPO po = new MemberLevelPO();
		Iterator<Entry<Integer, MemberLevelPO>> iterator = map_lv.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, MemberLevelPO> entry = iterator.next();
			po = entry.getValue();
		if(level == po.getLevel())
        break;
		}
			return po;
	}
	
	public ArrayList<MemberPO> showAll() throws RemoteException{
		ArrayList<MemberPO> memberlist = new ArrayList<MemberPO>();
		Iterator<Map.Entry<Integer,MemberPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, MemberPO> entry = iterator.next();
			MemberPO memberpo = entry.getValue();
			memberlist.add(memberpo);
		}
		return memberlist;
	}
	
	public ArrayList<MemberLevelPO> showAllLV() throws RemoteException{
		ArrayList<MemberLevelPO> memberlvlist = new ArrayList<MemberLevelPO>();
		Iterator<Map.Entry<Integer,MemberLevelPO>> iterator = map_lv.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, MemberLevelPO> entry = iterator.next();
			MemberLevelPO po = entry.getValue();
			memberlvlist.add(po);
		}
		return memberlvlist;
	}

}
