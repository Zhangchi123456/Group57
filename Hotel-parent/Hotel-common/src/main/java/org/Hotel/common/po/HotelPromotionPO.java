package org.Hotel.common.po;

import java.io.Serializable;
import java.util.Date;

public class HotelPromotionPO implements Serializable{

	private String type;
	
	private String hotelid;
	
    private double birthdaydiscount;
	
	private double multiorderdiscount;
	
	private double enterpricediscount;
	
	private double datediscount;
	
	private String startdate;
	
	private String enddate;
	
	private int id;
	
	public HotelPromotionPO() {
		super();
	}
	
	public HotelPromotionPO(String type, String hotelid,
			double birthdaydiscount,double multiorderdiscount, 
			double enterpricediscount,double datediscount,String startdate,String enddate,int id) {
		super();
		
		this.type = type;
		
		this.hotelid = hotelid;
		
        this.birthdaydiscount = birthdaydiscount;
		
		this.multiorderdiscount = multiorderdiscount;
		
		this.enterpricediscount = enterpricediscount;
		
		this.datediscount = datediscount;
		
		this.startdate = startdate;
		
		this.enddate = enddate;
		
		this.id=id;
	}
	
	public int getId(){
		
		return this.id;
	}
	
	private void setId(int id){
		this.id=id;
	}


	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public void setType(String type) {
		
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
	
	public String getStartdate() {
		
		return startdate;
	}
	
	public void setStartdate(String startdate) {
		
		this.startdate = startdate;
	}
	
    public String getEnddate() {
		
		return enddate;
	}
	
	public void setEnddate(String enddate) {
		
		this.enddate = enddate;
	}
}
