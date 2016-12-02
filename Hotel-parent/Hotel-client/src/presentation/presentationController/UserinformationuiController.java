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

public class UserinformationuiController implements Initializable{
     @FXML
     private Label MembercharacterLabel,MemberlevelLabel,MembercreditvalueLabel;
     //             会员性质              会员等级          会员信用值
     @FXML
     private TextField MembernameText,PhonenumberText;
     //                 会员名          手机号码（联系方式）
     @FXML
     private DatePicker BirthdayDatepicker;
     //                 会员生日
    
     
     @FXML
     private void SaveButtonClicked(ActionEvent event){
    	 
     }
     
     @FXML
     private void ReturnButtonClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_Usermainui();
     }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
