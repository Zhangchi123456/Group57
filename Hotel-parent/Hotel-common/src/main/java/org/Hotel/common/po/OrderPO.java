package org.Hotel.common.po;

public class OrderPO {

	private int id;
	
	private String name;
	
	private String hotelid;
	
	private String intime;
	
	private String state;
	
	private String outtime;
	
	private String lasttime;
	
	private double price;
	
	private String dischargetime;
	
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
	public OrderPO(int id, String name, String hotelid, String intime, String outtime, String state, double price, String lasttime, String dischargetime,int peoplenum, boolean havekids, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String comment) {
		super();
		
		this.id = id;
		
		this.name = name;
		
		this.hotelid = hotelid;
		
		this.intime = intime;
		
		this.outtime = outtime;
		
		this.state = state;
		
		this.price = price;
		
		this.lasttime = lasttime;
		
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
	 * @return the lasttime
	 */
	public String getLasttime() {
		return lasttime;
	}
	/**
	 * @param lasttime the lasttime to set
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	/**
	 * @return the dischargetime
	 */
	public String getDischargetime() {
		return dischargetime;
	}
	/**
	 * @param dischargetime the dischargetime to set
	 */
	public void setDischargetime(String dischargetime) {
		this.dischargetime = dischargetime;
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
	
	public String getIntime() {
		
		return intime;
	}

	public void setIntime(String intime) {
		
		this.intime = intime;
	}
	
    public String getOuttime() {
		
		return outtime;
	}
    
    public void setOuttime(String outtime) {
		
		this.outtime = outtime;
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
