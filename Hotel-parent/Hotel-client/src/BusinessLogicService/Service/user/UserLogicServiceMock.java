package BusinessLogicService.Service.user;

import main.java.org.Hotel.client.util.UserType;

public class UserLogicServiceMock implements UserLogicService {

	@Override
	public boolean hasLogin(String name) {
		switch(name){
			case "孔夫子":
				return true;
			case "鲁迅":
				return false;
			default:
				return false;
		}
//		return false;
	}

	@Override
	public boolean isFound(String name, String password) {
		if(name.equals("孔夫子")&&password.equals("123456"))
			return true;
		else if(name.equals("鲁迅")&&password.equals("789456"))
			return true;
		else if(name.equals("狐狸")&&password.equals("789456"))
			return true;
		else if(name.equals("香瓜")&&password.equals("789456"))
			return true;
		else if(name.equals("芽儿")&&password.equals("789456"))
			return true;
		return false;
	}
	
	//if found failed return null
	@Override
	public UserType findUser(String name, String password) {
		if(isFound(name,password))
		{
			switch (name){
			case "鲁迅":
				return UserType.Member;
			case "狐狸":
				return UserType.hotelStaff;
			case "香瓜":
				return UserType.webManager;
			case "芽儿":
				return UserType.webStaff;
			}
		}
		return null;
	}

	@Override
	public void addCurrentUser(String name) {
		// TODO Auto-generated method stub
		
	}

}
