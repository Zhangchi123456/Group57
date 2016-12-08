package org.Hotel.server.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.Hotel.server.dataImpl.ConnectionDataImpl;
import org.Hotel.server.dataImpl.HotelDataImpl;
import org.Hotel.server.dataImpl.MemberDataImpl;
import org.Hotel.server.dataImpl.OrderDataImpl;
import org.Hotel.server.dataImpl.PromotionDataImpl;
import org.Hotel.server.dataImpl.UserDataImpl;
import org.Hotel.common.config.XMLReader;
import org.Hotel.common.dataService.ConnectionDataService;
import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.OrderDataService;
import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.dataService.UserDataService;;

public class localHelper {
	
	public static void init(){

		
		
		try {
			
			//创建实现类
			ConnectionDataService ConnectionDataImpl = new ConnectionDataImpl();
		
			MemberDataService MemberDataImpl=new MemberDataImpl();
//			OrderDataService OrderDataImpl=new OrderDataImpl();
			UserDataService UserDataImpl=new UserDataImpl();
			PromotionDataService PromotionDataImpl=new PromotionDataImpl();
	
			HotelDataService HotelDataImpl=new HotelDataImpl();
			
			
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
		
		}

		
	}


}
