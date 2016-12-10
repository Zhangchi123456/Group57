package org.Hotel.common.po;

import java.io.Serializable;
import java.util.Date;

public class WebPromotionPO implements Serializable{
	
	private double datediscount;
	
	private String startdate;
	
	private String enddate;
	
	private int id;
	
	public WebPromotionPO() {
		super();
	}
	
	public WebPromotionPO(double datediscount,String startdate,String enddate,int id) {
		super();
	
		this.datediscount = datediscount;
		
		this.startdate = startdate;
		
		this.enddate = enddate;
		
		this.id=id;
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
	
	 public int getID() {
			
			return id;
		}
		
	private void setID(int id) {
			
		this.id = id;
	}
	
}
