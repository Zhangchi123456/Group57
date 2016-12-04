package vo;

public class CircleVO {
	
	private double discount;
	
	private String city;
	
	private String name;
	
	public CircleVO(double discount, String city, String name) {
		
		this.discount = discount;
		this.city = city;
		this.name = name;
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


}
