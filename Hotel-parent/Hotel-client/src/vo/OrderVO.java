package vo;

import java.util.Date;

import org.Hotel.common.po.OrderPO;

public class OrderVO {
    private String id;
	
	private String name;
		
	private String hotelid;
	
	private Date starttime;
	
	private String state;
	
	private Date leavetime;
	
	private Date lasttime;
	
	private String price;
	
	private Date dischargetime;
	
	private int peoplenum;
	
	private boolean havekids;
	
	private int singleRoom;
	
	private int standardRoom;
	
	private int familyRoom;
	
	private int suiteRoom;
	
	private String comment;
	
	private double grade;
	

	public OrderVO(String id, String name, String child, String hotelid, Date intime, Date outtime, String state, String price, Date lasttime, Date dischargetime,int peoplenum, boolean havekids, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String comment, double grade) {
			
		this.id = id;
		
		this.name = name;
			
		this.hotelid = hotelid;
		
		this.starttime = intime;
		
		this.leavetime = outtime;
		
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
		
		this.grade = grade;
	}
	
	//po转vo
	public void SetbyOrderPO(OrderPO po){
           this.id = String.valueOf(po.getId());
		
		this.name = po.getName();
		this.hotelid = po.getHotelid();
		
		this.starttime = po.getStarttime();
		
		this.leavetime = po.getLeavetime();
		
		this.state = po.getState();
		
		this.price = String.valueOf( po.getPrice());
		
		this.lasttime = po.getLasttime();
		
		this.dischargetime = po.getDischargetime();
		
		this.peoplenum = po.getPeoplenum();
		
		this.havekids = po.isHavekids();
		
		this.singleRoom = po.getSingleRoom();
		
		this.standardRoom = po.getStandardRoom();
		
		this.familyRoom = po.getFamilyRoom();
		
		this.suiteRoom = po.getSuiteRoom();
		
		this.comment = po.getComment();
		
		this.grade = po.getGrade();
	}
	
	//vo转po
	public OrderPO toOrderPO(OrderVO vo){
		OrderPO po = new OrderPO();
		po.setId(Integer.parseInt(id));
		po.setComment(comment);
		po.setDischargetime(dischargetime);
		po.setFamilyRoom(familyRoom);
		po.setHavekids(havekids);
		po.setHotelid(hotelid);
		po.setStarttime(starttime);
		po.setLasttime(lasttime);
		po.setName(name);
		po.setLeavetime(leavetime);
		po.setPeoplenum(peoplenum);
		po.setPrice(Integer.parseInt(price));
		po.setSingleRoom(singleRoom);
		po.setStandardRoom(standardRoom);
		po.setState(state);
		po.setSuiteRoom(suiteRoom);
		po.setGrade(grade);
		return po;
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
	 * @return the child
	 */
	
	/**
	 * @param child the child to set
	 */

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
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(String id) {
		
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

	public String getState() {
    	
    	return state;
    }
   
    
    public void setState(String state) {
    	
    	this.state = state;
    }
    
    public String getPrice() {
    	
    	return price;
    }
    
    public void setPrice(String price) {
    	
    	this.price = price;
    }
    
}