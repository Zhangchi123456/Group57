package org.Hotel.server.data.datahelp.impl;

import org.Hotel.server.data.datahelp.DataFactory;
import org.Hotel.server.data.datahelp.HotelDataHelper;
import org.Hotel.server.data.datahelp.MemberDataHelper;
import org.Hotel.server.data.datahelp.OrderDataHelper;
import org.Hotel.server.data.datahelp.PromotionDataHelper;
import org.Hotel.server.data.datahelp.UserDataHelper;

public class DataFactoryImpl implements DataFactory {

	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper hotelDao=new HotelDataMysqlHelper();
		return hotelDao;
	}

	public MemberDataHelper getMemberDataHelper() {
		MemberDataHelper memberDao=new MemberDataMysqlHelper();
		return memberDao;
	}

	public UserDataHelper getUserUserDataHelper() {
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
