package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import org.Hotel.common.dataService.LogDataService;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.LogPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

public class LogDataImpl extends UnicastRemoteObject implements LogDataService,Serializable{
	

	private Map<Integer, LogPO> map;
	
	private LogDataHelper logDataHelper;
	
	private DataFactory dataFactory;
	
	private static LogDataImpl logDataImpl;
	
	public static LogDataImpl getInstance() throws RemoteException{
		if(logDataImpl == null){
			logDataImpl = new LogDataImpl();
		}
		return logDataImpl;
	}
	
	public LogDataImpl()throws RemoteException{
		if(map == null){
			dataFactory = new DataFactoryImpl();
			logDataHelper = dataFactory.getLogDataHelper();
			map = logDataHelper.getHotelData();
		}
	}

	public boolean insert(LogPO po) throws RemoteException{
	
		return false;
	}
	
	public boolean delete(LogPO po) throws RemoteException{
	
		return false;
	}
	
}
