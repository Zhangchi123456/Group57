package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.common.po.WebStaffPO;

import BusinessLogicService.Service.UserLogicService;
import vo.HotelStaffVO;
import vo.MemberVO;
import vo.WebStaffVO;

public class UserLogicServiceImpl implements UserLogicService{
	UserDataService userdata=(UserDataService) RMIHelper.find("UserDataService");
	MemberDataService memberdata=(MemberDataService) RMIHelper.find("MemberDataService");
	
	
	@Override
	public ArrayList<WebStaffVO> findWebStaff() {
		try {
			ArrayList<WebStaffPO> list=userdata.showAllWebStaff();
			ArrayList<WebStaffVO> listvo=new ArrayList<>();
			for(WebStaffPO po:list){
				if(po!=null){
					WebStaffVO vo=new WebStaffVO(po.getName(),po.getPassword());
					listvo.add(vo);
				}
			}
			return listvo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void saveWebStaff(WebStaffVO vo) {
		WebStaffPO po=new WebStaffPO(vo.getName(),vo.getPassword());
		try {
			userdata.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public boolean findWebStaffBYName(String name) {
		WebStaffPO po=null;
		try {
			po=userdata.findByWebStaff(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return false;
		}else 
			return true;
		
	}


	@Override
	public boolean addWebStaff(WebStaffVO vo) {
		WebStaffPO po=new WebStaffPO(vo.getName(),vo.getPassword());
		try {
			return userdata.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public ArrayList<HotelStaffVO> findHotelStaff() {
		try {
			ArrayList<HotelStaffPO> list=userdata.showAllHotelStaff();
			ArrayList<HotelStaffVO> listvo=new ArrayList<>();
			for(HotelStaffPO po:list){
				if(po!=null){
					HotelStaffVO vo=new HotelStaffVO(po.getName(),po.getPassword(),po.getHotelName());
					listvo.add(vo);
				}
			}
			return listvo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void saveHotelStaff(HotelStaffVO vo) {
		HotelStaffPO po=new HotelStaffPO(vo.getName(),vo.getPassword(),vo.getHotelname());
		try {
			userdata.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public ArrayList<MemberVO> findMember() {
		try {
			ArrayList<MemberPO> list=memberdata.showAll();
			ArrayList<MemberVO> listvo=new ArrayList<>();
			for(MemberPO po:list){
				if(po!=null){
					MemberVO vo=new MemberVO(0, 0, null, null, null);
					vo.setbypo(po);
					listvo.add(vo);
				}
			}
			return listvo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void saveMember(MemberVO vo) {
		
		
	}
	

}
