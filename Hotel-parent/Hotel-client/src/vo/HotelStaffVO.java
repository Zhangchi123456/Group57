package vo;

public class HotelStaffVO {
	private String name;
	private String password;
	private String hotelname;
	
	public HotelStaffVO(String name,String password,String hotelname){
		this.name=name;
		this.password=password;
		this.hotelname=hotelname;
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
