package vo;

import org.Hotel.common.po.HotelPromotionPO;

public class HotelPromotionVO {
	
	private String hotel_name;
	private String name;
	private double birthday_discount;
	private double enterprice_discount;
	private double multiorder_discount;
	private double date_discount;
	private String start_date;
	private String end_date;
	private int id;
	
	public HotelPromotionVO(String hotel_name,String name,double birthday_discount,double enterprice_discount,
			double multiorder_discount, double date_discount,String start_date,String end_date,int id){
		this.hotel_name = hotel_name;
		this.name = name;
		this.birthday_discount = birthday_discount;
		this.enterprice_discount = enterprice_discount;
		this.multiorder_discount = multiorder_discount;
		this.date_discount = date_discount;
		this.start_date = start_date;
		this.end_date = end_date;
		this.id = id;
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
		this.id = po.getId();
	}
	
	public HotelPromotionPO toPO(){
		HotelPromotionPO po = new HotelPromotionPO(name, hotel_name,birthday_discount,
				multiorder_discount, enterprice_discount,date_discount,start_date,end_date,id);
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
	
	public String getStartDate(){
		return start_date;
	}
	
	public String getEndDate(){
		return end_date;
	}
	
	public int getId(){
		return id;
	}

}
