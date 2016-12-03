package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisteruiController implements Initializable {
	
	 private String name,password,confirmpassword,phonenumber,birthday;
	  
     @FXML
     private TextField NameText,PhonenumberText;
     //                姓名，     手机号码
     
     @FXML
     private PasswordField PasswordText,PasswordconfirmText;
     //                    密码           确认密码
     
     @FXML
     private RadioButton Member,Company;
                        
     @FXML
     private Label NameLabel,BirthdayLabel;
     
  
     @FXML
     private DatePicker BirthdayDatepicker;
     
     @FXML
     private void MemberClicked(ActionEvent event){
    	 Company.setSelected(false);
    	 NameLabel.setText("姓名:            ");
    	 BirthdayLabel.setVisible(true);
    	 BirthdayDatepicker.setVisible(true);
    	 
    	 
     }
     @FXML
      private void CompanyClicked(ActionEvent event){
    	 Member.setSelected(false);
    	 NameLabel.setText("企业名:        ");
    	 BirthdayLabel.setVisible(false);
    	 BirthdayDatepicker.setVisible(false); 	 
     }
     
     
     
     @FXML
     private void CommitbuttonClicked(ActionEvent event){
    	 if(Member.isSelected()){
    		 name=NameText.getText();
    		 password=PasswordText.getText();
    		 confirmpassword=PasswordconfirmText.getText();
    		 phonenumber=PhonenumberText.getText();
    		 birthday=BirthdayDatepicker.getValue().toString();
    	 }else if(Company.isSelected()){
    		 name=NameText.getText();
    		 password=PasswordText.getText();
    		 confirmpassword=PasswordconfirmText.getText();
    		 phonenumber=PhonenumberText.getText();
    		 birthday="null";
    	 }else{
    		 
    	 }
     }
     @FXML
     private void ReturnbuttonClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_Loginui();
     }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
