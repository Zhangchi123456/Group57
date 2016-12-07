package presentation.presentationController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Controller.MemberActController;
import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.MemberVO;

public class UserinformationuiController implements Initializable{
	 private MemberVO membervo;
	 private String membername,phonenumber;
	 private LocalDate birthday;
     @FXML
     private Label MembercharacterLabel,MemberlevelLabel,MembercreditvalueLabel,DiscountLabel;
     //             会员性质              会员等级          会员信用值               会员折扣
     @FXML
     private TextField MembernameText,PhonenumberText;
     //                 会员名          手机号码（联系方式）
     @FXML
     private DatePicker BirthdayDatepicker;
     //                 会员生日
    
     
     @FXML
     private void SaveButtonClicked(ActionEvent event){
    	 if(!Allisfilled()){
    		 AlertBox alt = new AlertBox();
				alt.display("请务必将用户名和联系方式填写完全");
    	 }else{
    		 membername=MembernameText.getText().toString();
    		 phonenumber=PhonenumberText.getText().toString();
    		 birthday=BirthdayDatepicker.getValue();
    		 MemberActController.getmemberVo().updateInfo(membername, birthday, phonenumber);
    		 
    	 }
     }
     
     @FXML
     private void ReturnButtonClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_Usermainui();
     }
     
     private boolean Allisfilled(){
    	 if(MembernameText.getText().isEmpty()||PhonenumberText.getText().isEmpty()){
    		 return false;
    	 }
    	 return true;
     }
     
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		membervo=ReservationController.getMembervo();
		MembernameText.setText(membervo.getname());
		
		/*MembercharacterLabel.setText(membervo.getproperty());
		MemberlevelLabel.setText(membervo.getlevel());
		MembercreditvalueLabel.setText(String.valueOf(membervo.getcredit()));
		
		PhonenumberText.setText(membervo.getphonenumber());
		BirthdayDatepicker.setValue(membervo.getbirthday());
		*/
	}

}
