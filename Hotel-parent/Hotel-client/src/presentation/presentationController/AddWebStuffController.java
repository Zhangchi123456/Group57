package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.WebStaffVO;

public class AddWebStuffController implements Initializable{
	UserLogicService userblservice =new UserLogicServiceImpl();
    @FXML
    private TextField NameText,PhonenumberText;
    
    @FXML
    private PasswordField password,ensurepassword;
    
    @FXML
    private PasswordField PasswordText,ConfirmTextField;
    
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
    }
    
    @FXML
    private void AddButtonClicked(ActionEvent event){
    	String name=NameText.getText().trim();
    	String newPass=password.getText().trim();
    	String ensurePass=ensurepassword.getText().trim();
//    	System.out.println("this is insane");
    	//pre condition
    	if(name.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("姓名为空");
    	}else if(newPass.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("密码为空");
    	}else if(newPass.length()<6||newPass.length()>16){
    		AlertBox alt = new AlertBox();
			alt.display("密码长度为6-16位");
    	}else if(ensurePass.length()==0){
    		AlertBox alt = new AlertBox();
			alt.display("确认密码为空");
    	}else if(!ensurePass.equals(newPass)){
    		AlertBox alt = new AlertBox();
			alt.display("确认密码与密码不同");
    	}else if(userblservice.findWebStaffBYName(name)){
    		AlertBox alt = new AlertBox();
			alt.display("姓名已存在");
    	}else{
    		System.out.println(name+newPass+"what");
    		WebStaffVO vo =new WebStaffVO(name,newPass);
    		userblservice.addWebStaff(vo);
    		//reminder
    		AlertBox alt = new AlertBox();
			alt.display("新增成功！");
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
