package vo;

import org.Hotel.common.po.HotelStaffPO;

import security.DES;

public class HotelStaffVO {
	private String name;
	private String password;
	private String hotelname;
	
	public HotelStaffVO(String name,String password,String hotelname){
		this.name=name;
		this.password=password;
		this.hotelname=hotelname;
	}
     public HotelStaffVO() {
		// TODO Auto-generated constructor stub
	}
	public void setbypo(HotelStaffPO po){
    	 this.name = po.getName();
    	 try {
			this.password=DES.decrypt(po.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 this.hotelname=po.getHotelName();
     }
     
    public HotelStaffPO  settopo(HotelStaffVO vo){
    	HotelStaffPO po = new HotelStaffPO();
    	po.setHotelName(vo.getHotelname());
    	po.setName(vo.getName());
    	try {
			po.setPassword(DES.encrypt(vo.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return po;
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
