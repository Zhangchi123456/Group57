package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberLevelPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.MemberDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

@SuppressWarnings("serial")
public class MemberDataImpl extends UnicastRemoteObject implements MemberDataService,Serializable{
	

	private Map<Integer, MemberPO> map;
	
	private Map<Integer, MemberLevelPO> map_lv;
	
	private Map<Integer, CreditPO> map_cre;
	
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

	/*
	 * DickChou
	 * 增删改查
	 */
	public boolean insert(MemberPO po) throws RemoteException{
		int member_id = po.getId();
		if(map.get(member_id) == null){
			map.put(member_id, po);
			memberDataHelper.insertMemberData(po);
			return true;
		}else
		return false;
	}
	
	public boolean delete(MemberPO po) throws RemoteException{
		int member_id = po.getId();
		if(map.get(member_id) != null){
			map.remove(member_id, po);
			memberDataHelper.deleteMemberData(po);
			return true;
		}else
		return false;
	
	}
	
	public boolean update(MemberPO po) throws RemoteException{
		int member_id = po.getId();
		if(map.get(member_id) != null){
			map.put(member_id, po);
			memberDataHelper.updateMemberData(po);
			return true;
		}else
		return false;

	}
	
	public boolean insert(CreditPO po) throws RemoteException{
		if(po!=null){
			creditDataHelper.insertCreditData(po);
			map_cre=creditDataHelper.getCreditData();
				return true;
			}
			else
				return false;
	}
	
	
	public boolean update(CreditPO po) throws RemoteException{
		int id = po.getId();
		if(map_cre.get(id) != null){
			map_cre.put(id, po);
			creditDataHelper.updateCreditData(po);
			return true;
		}else
		return false;

	}
	
	public boolean update(MemberLevelPO po) throws RemoteException{
		int member_lv = po.getLevel();
		if(map_lv.get(member_lv) != null){
			map_lv.put(member_lv, po);
			memberlvDataHelper.updateMemberLevelData(po);
			return true;
		}else
		return false;

	}

	//找用户
	public MemberPO find(String name) throws RemoteException{
		MemberPO po = new MemberPO();
		Iterator<Entry<Integer, MemberPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, MemberPO> entry = iterator.next();
			po = entry.getValue();
		if(name.equals(po.getName()))
        return po;
		}
			return null;
	
	}
	//找信用记录
	public ArrayList<CreditPO> findCreditByName(String name) throws RemoteException{
		ArrayList<CreditPO> list = new ArrayList<CreditPO>();
		Iterator<Entry<Integer, CreditPO>> iterator = map_cre.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, CreditPO> entry = iterator.next();
			CreditPO po = entry.getValue();
		if(name.equals(po.getName()))
        list.add(po);
		}
			return list;
	}
	//找会员
	public MemberLevelPO findLV(int level) throws RemoteException{
		MemberLevelPO po = new MemberLevelPO();
		Iterator<Entry<Integer, MemberLevelPO>> iterator = map_lv.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, MemberLevelPO> entry = iterator.next();
			po = entry.getValue();
		if(level == po.getLevel())
       
			return po;
		}
			return null;
	}
	//找订单的信用记录
	public CreditPO findCreditRecord(int orderid) throws RemoteException{
		CreditPO po = new CreditPO();
		Iterator<Entry<Integer, CreditPO>> iterator = map_cre.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, CreditPO> entry = iterator.next();
			po = entry.getValue();
		if(orderid == po.getOrderid())
        return po;
		}
			return null;
	}
	//显示所有用户
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
	//显示所有会员
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
