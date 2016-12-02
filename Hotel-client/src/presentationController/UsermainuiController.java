package presentationController;

import java.net.URL;

import java.util.ResourceBundle;
import Helper.InituiHelper;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import vo.MemberVO;

public class UsermainuiController implements Initializable{
	@FXML
	private Label membernamelabel;
	//显示会员名的label
	@FXML
	private ChoiceBox CityChoicebox,RoomtypeChoicebox,RoomnumChoicebox,HotelstarChoicebox,HotelgradeChoicebox,HotelpriceChoicebox,BusinessChoicebox;
	  //对应：             城市选择，     房间类型选择          房间数量选择          酒店星级选择           酒店评分选择       酒店价格选择          商圈选择， 
	@FXML
	private DatePicker CheckindateDatepicker,CheckoutdateDatepicker;
    //                 入住日期                离开日期
	
	
	
	
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