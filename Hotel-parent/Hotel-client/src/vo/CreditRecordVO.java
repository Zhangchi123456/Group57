package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.Hotel.common.po.CreditPO;

public class CreditRecordVO {
    public String action;
    public String orderid;
    public String time;
    public String creditchange;
    public String creditlast;
    
    public CreditRecordVO(){
    	
    }
    public void setbyCreditPO(CreditPO po){
    	this.action=po.getAction();
    	this.orderid=String.valueOf(po.getId());
    	this.time=po.getTime().toString();
    	this.creditchange=String.valueOf(po.getCreditchange());
    	this.creditlast=String.valueOf(po.getCredit());
    	
    }
    
    public CreditPO ToCreditpo() throws ParseException{
    	CreditPO cred=new CreditPO();
    	cred.setAction(action);
    	
    	cred.setCredit(Integer.parseInt(creditlast));
    	cred.setId(Integer.parseInt(orderid));
    	
    	cred.setTime(time);
    	
    	return cred;
    }
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the creditchange
	 */
	public String getCreditchange() {
		return creditchange;
	}
	/**
	 * @param creditchange the creditchange to set
	 */
	public void setCreditchange(String creditchange) {
		this.creditchange = creditchange;
	}
	/**
	 * @return the creditlast
	 */
	public String getCreditlast() {
		return creditlast;
	}
	/**
	 * @param creditlast the creditlast to set
	 */
	public void setCreditlast(String creditlast) {
		this.creditlast = creditlast;
	}
}
