package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberPO;

import BusinessLogicService.Service.MemberLogicService;
import vo.CreditRecordVO;
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
	 
	 public ArrayList<CreditRecordVO> FindCreditbyname(String name) throws RemoteException, ParseException{
		 memberService=(MemberDataService)RMIHelper.find("MemberDataService");
		 ArrayList<CreditPO> creditpolist=memberService.findCreditByName(name);
		
		 ArrayList<CreditRecordVO> creditvolist=new ArrayList<CreditRecordVO>();
		 for(int i=0;i<creditpolist.size();i++){
			 CreditRecordVO vo=new CreditRecordVO();
			 vo.setbyCreditPO(creditpolist.get(i));
			 creditvolist.add(vo);
		 }
		 
		 return creditvolist;
	 }
	 
}
