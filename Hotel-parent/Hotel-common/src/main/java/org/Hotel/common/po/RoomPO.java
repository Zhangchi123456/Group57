package org.Hotel.common.po;

public class RoomPO {

	private int roomtype;
	
	private int roomnum;
	
	private int roomid;
	
	public RoomPO() {
		super();
	}
	
	public RoomPO(int roomtype, int roomnum, int roomid) {
		super();
		
		this.roomtype = roomtype;
		
		this.roomnum = roomnum;
		
		this.roomid = roomid;
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


}
