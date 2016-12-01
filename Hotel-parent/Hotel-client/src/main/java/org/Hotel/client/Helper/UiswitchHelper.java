package org.Hotel.client.Helper;

import java.util.HashMap;
import java.util.Map;

import org.Hotel.client.application.Main;

public class UiswitchHelper {
	private final static Map<String,Object> parameneters = new HashMap<>();
	private final static String applicationKey = "application";	
	
	private UiswitchHelper(){
		
	}
	public static void setApplication(Main application){
		parameneters.put(applicationKey, application);
	}
	
	public static Main getApplication(){
		return (Main)parameneters.get(applicationKey);
	}
}
