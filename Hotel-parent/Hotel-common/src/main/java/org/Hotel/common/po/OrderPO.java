package org.Hotel.common.po;

public class OrderPO {

	private int id;
	
	private String name;
	
	private String orderinfo;
	
	private int hotelid;
	
	private String intime;
	
	private int state;
	
	private String outtime;
	
	private double price;
	
	public OrderPO() {
		super();
	}
	public OrderPO(int id, String name, String orderinfo, int hotelid, String intime, String outtime, int state, double price) {
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
	
	public int getHotelid() {
		
		return hotelid;
	}
	
	public void setHotelid() {
		
		this.hotelid = hotelid;
	}

}
