package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.WebStaffPO;

import BusinessLogicService.Service.UserLogicService;
import vo.HotelStaffVO;
import vo.WebStaffVO;

public class UserLogicServiceImpl implements UserLogicService{
	UserDataService userdata=(UserDataService) RMIHelper.find("UserDataService");
	
	
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
			// TODO Auto-generated catch block
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
	
//	public static void main(String[] args){
//		UserLogicServiceImpl user=new UserLogicServiceImpl();
//		ArrayList<WebStaffVO> list=user.findWebStaff();
//		for(WebStaffVO vo:list){
//			System.out.println(vo.getName());
//		}
//	}

}
