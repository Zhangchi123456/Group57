package presentationController;

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
	private Label hotelName,Province,City,Block,Star,introduction;//酒店名称，酒店所在省份，酒店所在城市，酒店所在商圈，酒店星级，酒店基础设施
    //界面的跳转
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
