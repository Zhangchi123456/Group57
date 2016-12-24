package BusinessLogicService.Service;

import util.UserType;

public interface LoginLogicService {
	
	public UserType findUser(String name,String password);
	//operate current user
	public void addCurrentUser(String name);	
	public boolean isCurrentUser(String name);
	
}
