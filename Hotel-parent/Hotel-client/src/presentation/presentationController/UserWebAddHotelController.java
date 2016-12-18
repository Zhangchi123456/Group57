package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.AddHotelHelper;
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
	private TextField HotelnameText,AddressText,single1,single2,double1,double2,triple1,triple2,square1,square2;
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
				single1.getText().isEmpty()||single2.getText().isEmpty()||
				double1.getText().isEmpty()||double2.getText().isEmpty()||
				triple1.getText().isEmpty()||triple2.getText().isEmpty()||
				square1.getText().isEmpty()||square2.getText().isEmpty()||
				introduction.getText().isEmpty()){
			AlertBox alt = new AlertBox();
			alt.display("还有未填项！");
			return;
		}//end if

		String name=HotelnameText.getText().trim();
		String intro=introduction.getText().trim();
		String address=AddressText.getText().trim();
		//room info
		String sinN=single1.getText().trim();
		String sinP=single2.getText().trim();
		String douN=double1.getText().trim();
		String douP=double2.getText().trim();
		String triN=triple1.getText().trim();
		String triP=triple2.getText().trim();
		String squN=square1.getText().trim();
		String squP=square2.getText().trim();
		
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
    		
    		
    		int star=StarChoicebox.getValue();
    		String city=CityChoicebox.getValue();
    		String circle=BusinessChoicebox.getValue();
    		HotelVO vo=new HotelVO(name, circle, 
    				star, 5.0,
    				intro,
    				city,address,
    				singlenum,singlenum,
    				doublenum,doublenum,
    				triplenum,triplenum,
    				squarenum,squarenum,
    				singleprice,doubleprice,
    				tripleprice,squareprice);
    		
    		if(userblservice.findHotel(name)){
    			AlertBox alt = new AlertBox();
    			alt.display("酒店名已存在！");
    		}else{
    			userblservice.addHotel(vo);
    			//post condition: add room of hotel and hotel promotion
    			//single room
    			for(int i=0;i<singlenum;i++){
    				RoomVO roomvo=new RoomVO("单人房",0, name, "可用", null, null, 0);
    				userblservice.addRoom(roomvo);
    			}
    			//standard room
    			for(int i=0;i<doublenum;i++){
    				RoomVO roomvo=new RoomVO("标准间",0, name, "可用", null, null, 0);
    				userblservice.addRoom(roomvo);
    			}
    			//family room
    			for(int i=0;i<triplenum;i++){
    				RoomVO roomvo=new RoomVO("家庭房",0, name, "可用", null, null, 0);
    				userblservice.addRoom(roomvo);
    			}
    			//suite room
    			for(int i=0;i<squarenum;i++){
    				RoomVO roomvo=new RoomVO("套间",0, name, "可用", null, null, 0);
    				userblservice.addRoom(roomvo);
    			}//end add room to hotel   	
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
		try{
			if(HotelnameText.getText()==null){
				AlertBox alt = new AlertBox();
				alt.display("还有未填项！");
				return;
			}
			String name=HotelnameText.getText();
			if(!userblservice.findHotel(name)){
				AlertBox alt = new AlertBox();
				alt.display("酒店还未保存！");
				return;
			}
		}catch(Exception e){
			AlertBox alt = new AlertBox();
			alt.display("还有未填项！");
			return;
		}
		AddHotelHelper.setName(HotelnameText.getText().trim());
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
