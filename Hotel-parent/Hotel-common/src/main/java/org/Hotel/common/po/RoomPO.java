package org.Hotel.common.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoomPO implements Serializable{

	private String hotelid;
	
	private String roomtype;
	
	private int roomid;
	
	private String roomstate;
	
	private String starttime;
	
	private String leavetime;
	
	private int orderid;
	
	private int id;
	
	public RoomPO() {
	}
	
	public RoomPO(String roomtype, int roomid, String hotelid, String roomstate, String starttime, String leavetime, int orderid, int id) {
		super();
		
		this.roomtype = roomtype;
		
		this.roomid = roomid;
		
		this.hotelid = hotelid;
		
		this.roomstate = roomstate;
		
		this.starttime = starttime;
		
		this.leavetime = leavetime;
		
		this.orderid = orderid;
		
		this.id = id;
	}
	/**
	 * @return the roomid
	 */
	public int getRoomid() {
		return roomid;
	}

	/**
	 * @param roomid the roomid to set
	 */
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	/**
	 * @return the roomstate
	 */
	public String getRoomstate() {
		return roomstate;
	}

	/**
	 * @param roomstate the roomstate to set
	 */
	public void setRoomstate(String roomstate) {
		this.roomstate = roomstate;
	}

	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the leavetime
	 */
	public String getLeavetime() {
		return leavetime;
	}

	/**
	 * @param leavetime the leavetime to set
	 */
	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	/**
	 * @return the orderid
	 */
	public int getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
