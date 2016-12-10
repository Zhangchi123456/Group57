package vo;

import java.util.Date;

import org.Hotel.common.po.WebPromotionPO;

public class WebPromotionVO {
	
	private double discount;
    private Date start_date;
    private Date end_date;
    private int id;
	
    public WebPromotionVO(double discount, Date start_date, Date end_date, int id) {
		this.discount = discount;
		this.start_date = start_date;
		this.end_date = end_date;
		this.id = id;
	}
	
    public WebPromotionVO() {
		// TODO Auto-generated constructor stub
	}

	public void setByPO(WebPromotionPO po){
    	this.discount = po.getDatediscount();
    	this.start_date = po.getStartdate();
    	this.end_date = po.getEnddate();
    	this.id = po.getID();
    }
    
    public WebPromotionPO toPO(){
    	WebPromotionPO po = new WebPromotionPO(discount,start_date,end_date,id);
    	return po;
    }
    
	public Object getStartDate() {
		return start_date;
	}
	
	public Object getEndDate() {
		return end_date;
	}
	
	public double getDateDiscount() {
		return discount;
	}
	
	public int getID(){
		return id;
	}
      
}
