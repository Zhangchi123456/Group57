package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.MemberLevelPO;
import org.Hotel.common.po.MemberPO;

import BusinessLogicService.Service.MemberInfo;
import BusinessLogicService.Service.MemberLogicService;
import vo.CreditRecordVO;
import vo.MemberLevelVO;
import vo.MemberVO;

public class MemberLogicServiceImpl implements MemberLogicService,MemberInfo{
	MemberDataService memberService =(MemberDataService)RMIHelper.find("MemberDataService");
	//更新会员信息的方法实现
	 public boolean updateMemberinfo(MemberVO vo){
		 MemberPO po;
		try {
			po = vo.topo();
			 try {
				if(memberService.update(po)){
					 return true;
				 }
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	 }
	 //通过名字查找会员
	 public MemberVO Findmemberbyname(String name){		
		 MemberPO po;
		try {
			po = memberService.find(name);
			MemberVO vo=new MemberVO(0, 0, name, name, name);
			 vo.setbypo(po);
			 return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
	 }
	 //通过名字查找信用纪录的方法实现
	 public ArrayList<CreditRecordVO> FindCreditbyname(String name){		
		 ArrayList<CreditPO> creditpolist;
		try {
			creditpolist = memberService.findCreditByName(name);
			ArrayList<CreditRecordVO> creditvolist=new ArrayList<CreditRecordVO>();
			 for(int i=0;i<creditpolist.size();i++){
				 CreditRecordVO vo=new CreditRecordVO();
				 vo.setbyCreditPO(creditpolist.get(i));
				 creditvolist.add(vo);
			 }
			 
			 return creditvolist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
		 
	 }
	//展示所有会员的方法实现
	public ArrayList<MemberVO> showall() {
		ArrayList<MemberPO> allmember;
		try {
			allmember = memberService.showAll();
			ArrayList<MemberVO> member = new ArrayList<MemberVO>();
			for(int i=0;i<allmember.size();i++){
				MemberVO  vo =new MemberVO(0, 0, "non","non", "non");
	            vo.setbypo(allmember.get(i));
				member.add(vo);
			}
			return member;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	//获得所有会员名的方法实现
	public ArrayList<String> getnamelist(){
		ArrayList<String> namelist=new ArrayList<String>();
		ArrayList<MemberPO> allmember;
		try {
			allmember = memberService.showAll();
			for(int i=0;i<allmember.size();i++){
				String name;
				name=allmember.get(i).getName();
				
				namelist.add(name);
			}
			return namelist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	//生成一个新的信用纪录的方法实现
	public boolean addCreditRecord(CreditRecordVO vo){
		CreditPO po;
		try {
			po = vo.ToCreditpo();
			try {
				if(memberService.insert(po)){
					return true;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//通过订单号找到信用记录的方法
	@Override
	public CreditRecordVO findCreditRecord(int orderid){
		
		CreditPO po;
		try {
			po = memberService.findCreditRecord(orderid);
			CreditRecordVO vo = new CreditRecordVO();
			vo.setbyCreditPO(po);
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	//保存会员信息的方法实现
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
	//更新会员等级的方法实现
	public void updatelevel(MemberVO member){
		try {
			
			
			ArrayList<MemberLevelPO> levellist=memberService.showAllLV();
			int currentlow=1;
			for(int i=0;i<levellist.size();i++){
				if(member.getcredit()>levellist.get(i).getCredit()){
				if(levellist.get(i).getLevel()>=currentlow){
					currentlow=levellist.get(i).getLevel();
				}
				}
			}
			
			member.setMemberlevel(String.valueOf(currentlow));
			updateMemberinfo(member);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
