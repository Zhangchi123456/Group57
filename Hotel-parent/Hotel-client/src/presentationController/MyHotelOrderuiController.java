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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MyHotelOrderuiController implements Initializable{
	@FXML
	private Button ReturnButton;
	@FXML
	private TableView HotelTable;//酒店列表
	@FXML
	private TableColumn HotelName,OrderTime,OrderStation;//表中项目
	//监听方法
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Usermainui();
	}
	@FXML
	private void RefrashClicked(ActionEvent event){
	
	}
	//初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}