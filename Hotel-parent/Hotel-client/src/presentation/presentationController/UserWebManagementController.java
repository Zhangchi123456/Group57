package presentation.presentationController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;

public class UserWebManagementController implements Initializable{
	private String membername,memberlevel,phonenumber,creditvalue;
	private LocalDate birthday;
    @FXML
    private TextField NameText,MemberlevelText,PhonenumberText,CreditvalueText;
    
    @FXML
    private DatePicker BirthdayDatepicker;
    
    @FXML
    private TableView MemberTable;
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		if(!Allisfilled()){
			AlertBox alt = new AlertBox();
			alt.display("除生日外的其他信息不得为空");
		}else{
			membername=NameText.getText().toString();
			memberlevel=MemberlevelText.getText().toString();
			phonenumber=PhonenumberText.getText().toString();
			creditvalue=CreditvalueText.getText().toString();
		}
	}
	
	private boolean Allisfilled(){
		if(NameText.getText().isEmpty()||MemberlevelText.getText().isEmpty()||
				PhonenumberText.getText().isEmpty()||CreditvalueText.getText().isEmpty()){
			return false;
		}
		return true;
	}
	@FXML
	private void Webmanange(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
	}
	@FXML
	private void AddHotelClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	}
	
	@FXML
	private void MemberAddClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
