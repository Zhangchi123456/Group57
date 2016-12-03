package org.Hotel.common.po;

public class OrderPO {

	private int id;
	
	private String name;
	
	private String orderinfo;
	
	private String hotelid;
	
	private String intime;
	
	private int state;
	
	private String outtime;
	
	private double price;
	
	public OrderPO() {
		super();
	}
	public OrderPO(int id, String name, String orderinfo, String hotelid, String intime, String outtime, int state, double price) {
		super();
		
		this.id = id;
		this.name = name;
		this.orderinfo = orderinfo;
		this.hotelid = hotelid;
		this.intime = intime;
		this.outtime = outtime;
		this.state = state;
		this.price = price;
		
	}
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

	public String getOrderinfo() {
		
		return orderinfo;
	}
	
	public void setOrderinfo(String orderinfo) {
		
		this.orderinfo = orderinfo;
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
    
    public int getState() {
    	
    	return state;
    }
    
    public void setState(int state) {
    	
    	this.state = state;
    }
    
    public double getPrice() {
    	
    	return price;
    }
    
    public void setPrice(double price) {
    	
    	this.price = price;
    }
    
}
