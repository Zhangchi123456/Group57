package presentation.presentationController;

import main.java.org.Hotel.client.presentation.controller.user.*;
import main.java.org.Hotel.client.presentation.view.user.*;
import main.java.org.Hotel.client.util.UserType;

import java.net.URL;

import java.util.ResourceBundle;

import BusinessLogicService.Service.LoginLogicService;
import BusinessLogicService.Service.user.UserLogicService;
import BusinessLogicService.impl.LoginLogicServiceImpl;
import BusinessLogicService.impl.userbl.UserLogicServiceImp;
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
//			LogVO logvo=new LogVO(LogId,Logpassword);
//			LoginHelper.setLogVO(logvo);
			/*===================================================
			 * author Jerry
			 */
			LoginLogicService lcs=new LoginLogicServiceImpl();
			//precondition
			if(lcs.findUser(LogId, Logpassword)==null){
			
				AlertBox alt = new AlertBox();
				alt.display("用户名或者密码错误");
				
			
			}//find user
			else {
				UserType usertype =lcs.findUser(LogId, Logpassword);
				if(UserType.Member.equals(usertype)){
					UiswitchHelper.getApplication().goto_Usermainui();
					LogVO vo=new LogVO(UserId.getText(),PassWord.getText());//store name
			     	LoginHelper.setLogVO(vo);
				}
				else if(UserType.hotelStaff.equals(usertype)){
					UiswitchHelper.getApplication().goto_HotelMainui();
					LogVO vo=new LogVO(UserId.getText(),PassWord.getText());//store name
			     	LoginHelper.setLogVO(vo);
				}
				else if(UserType.webManager.equals(usertype)){
					UiswitchHelper.getApplication().goto_UserWebManagementui();
					LogVO vo=new LogVO(UserId.getText(),PassWord.getText());//store name
			     	LoginHelper.setLogVO(vo);
				}
				else if(UserType.webStaff.equals(usertype)){
					UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
					LogVO vo=new LogVO(UserId.getText(),PassWord.getText());//store name
			     	LoginHelper.setLogVO(vo);
				}
				
			}
		}
			
	}
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
