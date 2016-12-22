package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;
import vo.HotelStaffVO;
import vo.HotelVO;
import vo.RoomVO;
import vo.WebStaffVO;

public class UserWebAddHotelController implements Initializable{
	UserLogicService userblservice =new UserLogicServiceImpl();
	
	@FXML
	private Label user;
	@FXML
	private TextField HotelnameText,AddressText;
	@FXML
	private ChoiceBox<Integer> StarChoicebox;
	@FXML
	private ChoiceBox<String> BusinessChoicebox,CityChoicebox;
	@FXML
	private TextArea introduction;
	
	
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		if(HotelnameText.getText().isEmpty()||
				AddressText.getText().isEmpty()||
				introduction.getText().isEmpty()){
			AlertBox alt = new AlertBox();
			alt.display("还有未填项！");
			return;
		}//end if

		String name=HotelnameText.getText().trim();
		String intro=introduction.getText().trim();
		String address=AddressText.getText().trim();
		
    	//pre condition
    	if(name.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("酒店名不得为空！");
    	}else if(address.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("地址不得为空！");
    	}
    	else{
    		
    		
    		int star=StarChoicebox.getValue();
    		String city=CityChoicebox.getValue();
    		String circle=BusinessChoicebox.getValue();
    		HotelVO vo=new HotelVO(name, circle, 
    				star, 5.0,
    				intro,
    				city,address,
    				0,0,
    				0,0,
    				0,0,
    				0,0,
    				0,0,
    				0,0);
    		
    		if(userblservice.findHotel(name)){
    			AlertBox alt = new AlertBox();
    			alt.display("酒店名已存在！");
    		}else{
    			userblservice.addHotel(vo);
    			//post condition: add room of hotel and hotel promotion
    		
    			//add hotel promotion
    			HotelPromotionVO birthdayvo=new HotelPromotionVO(name,"生日折扣",1.0,0.0,
    					0.0, 0.0,null,null,0);
    			HotelPromotionVO mutivo=new HotelPromotionVO(name,"多间折扣",0.0,0.0,
    					1, 0.0,null,null,0);
    			HotelPromotionVO enterprisevo=new HotelPromotionVO(name,"企业折扣",0.0,1.0,
    					0.0, 0.0,null,null,0);
    			userblservice.addHotelStrategy(enterprisevo);
    			userblservice.addHotelStrategy(birthdayvo);
    			userblservice.addHotelStrategy(mutivo);
    			
    			AlertBox alt = new AlertBox();
    			alt.display("酒店已保存！");
    		}//end addHotel
    	}//end if	
	}//end method
	@FXML
	private void AddHotelStuffButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_AddHotelStuffui();
	}//end add hotel staff
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
		user.setText(LoginHelper.getLogVO().getUsername());
		//inital star choicebox
		StarChoicebox.getItems().add(1);
		StarChoicebox.getItems().add(2);
		StarChoicebox.getItems().add(3);
		StarChoicebox.getItems().add(4);
		StarChoicebox.getItems().add(5);
		
		StarChoicebox.setValue(4);
		//initialize city box
		ArrayList<String> citylist=userblservice.showCity();
		if(citylist!=null){
			for(String city:citylist){
				CityChoicebox.getItems().add(city);
				CityChoicebox.setValue(city);
			}
		}
		CityChoicebox.setOnAction(e->setCircle());
		String city=CityChoicebox.getValue();
		if(city.length()!=0){
			ArrayList<String> list=userblservice.showCircle(city);
			for(String circle:list){
				BusinessChoicebox.getItems().add(circle);
				BusinessChoicebox.setValue(circle);
			}
		}
	}//end initialize
	
	void setCircle(){
		BusinessChoicebox.getItems().clear();
		String city=CityChoicebox.getValue();
		if(city.length()!=0){
			ArrayList<String> list=userblservice.showCircle(city);
			for(String circle:list){
				BusinessChoicebox.getItems().add(circle);
				BusinessChoicebox.setValue(circle);
			}
		}
	}

}
