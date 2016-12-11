package BusinessLogicService.Service;

import util.UserType;

public interface LoginLogicService {
	
	//if a user has login
	public boolean hasLogin(String name);

	
	public UserType findUser(String name,String password);
	
	public void addCurrentUser(String name);
}
