package vo;

import java.util.Date;

public class HotelPromotionVO {
	
	private int hotel_id;
	private String name;
	private double birthday_discount;
	private double enterprice_discount;
	private double multiorder_discount;
	private double date_discount;
	private Date start_date;
	private Date end_date;
	
	public HotelPromotionVO(int hotel_id,String name,double birthday_discount,double enterprice_discount,
			double multiorder_discount, double date_discount,Date start_date,Date end_date){
		this.hotel_id = hotel_id;
		this.name = name;
		this.birthday_discount = birthday_discount;
		this.enterprice_discount = enterprice_discount;
		this.multiorder_discount = multiorder_discount;
		this.date_discount = date_discount;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public int getHotelID(){
		return hotel_id;
	}
	
	public String getName(){
		return name;
	}

	public double getBirthdayDiscount() {
		return birthday_discount;
	}
	
	public double getEnterpriceDiscount(){
		return enterprice_discount;
	}
	
	public double getMultiorderDiscount(){
		return multiorder_discount;
	}
	
	public double getDateDiscount(){
		return date_discount;
	}
	
	public Date getStartDate(){
		return start_date;
	}
	
	public Date getEndDate(){
		return end_date;
	}

}
