package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;
import vo.MemberVO ;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Controller.ReservationController;

public class OrderlistuiController implements Initializable{
   @FXML
   private Button ReturnButton;
   @FXML
   private TableView OrderList;
   @FXML
   private TableColumn HotelName,OrderId,Time,Price,Room,Evaluate,OrderStation;
   @FXML
   private ChoiceBox OrderStationChoiceBox;
   
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
		OrderStationChoiceBox.setValue("所有订单");
		
	
		
		
	}

}
