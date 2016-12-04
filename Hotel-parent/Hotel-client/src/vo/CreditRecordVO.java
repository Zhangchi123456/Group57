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
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Date date=sdf.parse(time);
    	cred.setTime(date);
    	
    	return cred;
    }
}
