package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HotelupdateuiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML 
	private DatePicker OutTimetx;
	
	@FXML
	private TextField roomNumtx,INtimetx,orderNumtx;
	
	@FXML
	private Label Update,roomNum,INtime,OutTime,orderNum;
     
	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	@FXML
	private void SureClicked(ActionEvent event){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
