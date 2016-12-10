package vo;

import org.Hotel.common.po.WebPromotionPO;

public class WebPromotionVO {
	
	private double discount;
    private String start_date;
    private String end_date;
    private int id;
	
    public WebPromotionVO(double discount, String start_date, String end_date, int id) {
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
    
	public String getStartDate() {
		return start_date;
	}
	
	public String getEndDate() {
		return end_date;
	}
	
	public double getDateDiscount() {
		return discount;
	}
	
	public int getID(){
		return id;
	}
      
}
