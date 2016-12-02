package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderlistuiController implements Initializable{
   @FXML
   private Button ReturnButton;
   @FXML
   private TableView OrderList;
   @FXML
   private TableColumn HotelName,OrderId,Time,Price,Room,Evaluate;
   
   @FXML
   private void ReturnButtonClicked(ActionEvent event){
	   UiswitchHelper.getApplication().goto_Usermainui();
   }
   
   @FXML 
   private void EvaluateClicked(ActionEvent event){
	   UiswitchHelper.getApplication().goto_OrderEvaluateui();
   }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
