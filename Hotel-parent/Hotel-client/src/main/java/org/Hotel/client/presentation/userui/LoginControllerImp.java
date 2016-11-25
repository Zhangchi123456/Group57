package org.Hotel.client.presentation.userui;

public class LoginControllerImp implements LoginController{

	@Override
	public boolean isFound(String id, String password) {
		if(id.equals("1000")&&password.equals("abcd"))
			return true;
		return false;
	}
	

}
