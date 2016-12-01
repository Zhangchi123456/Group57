package org.Hotel.server.datahelp.impl;

import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.HotelDataHelper;
import org.Hotel.server.datahelp.MemberDataHelper;
import org.Hotel.server.datahelp.OrderDataHelper;
import org.Hotel.server.datahelp.PromotionDataHelper;
import org.Hotel.server.datahelp.UserDataHelper;

public class DataFactoryImpl implements DataFactory {

	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper hotelDao=new HotelDataMysqlHelper();
		return hotelDao;
	}

	public MemberDataHelper getMemberDataHelper() {
		MemberDataHelper memberDao=new MemberDataMysqlHelper();
		return memberDao;
	}

	public UserDataHelper getUserDataHelper() {
		UserDataHelper userDao=new UserDataMysqlHelper();
		return userDao;
	}

	public OrderDataHelper getOrderDataHelper() {
		OrderDataHelper orderDao=new OrderDataMysqlHelper();
		return orderDao;
	}

	public PromotionDataHelper getPromotionDataHelper() {
		PromotionDataHelper promotionDao=new PromotionDataMysqlHelper();
		return promotionDao;
	}
	

}
