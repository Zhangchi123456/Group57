package vo;

import java.util.Date;

import org.Hotel.common.po.HotelPromotionPO;

public class HotelPromotionVO {
	
	private String hotel_name;
	private String name;
	private double birthday_discount;
	private double enterprice_discount;
	private double multiorder_discount;
	private double date_discount;
	private Date start_date;
	private Date end_date;
	
	public HotelPromotionVO(String hotel_name,String name,double birthday_discount,double enterprice_discount,
			double multiorder_discount, double date_discount,Date start_date,Date end_date){
		this.hotel_name = hotel_name;
		this.name = name;
		this.birthday_discount = birthday_discount;
		this.enterprice_discount = enterprice_discount;
		this.multiorder_discount = multiorder_discount;
		this.date_discount = date_discount;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public HotelPromotionVO() {
		// TODO Auto-generated constructor stub
	}

	public void setByPO(HotelPromotionPO po){
		this.hotel_name = po.getHotelid();
		this.name = po.getType();
		this.birthday_discount = po.getBirthdaydiscount();
		this.enterprice_discount = po.getEnterpricediscount();
		this.multiorder_discount = po.getMultiorderdiscount();
		this.date_discount = po.getDatediscount();
		this.start_date = po.getStartdate();
		this.end_date = po.getEnddate();
	}
	
	public HotelPromotionPO toPO(){
		HotelPromotionPO po = new HotelPromotionPO();
		po.setHotelid(hotel_name);
		po.setType(name);
		po.setBirthdaydiscount(birthday_discount);
		po.setEnterpricediscount(enterprice_discount);
		po.setMultiorderdiscount(multiorder_discount);
		po.setDatediscount(date_discount);
		po.setStartdate(start_date);
		po.setEnddate(end_date);
		po.setId(hotel_name, name);
		return po;
	}
	
	public String getHotelName(){
		return hotel_name;
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
