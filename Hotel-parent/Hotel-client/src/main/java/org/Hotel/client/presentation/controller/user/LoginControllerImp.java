package main.java.org.Hotel.client.presentation.controller.user;

import BusinessLogicService.Service.user.UserLogicService;
import BusinessLogicService.Service.user.UserLogicServiceMock;
import main.java.org.Hotel.client.presentation.view.user.LoginControllerService;
import main.java.org.Hotel.client.util.UserType;

public class LoginControllerImp implements LoginControllerService {
	UserLogicService userblservice=new UserLogicServiceMock();
	
	//if a user have login
	@Override
	public boolean haveLogin(String name, String password){
		return userblservice.hasLogin(name);
	}
	
	//if name and password is right
	@Override
	public boolean isFound(String name, String password) {
		return userblservice.isFound(name, password);
	}

	//return null if can't not find user
	@Override
	public UserType findUser(String name, String password) {
		return userblservice.findUser(name, password);
	}

	@Override
	public void addCurrentUserList(String name) {
		// TODO Auto-generated method stub
		
	}

}
