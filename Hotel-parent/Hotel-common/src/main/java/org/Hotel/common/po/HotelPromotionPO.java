package org.Hotel.common.po;

public class HotelPromotionPO {

	private int id;
	
	private int type;
	
	public HotelPromotionPO() {
		super();
	}
	
	public HotelPromotionPO(int id, int type) {
		super();
		
		this.id = id;
		this.type = type;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public void setType(int type) {
		
		this.type = type;
	}
}
