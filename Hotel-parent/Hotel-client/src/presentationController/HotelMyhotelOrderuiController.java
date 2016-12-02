package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HotelMyhotelOrderuiController implements Initializable{
	@FXML
	private Button refresh,back;
	
	@FXML
	private TableView table;
	
	@FXML
	private TableColumn hotelName,OrderTime,State;
	
	@FXML
	private Label Myhotel;
     
	@FXML
	private void backButtonClicked(ActionEvent event){
		
	}
	@FXML
	private void refreshButtonClicked(ActionEvent event){
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
