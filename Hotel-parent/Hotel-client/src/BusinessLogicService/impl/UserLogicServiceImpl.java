package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.WebStaffPO;

import BusinessLogicService.Service.UserLogicService;
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
	
//	public static void main(String[] args){
//		UserLogicServiceImpl user=new UserLogicServiceImpl();
//		ArrayList<WebStaffVO> list=user.findWebStaff();
//		for(WebStaffVO vo:list){
//			System.out.println(vo.getName());
//		}
//	}

}
