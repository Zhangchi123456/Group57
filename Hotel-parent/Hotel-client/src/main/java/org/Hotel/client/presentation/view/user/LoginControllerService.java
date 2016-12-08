package main.java.org.Hotel.client.presentation.view.user;

import main.java.org.Hotel.client.util.UserType;

public interface LoginControllerService {
	//as login precondition 
	public boolean haveLogin(String name,String password);
	//as login precondition 
	//if there is corresponding user in data
	public boolean isFound(String name,String password);
	//
	public UserType findUser(String name,String password);
	//in case duplicated log in
	public void addCurrentUserList(String name);

}
