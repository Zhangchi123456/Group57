package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelStaffVO;
import vo.WebStaffVO;

public class AddHotelStuffController implements Initializable{
		UserLogicService userblservice =new UserLogicServiceImpl();
	 	@FXML
	    private TextField nameText,hotelName;
	    
	    @FXML
	    private PasswordField password,ensurePassword;
	    
	    @FXML
	    private void ReturnButtonClicked(ActionEvent event){
	    	UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	    }
	    
	    @FXML
	    private void AddButtonClicked(ActionEvent event){
	    	String name=nameText.getText().trim();
	    	String newPass=password.getText().trim();
	    	String ensurePass=ensurePassword.getText().trim();
	    	String hotelname=hotelName.getText().trim();
	    	//pre condition
	    	if(name.length()==0){
	    		AlertBox alt = new AlertBox();
				alt.display("姓名为空");
	    	}else if(hotelname.length()==0){
	    		AlertBox alt = new AlertBox();
				alt.display("酒店名为空");
	    	}else if(newPass.length()==0){
	    		AlertBox alt = new AlertBox();
				alt.display("密码为空");
	    	}else if(newPass.length()<6||newPass.length()>16){
	    		AlertBox alt = new AlertBox();
				alt.display("密码长度为6-16位");
	    	}else if(ensurePass.length()==0){
	    		AlertBox alt = new AlertBox();
				alt.display("确认密码为空");
	    	}else if(!ensurePass.equals(newPass)){
	    		AlertBox alt = new AlertBox();
				alt.display("确认密码与密码不同");
	    	}//find a duplicated name
	    	else if(userblservice.findWebStaffBYName(name)){
	    		AlertBox alt = new AlertBox();
				alt.display("姓名已存在");
	    	}else if(!userblservice.findHotel(hotelname)){
	    		AlertBox alt = new AlertBox();
				alt.display("酒店不存在");
	    	}else{
	    		//pre condition
	    		ArrayList<HotelStaffVO> HSList=userblservice.findHotelStaff();
	    		for(HotelStaffVO vo:HSList){
	    			if(vo.getHotelname().equals(hotelname)){
	    				AlertBox alt = new AlertBox();
	    				alt.display("酒店已存在工作人员");
	    				return;
	    				//end add button cliked
	    			}
	    		}
	    		HotelStaffVO vo =new HotelStaffVO(name,newPass,hotelname);
	    		userblservice.addHotelStaff(vo);
	    		//reminder
	    		AlertBox alt = new AlertBox();
				
				UiswitchHelper.getApplication().goto_UserWebAddHotelui();;
				alt.display("新增成功！");
	    	}
	    }
		@Override
		public void initialize(URL location, ResourceBundle resources) {
		}
}
