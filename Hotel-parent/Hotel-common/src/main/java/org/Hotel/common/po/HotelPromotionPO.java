package org.Hotel.common.po;

import java.util.Date;

public class HotelPromotionPO {

	private int id;
	
	private int type;
	
	private String hotelid;
	
    private double birthdaydiscount;
	
	private double multiorderdiscount;
	
	private double enterpricediscount;
	
	private double datediscount;
	
	private Date startdate;
	
	private Date enddate;
	
	public HotelPromotionPO() {
		super();
	}
	
	public HotelPromotionPO(int id, int type, String hotelid,double birthdaydiscount,double multiorderdiscount, double enterpricediscount,double datediscount,Date startdate,Date enddate) {
		super();
		
		this.id = id;
		
		this.type = type;
		
		this.hotelid = hotelid;
		
        this.birthdaydiscount = birthdaydiscount;
		
		this.multiorderdiscount = multiorderdiscount;
		
		this.enterpricediscount = enterpricediscount;
		
		this.datediscount = datediscount;
		
		this.startdate = startdate;
		
		this.enddate = enddate;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public void setType(int type) {
		
		this.type = type;
	}
	
	public String getHotelid() {
		// TODO Auto-generated method stub
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		
		this.hotelid = hotelid;
	}
	
public double getBirthdaydiscount() {
		
		return birthdaydiscount;
	}
	
	public void setBirthdaydiscount(double birthdaydiscount) {
		
		this.birthdaydiscount = birthdaydiscount;
	}
	
    public double getMultiorderdiscount() {
		
		return multiorderdiscount;
	}
	
	public void setMultiorderdiscount(double multiorderdiscount) {
		
		this.multiorderdiscount = multiorderdiscount;
	}
	
    public double getEnterpricediscount() {
		
		return enterpricediscount;
	}
	
	public void setEnterpricediscount(double enterpricediscount) {
		
		this.enterpricediscount = enterpricediscount;
	}
	
	public double getDatediscount() {
			
		return datediscount;
	}
		
	public void setDatediscount(double datediscount) {
			
		this.datediscount = datediscount;
	}
	
	public Date getStartdate() {
		
		return startdate;
	}
	
	public void setStartdate(Date startdate) {
		
		this.startdate = startdate;
	}
	
    public Date getEnddate() {
		
		return enddate;
	}
	
	public void setEnddate(Date enddate) {
		
		this.enddate = enddate;
	}
}
