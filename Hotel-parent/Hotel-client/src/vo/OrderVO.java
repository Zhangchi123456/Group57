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
    
  

	public int getOrderid(){
    	return this.orderid;
    }
    public double getOrderprice(){
    	return this.getOrderprice();
    }
    public String getRoomname(){
    	return null;
    }
}
