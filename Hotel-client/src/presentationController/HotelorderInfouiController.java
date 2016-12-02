package presentationController;

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

public class HotelorderInfouiController implements Initializable{

	
	@FXML
	private TextField INtimetx,OutTimetx;//入住时间，离开时间
	
	@FXML
	private Label OrderUser;//订单持有者
	
	@FXML
	private ChoiceBox Statetx;//更改订单状态
     
	
	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_orderui();
		
	}
	@FXML
	private void RefrashClicked(ActionEvent event){
		
	}
	@FXML
    private void CheckClicked(ActionEvent event){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
