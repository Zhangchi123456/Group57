package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;

import Helper.UiswitchHelper;
import vo.*;
import javafx.collections.FXCollections;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.userui.AlertBox;

public class UserWebManagementWebController implements Initializable{
	ObservableList<WebStaffVO> WebStaffVOs,staffSelected;
	UserLogicService userblservice =new UserLogicServiceImpl();
	ArrayList<WebStaffVO> list=new ArrayList<WebStaffVO>();
	
    @FXML
    private TextField NameText,oldPassword;
    
    @FXML
    private PasswordField password,ensurePassword;
    
    @FXML
    private TableView<WebStaffVO> table;
    
    @FXML
    private TableColumn<WebStaffVO,String> nameColumn;
    
    @FXML
    private void SaveButtonClicked(ActionEvent event){
    	String newPass=password.getText().trim();
    	String ensurePass=ensurePassword.getText().trim();
    	//pre condition
    	if(newPass.length()==0){
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
    	}else{
    		WebStaffVO vo=staffSelected.get(0);
    		staffSelected.get(0).setPassword(newPass);
    		userblservice.saveWebStaff(new WebStaffVO(vo.getName(),vo.getPassword()));
    		AlertBox alt = new AlertBox();
			alt.display("密码已保存");
			password.clear();
			ensurePassword.clear();
    	}
    	
    }
    
    @FXML
    private void ModifyButtonClicked(ActionEvent event){
    	staffSelected = FXCollections.observableArrayList();
    	staffSelected=table.getSelectionModel().getSelectedItems();
    	
    	NameText.setText(staffSelected.get(0).getName());
    	oldPassword.setText(staffSelected.get(0).getPassword());
    	//clear
    	password.clear();
    	ensurePassword.clear();
    }
    
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	
	@FXML
	private void MemberMangementClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	@FXML
	private void AddHotelClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	}
	@FXML
	private void AddButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_AddWebStuffui();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		table.setItems(getWebStaff());
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		//table can only select one item
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
	}
	//get web staff data
	private ObservableList getWebStaff(){
        WebStaffVOs = FXCollections.observableArrayList();
        WebStaffVOs.clear();
        WebStaffVOs.retainAll();
        //get web staff vo from data layer
        ArrayList<WebStaffVO> list=userblservice.findWebStaff();
        for(WebStaffVO vo:list){
        	WebStaffVOs.add(vo);
        }
        return WebStaffVOs;
    }
	
	

}
