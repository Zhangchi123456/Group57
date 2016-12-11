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
//		System.out.println(name);
		WebStaffPO po=null;
		try {
			po=userdata.findByWebStaff(name);
			System.out.println("name"+po.getName()+"passwrod"+po.getPassword());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(po.getName().length()==0){
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
	
//	public static void main(String[] args){
//		UserLogicServiceImpl user=new UserLogicServiceImpl();
//		ArrayList<WebStaffVO> list=user.findWebStaff();
//		for(WebStaffVO vo:list){
//			System.out.println(vo.getName());
//		}
//	}

}
