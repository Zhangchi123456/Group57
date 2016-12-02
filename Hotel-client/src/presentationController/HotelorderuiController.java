package presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HotelorderuiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TableView table;
	
	@FXML
	private TableColumn OrderNum,OrderInfo,State;
	
	@FXML
	private Label OrderList;
     
	@FXML
	private void backButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("mainui.fxml"));
		
	}
	@FXML
	private void okButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("orderInfoui.fxml"));
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
