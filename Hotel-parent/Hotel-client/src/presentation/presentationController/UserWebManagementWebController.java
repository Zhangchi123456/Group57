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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserWebManagementWebController implements Initializable{
	String webpromotionName,webpromotionPassword,webpromotionPhonenumber;
	UserLogicService userblservice =new UserLogicServiceImpl();
	
    @FXML
    private TextField NameText,PhonenumberText,PasswordText;
    
    @FXML
    private PasswordField password,ensurePassword,oldpassword;
    
    @FXML
    private TableView<WebStaffVO> table;
    
    @FXML
    private TableColumn<WebStaffVO,String> nameColumn;
    
    @FXML
    private void SaveButtonClicked(ActionEvent event){
    	
    }
    
    @FXML
    private void ModifyButtonClicked(ActionEvent event){
    	
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
		
//		table.setItems(getWebStaff());
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		table.getColumns().addAll(nameColumn);
	}
	
	public ObservableList getWebStaff(){
        ObservableList<WebStaffVO> WebStaffVOs = FXCollections.observableArrayList();
        
        ArrayList<WebStaffVO> list=userblservice.findWebStaff();
        for(WebStaffVO vo:list){
        	System.out.println(vo.getName());
        	WebStaffVOs.add(vo);
        }
        return WebStaffVOs;
    }
	public static void main(String[] args){
		UserWebManagementWebController web=new UserWebManagementWebController();
		web.getWebStaff();
	}
	

}
