package org.Hotel.common.po;


public class RoomPO {

	private String hotelid;
	
	private String roomtype;
	
	private int roomid;
	
	private double price;
	
	public RoomPO() {
		super();
	}
	
	public RoomPO(String roomtype, int roomid, double price, String hotelid) {
		super();
		
		this.roomtype = roomtype;
		
		this.roomid = roomid;
		
		this.price = price;
		
		this.hotelid =hotelid;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return roomid;
	}
	
	public void setId(int roomid) {
		
		this.roomid = roomid;
	}

	public String getRoomtype() {
		// TODO Auto-generated method stub
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		
		this.roomtype = roomtype;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public void setPrice(double price) {
		
		this.price = price;
	}
	
	public String getHotelid() {
		// TODO Auto-generated method stub
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		
		this.hotelid = hotelid;
	}

}
