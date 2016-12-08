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
	 
	public boolean insertMember(MemberVO vo) throws ParseException, RemoteException{
		MemberPO po=vo.topo();
		if(memberService.insert(po)){
		return true;
	}
		return false;
	
	
}
}
