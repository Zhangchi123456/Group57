package vo;

import org.Hotel.common.po.HotelStaffPO;

public class HotelStaffVO {
	private String name;
	private String password;
	private String hotelname;
	
	public HotelStaffVO(String name,String password,String hotelname){
		this.name=name;
		this.password=password;
		this.hotelname=hotelname;
	}
     public void setbypo(HotelStaffPO po){
    	 this.name = po.getName();
    	 this.hotelname=po.getHotelName();
    	 this.password=po.getPassword();
     }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

}
