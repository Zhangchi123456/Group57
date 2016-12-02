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
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HotelInfouiController implements Initializable{
	@FXML
	private Button ReturnButton;//返回按钮
	@FXML
	private TextField HotelName;//酒店名称
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
	//出初始化界面
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
