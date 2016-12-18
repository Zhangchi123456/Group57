package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberPO;

import BusinessLogicService.Service.MemberInfo;
import BusinessLogicService.Service.MemberLogicService;
import vo.CreditRecordVO;
import vo.MemberLevelVO;
import vo.MemberVO;

public class MemberLogicServiceImpl implements MemberLogicService,MemberInfo{
	MemberDataService memberService =(MemberDataService)RMIHelper.find("MemberDataService");
	 public boolean updateMemberinfo(MemberVO vo) throws ParseException, RemoteException{
		 MemberPO po=vo.topo();	
		 if(memberService.update(po)){
			 return true;
		 }
		 return false;
	 }
	 public MemberVO Findmemberbyname(String name) throws RemoteException{		
		 MemberPO po=memberService.find(name);
		 MemberVO vo=new MemberVO(0, 0, name, name, name);
		 vo.setbypo(po);
		 return vo;
	 }
	 
	 public ArrayList<CreditRecordVO> FindCreditbyname(String name) throws RemoteException, ParseException{		
		 ArrayList<CreditPO> creditpolist=memberService.findCreditByName(name);		
		 ArrayList<CreditRecordVO> creditvolist=new ArrayList<CreditRecordVO>();
		 for(int i=0;i<creditpolist.size();i++){
			 CreditRecordVO vo=new CreditRecordVO();
			 vo.setbyCreditPO(creditpolist.get(i));
			 creditvolist.add(vo);
		 }
		 
		 return creditvolist;
	 }
	
	public ArrayList<MemberVO> showall() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<MemberPO> allmember = memberService.showAll();
		ArrayList<MemberVO> member = new ArrayList<MemberVO>();
		for(int i=0;i<allmember.size();i++){
			MemberVO  vo =new MemberVO(0, 0, null, null, null);
			vo.setbypo(allmember.get(i));
			member.add(vo);
		}
		return member;
	}
	
	public boolean addCreditRecord(CreditRecordVO vo) throws ParseException, RemoteException{
		CreditPO po=vo.ToCreditpo();
		if(memberService.insert(po)){
			return true;
		}
		return false;
	}
	@Override
	public CreditRecordVO findCreditRecord(int orderid) throws RemoteException {
		// TODO Auto-generated method stub
		CreditPO po =memberService.findCreditRecord(orderid);
		CreditRecordVO vo = new CreditRecordVO();
		 vo.setbyCreditPO(po);
		return vo;
	}
	//method for interface memberinfo
	//pass member po to other bl
	@Override
	public MemberPO findMemberByName(String name) {
		MemberPO po=null;
		try {
			po=memberService.find(name);
			if(po!=null)
				return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public void saveMember(MemberVO vo) {
		 MemberPO po=null;
		 try {
			po=vo.topo();
			memberService.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
	}
	public MemberLevelVO getMemberLevel(int lv) {
		//获取会员级别对应信息
			MemberLevelVO vo = new MemberLevelVO();
			try {
				vo.setByPO(memberService.findLV(lv));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return vo;
		}
	
	public boolean updateMemberLevel(MemberLevelVO vo) {
		//更新会员级别信息	
			try{
				int lv = vo.getLevel();
				if(lv==1){
					if(vo.getCredit()<memberService.findLV(2).getCredit()){
						memberService.update(vo.toPO());
						return true;
					}
				}else if(lv==6){
					if(vo.getCredit()>memberService.findLV(5).getCredit()){
						memberService.update(vo.toPO());
						return true;
					}
				}else{
					if(vo.getCredit()>memberService.findLV(lv-1).getCredit()
							&&vo.getCredit()<memberService.findLV(lv+1).getCredit()){
						memberService.update(vo.toPO());
						return true;
					}
				}
			}catch(RemoteException e){
				e.printStackTrace();
			}
			return false;
		}
	
	
}
