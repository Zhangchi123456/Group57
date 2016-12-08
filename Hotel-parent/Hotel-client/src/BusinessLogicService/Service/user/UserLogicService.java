package BusinessLogicService.Service.user;

import main.java.org.Hotel.client.util.UserType;

public interface UserLogicService {
	//if a user has login
	public boolean hasLogin(String name);
	//if password is right
	public boolean isFound(String name,String password);
	
	public UserType findUser(String name,String password);
	
	public void addCurrentUser(String name);
}
