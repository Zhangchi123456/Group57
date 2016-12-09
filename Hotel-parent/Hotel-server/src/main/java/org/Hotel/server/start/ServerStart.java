package org.Hotel.server.start;

import org.Hotel.server.rmi.RemoteHelper;

import java.rmi.RemoteException;

import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebStaffPO;
import org.Hotel.server.dataImpl.MemberDataImpl;
import org.Hotel.server.dataImpl.UserDataImpl;
import org.Hotel.server.rmi.*;

public class ServerStart {
	
	public static void main(String[] args){
		
//		UserDataImpl a;
//		try {
//			a = new UserDataImpl();
//			WebManagerPO po=a.findByWebManager("Administer1");
//			System.out.println(po.getPassword());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
		localHelper.init();
		
	}

}
