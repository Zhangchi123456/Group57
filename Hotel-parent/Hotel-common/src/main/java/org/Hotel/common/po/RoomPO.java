package org.Hotel.common.po;


public class RoomPO {

	private String hotelid;
	
	private int roomtype;
	
	private int roomnum;
	
	private int roomid;
	
	private double price;
	
	public RoomPO() {
		super();
	}
	
	public RoomPO(int roomtype, int roomnum, int roomid, double price, String hotelid) {
		super();
		
		this.roomtype = roomtype;
		
		this.roomnum = roomnum;
		
		this.roomid = roomid;
		
		this.price = price;
		
		this.hotelid =hotelid;
	}
	public int getRoomnum() {
		// TODO Auto-generated method stub
		return roomnum;
	}
	
	public void setRoomnum(int roomnum) {
		
		this.roomnum = roomnum;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return roomid;
	}
	
	public void setId(int roomid) {
		
		this.roomid = roomid;
	}

	public int getRoomtype() {
		// TODO Auto-generated method stub
		return roomtype;
	}

	public void setRoomtype(int roomtype) {
		
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
