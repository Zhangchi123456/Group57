package presentation.presentationController;

import main.java.org.Hotel.client.presentation.controller.user.*;
import main.java.org.Hotel.client.presentation.view.user.*;
import main.java.org.Hotel.client.util.UserType;

import java.net.URL;

import java.util.ResourceBundle;

import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.userui.AlertBox;
import vo.LogVO;


public class LoginController implements Initializable{
    
	@FXML
	private TextField UserId;
	@FXML
	private PasswordField PassWord;
	@FXML
	private void RegisterClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Registerui();
	}
	@FXML
	private void SureClicked(ActionEvent event)throws Exception{
	
		if(UserId.getText().toString().equals("")){
				AlertBox alt = new AlertBox();
				alt.display("用户名为空");
		}
		else if(PassWord.getText().toString().equals("")){
			AlertBox alt = new AlertBox();
			alt.display("密码为空");
		}
		
		else	{
			String LogId=UserId.getText().toString();
			String Logpassword=PassWord.getText().toString();
			LogVO logvo=new LogVO(LogId,Logpassword);
			LoginHelper.setLogVO(logvo);
			/*===================================================
			 * author Jerry
			 */
			LoginControllerService lcs=new LoginControllerImp();
			//precondition
			if(!lcs.isFound(LogId, Logpassword)){
				AlertBox alt = new AlertBox();
				alt.display("用户名或者密码错误");
			}else if(!lcs.haveLogin(LogId, Logpassword)){
				AlertBox alt = new AlertBox();
				alt.display("用户名或者密码错误");
			}//find user
			else if(isMember(lcs.findUser(LogId, Logpassword))){
				UiswitchHelper.getApplication().goto_Usermainui();
				//post condition
				lcs.addCurrentUserList(name);
				lcs.setLocalUser(name);
			}
			else if(isHotelStaff(lcs.findUser(LogId, Logpassword))){
				UiswitchHelper.getApplication().goto_HotelMainui();
				//post condition
				lcs.addCurrentUserList(name);
				lcs.setLocalUser(name);
			}
			else if(isWebManager(lcs.findUser(LogId, Logpassword))){
				UiswitchHelper.getApplication().goto_UserWebManagementui();
				//post condition
				lcs.addCurrentUserList(name);
				lcs.setLocalUser(name);
			}
			else if(isWebStaff(lcs.findUser(LogId, Logpassword))){
				UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
				//post condition
				lcs.addCurrentUserList(name);
				lcs.setLocalUser(name);
			}
			else {
				AlertBox alt = new AlertBox();
				alt.display("用户名或者密码错误");
			}
				
//			if(UserId.getText().trim().substring(0, 1).equals("1"))
//		    UiswitchHelper.getApplication().goto_Usermainui();
//		    if(UserId.getText().trim().substring(0, 1).equals("2"))
//			UiswitchHelper.getApplication().goto_HotelMainui();
//			if(UserId.getText().trim().substring(0, 1).equals("3"))
//			UiswitchHelper.getApplication().goto_UserWebManagementui();
//		    if(UserId.getText().trim().substring(0, 1).equals("4"))
//			UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
		    LogVO a=new LogVO(UserId.getText(),PassWord.getText());
		}
	}
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isMember(UserType ut){
		return ut.equals(UserType.Member);
	}
	private boolean isHotelStaff(UserType ut){
		return ut.equals(UserType.hotelStaff);
	}
	private boolean isWebStaff(UserType ut){
		return ut.equals(UserType.webStaff);
	}
	private boolean isWebManager(UserType ut){
		return ut.equals(UserType.webManager);
	}
}
