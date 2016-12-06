package vo;

import java.util.Date;

import org.Hotel.common.po.WebPromotionPO;

public class WebPromotionVO {
	
	private double discount;
    private Date start_date;
    private Date end_date;
	
    public WebPromotionVO(double discount, Date start_date, Date end_date) {
		this.discount = discount;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
    public void setByPO(WebPromotionPO po){
    	this.discount = po.getDatediscount();
    	this.start_date = po.getStartdate();
    	this.end_date = po.getEnddate();
    }
    
    public WebPromotionPO toPO(){
    	WebPromotionPO po = new WebPromotionPO();
    	po.setDatediscount(discount);
    	po.setStartdate(start_date);
    	po.setEnddate(end_date);
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
      
}
