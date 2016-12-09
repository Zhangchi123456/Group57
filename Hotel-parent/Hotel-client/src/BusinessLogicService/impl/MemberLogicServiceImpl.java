package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.MemberPO;

import BusinessLogicService.Service.MemberLogicService;
import vo.MemberVO;

public class MemberLogicServiceImpl implements MemberLogicService{
	MemberDataService memberService;
	 public boolean updateMemberinfo(MemberVO vo) throws ParseException, RemoteException{
		 MemberPO po=vo.topo();
		 memberService=(MemberDataService)RMIHelper.find("MemberDataService");
		 if(memberService.update(po)){
			 return true;
		 }
		 return false;
	 }
	 public MemberVO Findmemberbyname(String name) throws RemoteException{
		 memberService=(MemberDataService)RMIHelper.find("MemberDataService");
		 MemberPO po=memberService.find(name);
		 MemberVO vo=new MemberVO(0, 0, name, name, name);
		 vo.setbypo(po);
		 return vo;
	 }
}
