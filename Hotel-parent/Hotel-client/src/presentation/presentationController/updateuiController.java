package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class updateuiController implements Initializable{
    @FXML
    private Button ReturnButton;
    @FXML
    private TextField  RoomId,OrderId;
    @FXML
    private DatePicker Intime,OutTime;
    
    @FXML
    private void ReturnClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelMainui();
    }
    @FXML
    private void SureClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelMainui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
