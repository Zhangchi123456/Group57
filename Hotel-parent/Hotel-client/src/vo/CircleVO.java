package vo;

import org.Hotel.common.po.CirclePO;

public class CircleVO {
	
	private double discount;
	
	private String city;
	
	private String name;
	
	public CircleVO(double discount, String city, String name) {
		
		this.discount = discount;
		this.city = city;
		this.name = name;
	}
	
	public void setByPO(CirclePO po){
		this.discount = po.getDiscount();
		this.city = po.getCity();
		this.name = po.getName();
	}
	
	public CirclePO toPO(){
		CirclePO po = new CirclePO();
		po.setDiscount(discount);
		po.setCity(city);
		po.setName(name);
		return po;
	}

	public double getDiscount() {
		return discount;
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

}



