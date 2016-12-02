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
    public Date date;
    
    public OrderVO(int Orderid,double Orderprice,String Orderstate,String Hotelname,String Roomname,Date dat,String Membername){
    	this.orderid=Orderid;
    	this.date=dat;
    	this.hotelname=Hotelname;
    	this.membername=Membername;
    	this.orderprice=Orderprice;
    	this.roomname=Roomname;
    	this.orderprice=Orderprice;
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
