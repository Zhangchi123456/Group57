package org.Hotel.client.po;

import java.util.Date;

public class Memberpo {
     private int memberid;
     private int membercreditvalue;
     private String membername;
     private String memberlevel;
     private Date memberbirthday;
     private String memberproperty;
     
     //手机号码暂未确定是否用到。
     private long phonenumber;
     
     public Memberpo(int id,int creditvalue,Date birthday,String name,String level
    		 ,String property){
    	 this.memberid=id;
    	 this.membercreditvalue=creditvalue;
    	 this.memberbirthday=birthday;
    	 this.membername=name;
    	 this.memberlevel=level;
    	 this.memberproperty=property;
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
}
