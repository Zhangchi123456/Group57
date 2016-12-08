package org.Hotel.common.po;

import java.io.Serializable;
import java.util.Date;

public class OrderPO implements Serializable{

	private int id;
	
	private String name;
	
	private String hotelid;
	
	private Date starttime;
	
	private String state;
	
	private Date leavetime;
	
	private double price;
	
	private Date dischargetime;
	
	private Date lasttime;
	
	private int peoplenum;
	
	private boolean havekids;
	
	private int singleRoom;
	
	private int standardRoom;
	
	private int familyRoom;
	
	private int suiteRoom;
	
	private String comment;
	
	private double grade;
	
	public OrderPO() {
		super();
	}
	public OrderPO(int id, String name, String hotelid, Date starttime, Date leavetime, String state, double price, Date dischargetime, Date lasttime, int peoplenum, boolean havekids, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String comment,double grade) {
		super();
		
		this.id = id;
		
		this.name = name;
		
		this.hotelid = hotelid;
		
		this.starttime = starttime;
		
		this.leavetime = leavetime;
		
		this.state = state;
		
		this.price = price;
		
		this.dischargetime = dischargetime;
		
		this.lasttime = lasttime;
		
		this.peoplenum = peoplenum;
		
		this.havekids = havekids;
		
		this.singleRoom = singleRoom;
		
		this.standardRoom = standardRoom;
		
		this.familyRoom = familyRoom;
		
		this.suiteRoom = suiteRoom;
		
		this.comment = comment;
		
		this.grade = grade;
	}
	/**
	 * @return the grade
	 */
	public double getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(double grade) {
		this.grade = grade;
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
	 * @return the starttime
	 */
	public Date getStarttime() {
		return starttime;
	}
	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	/**
	 * @return the leavetime
	 */
	public Date getLeavetime() {
		return leavetime;
	}
	/**
	 * @param leavetime the leavetime to set
	 */
	public void setLeavetime(Date leavetime) {
		this.leavetime = leavetime;
	}
	/**
	 * @return the lasttime
	 */
	public Date getLasttime() {
		return lasttime;
	}
	/**
	 * @param lasttime the lasttime to set
	 */
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
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
