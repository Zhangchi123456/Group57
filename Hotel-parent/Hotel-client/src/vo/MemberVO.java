package vo;

import java.util.Date;

public class MemberVO {
    private int memberid;
    private int membercreditvalue;
    private String membername;
    private String memberlevel;
    private Date memberbirthday;
    private String memberproperty;
    
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
    public int getid(){
   	 return this.memberid;
    }
    
    public int getcredit(){
   	 return this.membercreditvalue;
    }
    
    public String getname(){
   	 return this.membername;
    }
    public String getlevel(){
   	 return this.memberlevel;
    }
    
    public Date getbirthday(){
   	 return this.memberbirthday;
    }
    
    public String getproperty(){
   	 return this.memberproperty;
    }
    public String getphonenumber(){
    	return this.phonenumber;
    }
}
