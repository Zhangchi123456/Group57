package org.Hotel.common.po;

public class HotelPO {

	private int id;
	
	private String circle;
	
	private double price;
	
	private int star;
	
	private int grade;
	
	private String roomtype;
	
	private int roomid;
	
	private int roomnum;
	
	private String intime;//入住时间
	
	private String outtime;//离开时间
	
	private String lasttime;//最近一次退房时间 
	
	public HotelPO() {
		super();
	}
	
	public HotelPO(int id, String circle, double price, int star, int grade, String roomtype,int roomid, int roomnum, String intime, String outtime, String lasttime){
		super();
		 
		this.id = id;				 
		this.circle = circle;				 
		this.price = price;				 
		this.star = star;			 
		this.grade = grade;				 
		this.roomtype = roomtype;			 
		this.roomid = roomid;				
		this.roomnum = roomnum;	
		this.intime = intime;				 
		this.outtime = outtime;				 
		this.lasttime = lasttime;
		
	}
	
	public int getId() {
		
		return id;
	}

    public void setId(int id) {
		
		this.id = id;
	}
    
	public String getCircle() {
		
		return circle;
	}

	public void setCircle(String circle) {
		
		this.circle = circle;
	}
	
	public double getPrice() {
		
		return price;
	}

	public void setPrice(double price) {
		
		this.price = price;
	}
	
	public int getStar() {
		
		return star;
	}

	public void setStar(int star) {
		
		this.star = star;
	}
	
	public double getGrade() {
		
		return grade;
	}
	
	public void setGrade(int grade) {
		
		this.grade = grade;
	}

	public String getRoomtype() {
		
		return roomtype;
	}
	
	public void setRoomtype(String roomtype) {
		
		this.roomtype = roomtype;
	}

	public int getRoomid() {
		
		return roomid;
	}
	
	public void setRoomid(int roomid) {
		
		this.roomid = roomid;
	}
	
	public int getRoomnum() {
		
		return roomnum;
	}
	
	public void setRoomnum(int roomnum) {
		
		this.roomnum = roomnum;
	}
	
	public String getIntime() {
		
		return intime;
	}

	public void setIntime(String intime){
		
		this.intime = intime;
	}

	public String getOuttime() {
		
		return outtime;
	}
	
	public void setOuttime(String outtime) {
		
		this.outtime = outtime;
	}
	
	public String getLasttime() {
		
		return lasttime;
	}
	
	public void setLasttime(String lasttime) {
		
		this.lasttime = lasttime;
	}
}
