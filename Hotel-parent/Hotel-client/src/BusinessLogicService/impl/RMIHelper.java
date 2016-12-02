package BusinessLogicService.impl;

import java.rmi.Naming;

import org.Hotel.common.config.XMLReader;

public class RMIHelper {
	
	public static final String IP = XMLReader.loadipconfig("src/resources/config.xml").getIP(); //Can be read from config file
    public static final int PORT=XMLReader.loadipconfig("src/resources/config.xml").getPORT();//端口号
    
    public static Object find(String serviceName){
    	if(IP==null){
    		System.out.println("error.Ip is not found!");
    	    System.exit(0);
    	}
    	 try {
             Object service = (Object) Naming.lookup("rmi://"+IP+":"+PORT+"/"+serviceName);
             return service;
         } catch (Exception e) {
        	//new Thread(new ReconnectedFrame()).start();
        	 try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
        	 return RMIHelper.find(serviceName);
         }
    }
    
    public static void init(){
    	System.setProperty("sun.rmi.transport.tcp.responseTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.tcp.readTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.connectionTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.proxy.connectTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.tcp.handshakeTimeout", "2000");
    	System.out.println("Connected!");
    }


}
