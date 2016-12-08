package org.Hotel.common.po;

import java.io.Serializable;

public class RoomPO implements Serializable{

	private String hotelid;
	
	private String roomtype;
	
	private int roomid;
	
	public RoomPO() {
		super();
	}
	
	public RoomPO(String roomtype, int roomid, String hotelid) {
		super();
		
		this.roomtype = roomtype;
		
		this.roomid = roomid;
		
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
	
	public String getHotelid() {
		// TODO Auto-generated method stub
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		
		this.hotelid = hotelid;
	}

}
