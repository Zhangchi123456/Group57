package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class UsercreditrecorduiController implements Initializable{
  @FXML
  private TableView CreditrecordTable;
  
  
  
  @FXML
  private void ReturnButtonClicked(ActionEvent event){
	  UiswitchHelper.getApplication().goto_Usermainui();
  }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
