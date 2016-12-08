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
		
		
		RemoteHelper.init();
		
	}

}
