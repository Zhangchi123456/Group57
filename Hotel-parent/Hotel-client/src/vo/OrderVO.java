package vo;

import java.util.Date;

public class OrderVO {
	public int orderid;
    public double  orderprice;

	public String orderstate;
    public String orderEvaluation;
    public String membername;  
    public String hotelname;
    public String roomname;
    public String BeginDate;
    public String EndDate;
    public String UserNUm;
    public String TelePhone;
    public String Child;
    public String RoomNum;
    
    
    public OrderVO(int Orderid,double Orderprice,String Orderstate,String Hotelname,String Roomname,String BeginDate,String EndDate,String Membername,
    		String UserNum,String TelePhone,String Child,String RoomNum	){
    	this.orderid=Orderid;
    	this.BeginDate=BeginDate;
    	this.EndDate=EndDate;
    	this.hotelname=Hotelname;
    	this.membername=Membername;
    	this.orderprice=Orderprice;
    	this.roomname=Roomname;
    	this.orderprice=Orderprice;
    	this.UserNUm = UserNum;
    	this.TelePhone = TelePhone;
    	this.Child = Child;
    	this.RoomNum = RoomNum;
    }
    
  
    public String getOrderstate() {
		return orderstate;
	}



	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}



	public String getOrderEvaluation() {
		return orderEvaluation;
	}



	public void setOrderEvaluation(String orderEvaluation) {
		this.orderEvaluation = orderEvaluation;
	}



	public String getMembername() {
		return membername;
	}



	public void setMembername(String membername) {
		this.membername = membername;
	}



	public String getHotelname() {
		return hotelname;
	}



	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}



	public String getBeginDate() {
		return BeginDate;
	}



	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}



	public String getEndDate() {
		return EndDate;
	}



	public void setEndDate(String endDate) {
		EndDate = endDate;
	}



	public String getUserNUm() {
		return UserNUm;
	}



	public void setUserNUm(String userNUm) {
		UserNUm = userNUm;
	}



	public String getTelePhone() {
		return TelePhone;
	}



	public void setTelePhone(String telePhone) {
		TelePhone = telePhone;
	}



	public String getChild() {
		return Child;
	}



	public void setChild(String child) {
		Child = child;
	}



	public String getRoomNum() {
		return RoomNum;
	}



	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}



	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}



	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}



	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
}
