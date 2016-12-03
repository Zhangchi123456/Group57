package Controller;


import java.util.HashMap;
import java.util.Map;

import vo.MemberVO;

public class ReservationController {
	private final static Map<String,Object> membermap = new HashMap<>();
	private final static String membervokey = "vo";	
       
       private ReservationController(){
    	   
       }
       public static void setMmembervo(MemberVO vo){
    	   membermap.put(membervokey, vo);
       }
       public static  MemberVO getMembervo(){
    	   return (MemberVO)membermap.get(membervokey);
       }
}
