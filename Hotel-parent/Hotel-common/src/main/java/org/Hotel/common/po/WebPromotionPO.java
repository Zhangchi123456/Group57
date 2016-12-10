package org.Hotel.common.po;

import java.io.Serializable;
import java.util.Date;

public class WebPromotionPO implements Serializable{
	
	private double datediscount;
	
	private Date startdate;
	
	private Date enddate;
	
	private int id;
	
	public WebPromotionPO() {
		super();
	}
	
	public WebPromotionPO(double datediscount,Date startdate,Date enddate,int id) {
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
	
	 public int getID() {
			
			return id;
		}
		
	private void setID(int id) {
			
		this.id = id;
	}
	
}
