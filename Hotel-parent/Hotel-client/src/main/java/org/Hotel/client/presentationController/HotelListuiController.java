package  org.Hotel.client.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import org.Hotel.client.Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

public class HotelListuiController implements Initializable{
	@FXML
	private ChoiceBox SortChoicebox;
	
	@FXML
	private CheckBox ReservationCheckbox;
	@FXML
	private TableView HotelTable;
	
	@FXML
	private Button ReturnButton;
	
    
    
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
        UiswitchHelper.getApplication().goto_Usermainui();
    }
    
    @FXML
    private void CheckButtonClicked(ActionEvent event){
        UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
