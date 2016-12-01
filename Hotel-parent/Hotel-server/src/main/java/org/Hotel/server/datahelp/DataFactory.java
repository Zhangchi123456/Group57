package org.Hotel.server.data.datahelp;

/*
 * @author jerry
 */
public interface DataFactory {
	public HotelDataHelper getHotelDataHelper();
	
	public MemberDataHelper getMemberDataHelper();
	
	public UserDataHelper getUserUserDataHelper();
	
	public OrderDataHelper getOrderDataHelper();
	
	public PromotionDataHelper getPromotionDataHelper();
	
	
	
}
