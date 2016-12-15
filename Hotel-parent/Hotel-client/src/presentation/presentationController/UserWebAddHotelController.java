package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelStaffVO;
import vo.WebStaffVO;

public class UserWebAddHotelController implements Initializable{
	UserLogicService userblservice =new UserLogicServiceImpl();
	@FXML
	private TextField HotelnameText,AddressText,
	single1,single2,double1,double2,triple1,triple2,square1,square2;
	@FXML
	private ChoiceBox CityChoicebox,BusinessChoicebox,StarChoicebox;
	@FXML
	private TextArea introduction;
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		String name=HotelnameText.getText();
		String intro=introduction.getText();
		String address=AddressText.getText();
		//room info
		String sinN=single1.getText();
		String sinP=single2.getText();
		String douN=double1.getText();
		String douP=double2.getText();
		String triN=triple1.getText();
		String triP=triple2.getText();
		String squN=square1.getText();
		String squP=square2.getText();
		
		int singlenum=Integer.parseInt(sinN);
		double singleprice=Double.parseDouble(sinP);
		int doublenum=Integer.parseInt(douN);
		double doubleprice=Double.parseDouble(douP);
		int triplenum=Integer.parseInt(triN);
		double tripleprice=Double.parseDouble(triP);
		int squarenum=Integer.parseInt(squN);
		double squareprice=Double.parseDouble(squP);
    	//pre condition
    	if(name.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("酒店名不得为空！");
    	}else if(address.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("地址不得为空！");
    	}//if any text for room are empty,
    	else if(sinN.length()==0||sinP.length()==0||
    			douN.length()==0||douP.length()==0||
    			triN.length()==0||triP.length()==0||
    			squN.length()==0||squP.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("房间数，房间价格不得为空！");
    	}//if any room number and room price <0
    	else if(singlenum<0||singleprice<0||
    			doublenum<0||doubleprice<0||
    			triplenum<0||tripleprice<0||
    			squarenum<0||squareprice<0){
    		AlertBox alt = new AlertBox();
			alt.display("房间价格，房间数不得小于零！");
    	}
    	else{
//    		HotelVO vo=new HotelVO(name, String circle, 
//    				int star, double grade,
//    				String introduction,
//    				String city,String address,
//    				int singleRoom,int leftSingleRoom,
//    				int standardRoom,int leftStandardRoom,
//    				int familyRoom,int leftFamilyRoom,
//    				int suiteRoom,int leftSuiteRoom,
//    				double singleRoomPrice,double standardRoomPrice,
//    				double familyRoomPrice,double suiteRoomPrice);
//    		staffSelected.get(0).setPassword(newPass);
//    		userblservice.saveWebStaff(new WebStaffVO(vo.getName(),vo.getPassword()));
//    		AlertBox alt = new AlertBox();
//			alt.display("密码已保存");
//			password.clear();
//			ensurePassword.clear();
    	}
		
	}
	@FXML
	private void AddHotelStuffButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_AddHotelStuffui();
	}
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void MemberMangementClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	@FXML
	private void Webmanange(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	
	@FXML
	private void AddDescription(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddDescriptionui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
