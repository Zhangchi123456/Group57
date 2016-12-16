package Helper;

import java.util.HashMap;
import java.util.Map;

import BusinessLogicService.Service.LoginLogicService;
import BusinessLogicService.impl.LoginLogicServiceImpl;
import vo.LogVO;

public class LoginHelper {
	
	private final static Map<String,Object> logmap = new HashMap<>();
	private final static String logkey = "lpgvo";	
	
	private LoginHelper(){}
	
	public static void setLogVO(LogVO logvo){
		
		logmap.put(logkey, logvo);
	}
	public static LogVO getLogVO(){
		
		return (LogVO)logmap.get(logkey);
	}
}
