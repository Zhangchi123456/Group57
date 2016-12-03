package Controller;

import java.util.HashMap;
import java.util.Map;

import vo.MemberVO;

public class MemberActController {
	private final static Map<String,Object> memberactmap = new HashMap<>();
	private final static String memberVokey="memberVo";
	
	private MemberActController(){
		
	}
	 public static void setMembervo(MemberVO memberVo){
  	   memberactmap.put(memberVokey,memberVo );
     }
     public static  MemberVO getmemberVo(){
  	   return (MemberVO)memberactmap.get(memberVokey);
     }
}
