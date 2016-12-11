package presentation.presentationController;

import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import vo.MemberVO;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.UsercreditrecorduiController.CreditRecord;
import presentation.userui.AlertBox;

public class UserWebManagementController implements Initializable{
	
	@FXML
    private Label user;
    @FXML
    private TextField NameText,MemberlevelText,PhonenumberText,CreditvalueText;
    @FXML
    private DatePicker BirthdayDatepicker;
    @FXML
    private TableView table;
    @FXML
    private TableColumn nameColumn;
    
 
    
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void modifyButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	
	
	
	
}









