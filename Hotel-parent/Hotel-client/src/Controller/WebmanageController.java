package Controller;

import java.util.HashMap;
import java.util.Map;

import vo.MemberVO;

public class WebmanageController {
	private final static Map<String,Object> Webmanagemap = new HashMap<>();
	private final static String membervOkey="membervO";
	
	public static  void setmembervO(MemberVO membervO){
		Webmanagemap.put(membervOkey, membervO);
	}
	
	public static MemberVO getmembervO(){
		return (MemberVO)Webmanagemap.get(membervOkey);
	}
	
}
