package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.CreditRecordVO;
import vo.MemberVO;

public class MemberActController {
	private final static Map<String,Object> memberactmap = new HashMap<>();
	private final static String memberVokey="memberVo";
	private final static String creditrecordkey="creditrecord";
	
	
	private MemberActController(){
		
	}
	 public static void setMembervo(MemberVO memberVo){
  	   memberactmap.put(memberVokey,memberVo );
     }
     public static  MemberVO getmemberVo(){
  	   return (MemberVO)memberactmap.get(memberVokey);
     }
     public static void setCreditrecordvoList(ArrayList<CreditRecordVO> creditrecord){
    	   memberactmap.put(memberVokey,creditrecord );
       }
       public static  ArrayList<CreditRecordVO> getCreditRecordVOList(){
    	   return (ArrayList<CreditRecordVO>)memberactmap.get(creditrecordkey);
       }
}
