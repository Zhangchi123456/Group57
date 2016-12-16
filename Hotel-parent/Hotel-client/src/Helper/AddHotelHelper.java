package Helper;

import java.util.HashMap;
import java.util.Map;

import vo.LogVO;

/**
 * @author Jerry
 *help to pass name of hotel to hotel staff
 */
public class AddHotelHelper { 
	private static String name=null;
	public static void setName(String theName){
		name=theName;
	}
	public static String getName(){
		return name;
	}
//	private final static Map<String,Object> logmap = new HashMap<>();
//	private final static String logkey = "lpgvo";	
//	
//	private AddHotelHelper(){}
//	
//	public static void setName(String name){
//		logmap.put(logkey, name);
//	}
//	public static String getName(){
//		
//		return (String)logmap.get(logkey);
//	}
	
}
