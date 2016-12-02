package vo;

public class LogVO {
      public String username ;
      public String password;
      
      public LogVO(String Username,String Password){
    	  this.username=Username;
    	  this.password=Password;
      }
      
      public String getUsername(){
    	  return username;
      }
      public String getPassword(){
    	  return password;
      }
}
