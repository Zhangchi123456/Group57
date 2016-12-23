package presentation.presentationController;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.impl.MemberLogicServiceImpl;
import Helper.RegisterHelper;
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
import presentation.userui.AlertBox;
import vo.MemberVO;

public class RegisteruiController implements Initializable {
	 private RegisterHelper helper=new RegisterHelper();
	 private String name,password,confirmpassword,phonenumber;
	 MemberLogicService memberlogic = new MemberLogicServiceImpl();
	 LocalDate birthday;
	  AlertBox alt=new AlertBox();
     @FXML
     private TextField NameText,PhonenumberText;
     //                姓名，     手机号码
     
     @FXML
     private PasswordField PasswordText,PasswordconfirmText;
     //                    密码           确认密码
     
     @FXML
     private RadioButton Member,Company;
     //       企业和个人会员         
     @FXML
     private Label NameLabel,BirthdayLabel;
     //          姓名           
  
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
    	 MemberVO membervo=new MemberVO(0, 0, null, null, null);
    	
    	 if(!Allisfilled()){
    		 AlertBox alt = new AlertBox();
				alt.display("信息填写不全");
    	 }
    	 else if(!Passwordcorrect()){
    		 AlertBox alt2 = new AlertBox();
				alt2.display("密码两次填写不一致");
    	 }
    	 else if(testname(NameText.getText())){
    			 AlertBox alt = new AlertBox();
 				alt.display("用户名已存在");
    		 }
    	
    	 else{
    	     if(Member.isSelected()){
    		
    		 name=NameText.getText();
    		 password=PasswordText.getText();
    		 confirmpassword=PasswordconfirmText.getText();
    		 phonenumber=PhonenumberText.getText();
    		 birthday=BirthdayDatepicker.getValue();
    		 
    		 membervo.setbyString("个人会员", name, password, birthday,phonenumber);
    		 
			if(helper.insertMember(membervo)){
					alt.display("注册成功");
				}else {
					alt.display("请勿频繁注册");
				}
    	 }else if(Company.isSelected()){
    		 name=NameText.getText();
    		 password=PasswordText.getText();
    		 confirmpassword=PasswordconfirmText.getText();
    		 phonenumber=PhonenumberText.getText();
    		 birthday=BirthdayDatepicker.getValue();
    		 membervo.setbyString("企业会员", name, password, birthday,phonenumber);
    	   
				if(helper.insertMember(membervo)){
					alt.display("注册成功");
				}else{
					alt.display("请勿频繁注册");
				}
	    	 }
    	    
    	 }
     }
     
     private boolean Allisfilled(){
    	 if(NameText.getText().isEmpty()||PasswordText.getText().isEmpty()
    		||PasswordconfirmText.getText().isEmpty()||PhonenumberText.getText().isEmpty()
    		||(!Member.isSelected()&&!Company.isSelected())){
    		 return false;
    	 }
    	 return true;
    		 
     }
     private boolean Passwordcorrect(){
    	 if(PasswordText.getText().equals(PasswordconfirmText.getText())){
    		 return true;
    	 }
    	 return false;
     }
     //检查是否存在同名用户
     private boolean testname(String name){
    	 ArrayList<String> member;
		 member = memberlogic.getnamelist();
			 for(int i=0;i<member.size();i++){
	    		 if(name==member.get(i)){
	    			 return true;
	    		 }
			 }
		return false;
    	 
     }
     
     @FXML
     private void ReturnbuttonClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_Loginui();
     }
     
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
