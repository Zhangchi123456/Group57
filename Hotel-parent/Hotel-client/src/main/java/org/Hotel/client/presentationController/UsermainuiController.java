package org.Hotel.client.presentationController;

import java.net.URL;

import java.util.ResourceBundle;
import org.Hotel.client.Helper.InituiHelper;
import org.Hotel.client.Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import org.Hotel.client.vo.MemberVO;

public class UsermainuiController implements Initializable{
	@FXML
	private Label membernamelabel;
	
	@FXML
	private ChoiceBox ProvinceChoicebox,CityChoicebox,RoomtypeChoicebox,RoomnumChoicebox,HotelstarChoicebox,HotelgradeChoicebox,HotelpriceChoicebox;
	   
	@FXML
	private DatePicker CheckinDatepicker,CheckoutDatepicker;
     
	@FXML
	private Button MemberinformationButton,CreditrecordButton,MyorderButton,MycommentsButton;
	
	
	@FXML
	private void ProvinceChoiceClicked(ActionEvent event){
		
	}
	@FXML
	private void RoomtypeChoiceClicked(ActionEvent event){
		
		
	}
	@FXML
	private void MemberinformationButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Userinformationui();
	}
	
	@FXML
	private void CreditrecordButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Usercreditrecordui();
	}
	
	@FXML
	private void MyorderButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderListUi();
	}
	@FXML
	private void RhotelClicked(ActionEvent event) {
	  UiswitchHelper.getApplication().goto_reservationedhotelUi();
	}
	
	
	@FXML
	private void SearchButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelListui();
	}

	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MemberVO membervo=new MemberVO(1,100,"Trump","金会员","个人会员");
		InituiHelper.setMemberVO(membervo);
		membernamelabel.setText(InituiHelper.getMembername());
		
	}

}