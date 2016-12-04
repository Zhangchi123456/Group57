package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.Hotel.common.dataService.MemberDataService;
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
	
	private MemberDataHelper memberDataHelper, memberlvDataHelper;
	
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
		MemberPO po = map.get(name);
		return po;
	}
	
	public MemberPO findLV(String level) throws RemoteException{
		MemberPO po = map.get(level);
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
