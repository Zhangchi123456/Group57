package org.Hotel.server.datahelp;

/*
 * @author jerry
 */
public interface DataFactory {
	public HotelDataHelper getHotelDataHelper();
	
	public MemberDataHelper getMemberDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public OrderDataHelper getOrderDataHelper();
	
	public PromotionDataHelper getPromotionDataHelper();
	
	
	
}
