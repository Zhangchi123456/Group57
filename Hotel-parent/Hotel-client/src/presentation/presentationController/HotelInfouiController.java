package presentation.presentationController;


import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;

public class HotelInfouiController implements Initializable{
	 private String hotelstar,hoteldescription,hoteladdress;
	@FXML
	private Button ReturnButton;//返回按钮
	@FXML
	private Label HotelName;//酒店名称
	@FXML
	private TextArea HotelDescription;//酒店介绍
	@FXML
	private TextArea HotelAddress;//酒店地址
	@FXML
	private ChoiceBox HotelStar;//酒店星级
	//界面跳转
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}
	@FXML
	private void SaveClicked(ActionEvent event){
		if(!Allisfilled()){
			AlertBox alt = new AlertBox();
			alt.display("信息填写不全");
		}else{
			hotelstar=HotelStar.getValue().toString();
			hoteldescription=HotelDescription.getText();
			hoteladdress=HotelAddress.getText();
		}
	}
	
	private boolean Allisfilled(){
		if(HotelDescription.getText().isEmpty()||HotelAddress.getText().isEmpty()||HotelStar.getValue().toString().equals(null)){
			return false;
		}
		return true;
	}
	//初始化界面
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
