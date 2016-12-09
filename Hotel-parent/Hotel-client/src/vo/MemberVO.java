package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.Hotel.common.po.MemberPO;

public class MemberVO {
    private int memberid;
    private int membercreditvalue;
    private String membername;
    private String memberlevel;
    private LocalDate memberbirthday;
    private String memberproperty;
    private String password;
    public Date Birthday;
    
    //手机号码暂未确定是否用到。
    private String phonenumber; 
    
    public MemberVO(int id,int creditvalue,String name,String level
   		 ,String property){
   	 this.memberid=id;
   	 this.membercreditvalue=creditvalue;
   	 //this.memberbirthday=birthday;
   	 this.membername=name;
   	 this.memberlevel=level;
   	 this.memberproperty=property;
    }
    
    //测试用方法,实际不能有setid
    public void setid(int num){
    	this.memberid=num;
    }
    //该方法用于在注册界面构造membervo
    public void setbyString(String memberProperty,String memberName,String Password,LocalDate birthday){
    	this.memberbirthday=birthday;
    	this.membername=memberName;
    	this.memberproperty=memberProperty;
    	this.password=Password;
    }
    //该方法用于在个人信息界面更新信息
    public void updateInfo(String name,LocalDate Date,String phonenumber){
    	this.memberbirthday=Date;
    	this.membername=name;
    	this.phonenumber=phonenumber;
    }
    
    public MemberPO topo() throws ParseException{
    	MemberPO po=new MemberPO();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date Birthday=formatter.parse(memberbirthday.toString());
    	po.setBirthday(Birthday);
    	po.setPassword(password);
    	po.setCredit(membercreditvalue);
    	po.setId(memberid);
    	po.setLevel(Integer.parseInt(memberlevel));
    	po.setName(membername);
    	po.setConnection(phonenumber);
    	return po;
    }
    public void setbypo(MemberPO po){
    	 Birthday=po.getBirthday();
    	
    	this.membercreditvalue=po.getCredit();
    	this.memberid=po.getId();
    	this.memberlevel=String.valueOf(po.getLevel());
    	this.membername=po.getName();
    	this.phonenumber=po.getConnection();
    	if(po.isEnterprise()){
    		this.memberproperty="企业会员";
    	}else{
    		this.memberproperty="个人会员";
    	}
    	
    	
    }
    public int getid(){
   	 return this.memberid;
    }
    
    public int getcredit(){
   	 return this.membercreditvalue;
    }
    
    public  String getname(){
   	 return this.membername;
    }
    public String getlevel(){
   	 return this.memberlevel;
    }
    
    public LocalDate getbirthday(){
   	 return this.memberbirthday;
    }
    
    public String getproperty(){
   	 return this.memberproperty;
    }
    public String getphonenumber(){
    	return this.phonenumber;
    }
}
