package Helper;



import java.rmi.RemoteException;
import java.text.ParseException;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.po.MemberPO;

import BusinessLogicService.impl.RMIHelper;
import vo.MemberVO;
import vo.WebPromotionVO;

public class RegisterHelper {
      MemberDataService memberService=(MemberDataService)RMIHelper.find("MemberDataService");
	
	public RegisterHelper(){
		
	}
	 //注册会员方法
	public boolean insertMember(MemberVO vo){
		MemberPO po;
		try {
			po = vo.topo();
			try {
				if(memberService.insert(po)){
					
					return true;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	
	
}
}
