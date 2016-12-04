package vo;

import java.util.Date;

public class WebPromotionVO {
	
	private double discount;
    private Date start_date;
    private Date end_date;
	
    public WebPromotionVO(double discount, Date start_date, Date end_date) {
		this.discount = discount;
		this.start_date = start_date;
		this.end_date = end_date;
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
