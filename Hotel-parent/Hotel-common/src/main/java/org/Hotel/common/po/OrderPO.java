package org.Hotel.common.po;

import java.util.Date;

public class OrderPO {

	private int id;
	
	private String name;
	
	private String hotelid;
	
	private Date intime;
	
	private String state;
	
	private Date expectleavetime;
	
	private Date realleavetime;
	
	private double price;
	
	private Date dischargetime;
	
	private int peoplenum;
	
	private boolean havekids;
	
	private int singleRoom;
	
	private int standardRoom;
	
	private int familyRoom;
	
	private int suiteRoom;
	
	private String comment;
	
	public OrderPO() {
		super();
	}
	public OrderPO(int id, String name, String hotelid, Date intime, Date expectleavetime, String state, double price, Date realleavetime, Date dischargetime,int peoplenum, boolean havekids, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String comment) {
		super();
		
		this.id = id;
		
		this.name = name;
		
		this.hotelid = hotelid;
		
		this.intime = intime;
		
		this.expectleavetime = expectleavetime;
		
		this.state = state;
		
		this.price = price;
		
		this.realleavetime = realleavetime;
		
		this.dischargetime = dischargetime;
		
		this.peoplenum = peoplenum;
		
		this.havekids = havekids;
		
		this.singleRoom = singleRoom;
		
		this.standardRoom = standardRoom;
		
		this.familyRoom = familyRoom;
		
		this.suiteRoom = suiteRoom;
		
		this.comment = comment;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}


	/**
	 * @return the peoplenum
	 */
	public int getPeoplenum() {
		return peoplenum;
	}
	/**
	 * @param peoplenum the peoplenum to set
	 */
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}
	/**
	 * @return the havekids
	 */
	public boolean isHavekids() {
		return havekids;
	}
	/**
	 * @param havekids the havekids to set
	 */
	public void setHavekids(boolean havekids) {
		this.havekids = havekids;
	}
	/**
	 * @return the singleRoom
	 */
	public int getSingleRoom() {
		return singleRoom;
	}
	/**
	 * @param singleRoom the singleRoom to set
	 */
	public void setSingleRoom(int singleRoom) {
		this.singleRoom = singleRoom;
	}
	/**
	 * @return the standardRoom
	 */
	public int getStandardRoom() {
		return standardRoom;
	}
	/**
	 * @param standardRoom the standardRoom to set
	 */
	public void setStandardRoom(int standardRoom) {
		this.standardRoom = standardRoom;
	}
	/**
	 * @return the familyRoom
	 */
	public int getFamilyRoom() {
		return familyRoom;
	}
	/**
	 * @param familyRoom the familyRoom to set
	 */
	public void setFamilyRoom(int familyRoom) {
		this.familyRoom = familyRoom;
	}
	/**
	 * @return the suiteRoom
	 */
	public int getSuiteRoom() {
		return suiteRoom;
	}
	/**
	 * @param suiteRoom the suiteRoom to set
	 */
	public void setSuiteRoom(int suiteRoom) {
		this.suiteRoom = suiteRoom;
	}
	/**
	 * @param state the state to set
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}

	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getHotelid() {
		
		return hotelid;
	}
	
	public void setHotelid(String hotelid) {
		
		this.hotelid = hotelid;
	}  
    /**
	 * @return the intime
	 */
	public Date getIntime() {
		return intime;
	}
	/**
	 * @param intime the intime to set
	 */
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	/**
	 * @return the expectleavetime
	 */
	public Date getExpectleavetime() {
		return expectleavetime;
	}
	/**
	 * @param expectleavetime the expectleavetime to set
	 */
	public void setExpectleavetime(Date expectleavetime) {
		this.expectleavetime = expectleavetime;
	}
	/**
	 * @return the realleavetime
	 */
	public Date getRealleavetime() {
		return realleavetime;
	}
	/**
	 * @param realleavetime the realleavetime to set
	 */
	public void setRealleavetime(Date realleavetime) {
		this.realleavetime = realleavetime;
	}
	/**
	 * @return the dischargetime
	 */
	public Date getDischargetime() {
		return dischargetime;
	}
	/**
	 * @param dischargetime the dischargetime to set
	 */
	public void setDischargetime(Date dischargetime) {
		this.dischargetime = dischargetime;
	}
	public String getState() {
    	
    	return state;
    }
   
    
    public void setState(String state) {
    	
    	this.state = state;
    }
    
    public double getPrice() {
    	
    	return price;
    }
    
    public void setPrice(double price) {
    	
    	this.price = price;
    }
    
}
