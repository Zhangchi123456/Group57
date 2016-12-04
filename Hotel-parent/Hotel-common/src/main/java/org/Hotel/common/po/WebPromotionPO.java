package org.Hotel.common.po;

import java.util.Date;

public class WebPromotionPO {
	
	private double datediscount;
	
	private Date startdate;
	
	private Date enddate;
	
	public WebPromotionPO() {
		super();
	}
	
	public WebPromotionPO(double datediscount,Date startdate,Date enddate) {
		super();
	
		this.datediscount = datediscount;
		
		this.startdate = startdate;
		
		this.enddate = enddate;
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
