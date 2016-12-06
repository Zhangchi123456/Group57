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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HotelInfoBrowseuiController implements Initializable{
	@FXML
	private Button formOrder,Back,myOrder;	//跳转的按钮
	@FXML
	private Label hotelName,Star,introduction,address,SingleLabel,StandardLabel,FamilyLabel,SuiteLabel,benefit;
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelListui();
	}
	@FXML
	private void MyorderButtoncClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderListUi();
	}
	@FXML
	private void CreatorderButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderinputUi();
	}
	 //初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
