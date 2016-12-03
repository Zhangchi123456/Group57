package vo;

import java.time.LocalDate;
import java.util.Date;

public class MemberVO {
    private int memberid;
    private int membercreditvalue;
    private String membername;
    private String memberlevel;
    private LocalDate memberbirthday;
    private String memberproperty;
    private String password;
    
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
    
    //测试用方法
    public void setname(String Membername){
    	this.membername=Membername;
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
