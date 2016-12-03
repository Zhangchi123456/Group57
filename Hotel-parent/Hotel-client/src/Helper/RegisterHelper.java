package Helper;

import java.util.HashMap;
import java.util.Map;

import vo.MemberVO;
import vo.WebPromotionVO;

public class RegisterHelper {
	private final static Map<String,Object> registermap = new HashMap<>();
	private final static String Membervokey="Membervo";
	
	private RegisterHelper(){
		
	}
	  public static void setmembervo(MemberVO Membervo){
   	   registermap.put(Membervokey,Membervo);
      }
      public static MemberVO getMembervo(){
   	   return (MemberVO)registermap.get(Membervokey);
      }
	
}
