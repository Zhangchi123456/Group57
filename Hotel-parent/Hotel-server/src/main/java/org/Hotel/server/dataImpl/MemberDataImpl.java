package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.MemberDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class MemberDataImpl extends UnicastRemoteObject implements MemberDataService,Serializable{
	

	private Map<Integer, MemberPO> map;
	
	private MemberDataHelper memberDataHelper;
	
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
	
	public MemberPO find(String name) throws RemoteException{
		MemberPO po = map.get(name);
		return po;
	}
	
	public ArrayList<MemberPO> showAll() throws RemoteException{
		ArrayList<MemberPO> memberlist = new ArrayList<MemberPO>();
		Iterator<Map.Entry<Integer,MemberPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, MemberPO> entry = iterator.next();
			MemberPO orderPo = entry.getValue();
			memberlist.add(orderPo);
		}
		return memberlist;
	}

}
