package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
    public String Birthday;
    
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
    public void setbyString(String memberProperty,String memberName,String Password,LocalDate birthday,String phonenumber){
    	this.memberbirthday=birthday;
    	this.membername=memberName;
    	this.memberproperty=memberProperty;
    	this.password=Password;
    	this.setPhonenumber(phonenumber);
    }
    //该方法用于在个人信息界面更新信息
    public void updateInfo(String name,LocalDate Date,String phonenumber,String Password){
    	this.password=Password;
    	this.memberbirthday=Date;
    	this.membername=name;
    	this.phonenumber=phonenumber;
    }
    
    public MemberPO topo() throws ParseException{
    	MemberPO po=new MemberPO();
    	if(memberbirthday!=null){
    	po.setBirthday(memberbirthday.toString());
    	
    	}
    	po.setPassword(password);
    	po.setCredit(membercreditvalue);
    	po.setId(memberid);
    	po.setLevel(1);
    	po.setName(membername);
    	po.setConnection(phonenumber);
    	switch(this.memberproperty){
    	case"个人会员":
    		po.setEnterprise(false);
    		break;
    	case"企业会员":
    		po.setEnterprise(true);
    		break;
    	}
    	return po;
    }
    public void setbypo(MemberPO po){
    	
    		this.Birthday=po.getBirthday();
    	if(po.getBirthday()!=null){
    		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    		 LocalDate date=LocalDate.parse(po.getBirthday(),dtf);
    		 this.memberbirthday=date;
    	}
    	this.membercreditvalue=po.getCredit();
    	this.memberid=po.getId();
    	this.memberlevel=String.valueOf(po.getLevel());
    	this.membername=po.getName();
    	this.phonenumber=po.getConnection();
    	this.password=po.getPassword();
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
    public String getBirthday(){
    	return this.Birthday;
    }

	/**
	 * @return the memberid
	 */
	public int getMemberid() {
		return memberid;
	}

	/**
	 * @param memberid the memberid to set
	 */
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	/**
	 * @return the membercreditvalue
	 */
	public int getMembercreditvalue() {
		return membercreditvalue;
	}

	/**
	 * @param membercreditvalue the membercreditvalue to set
	 */
	public void setMembercreditvalue(int membercreditvalue) {
		this.membercreditvalue = membercreditvalue;
	}

	/**
	 * @return the membername
	 */
	public String getMembername() {
		return membername;
	}

	/**
	 * @param membername the membername to set
	 */
	public void setMembername(String membername) {
		this.membername = membername;
	}

	/**
	 * @return the memberlevel
	 */
	public String getMemberlevel() {
		return memberlevel;
	}

	/**
	 * @param memberlevel the memberlevel to set
	 */
	public void setMemberlevel(String memberlevel) {
		this.memberlevel = memberlevel;
	}

	/**
	 * @return the memberbirthday
	 */
	public LocalDate getMemberbirthday() {
		return memberbirthday;
	}

	/**
	 * @param memberbirthday the memberbirthday to set
	 */
	public void setMemberbirthday(LocalDate memberbirthday) {
		this.memberbirthday = memberbirthday;
	}

	/**
	 * @return the memberproperty
	 */
	public String getMemberproperty() {
		return memberproperty;
	}

	/**
	 * @param memberproperty the memberproperty to set
	 */
	public void setMemberproperty(String memberproperty) {
		this.memberproperty = memberproperty;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	
	public void setbirthday(LocalDate birthday){
		memberbirthday=birthday;
	}
}
