package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.userui.AlertBox;
import vo.HotelStaffVO;
import vo.WebStaffVO;

public class UserWebManagementHotelController implements Initializable{
	ObservableList<HotelStaffVO> HotelStaffVOs,staffSelected;
	UserLogicService userblservice =new UserLogicServiceImpl();
	@FXML
	private Label user;
    @FXML
    private TextField nameText,PasswordText,hotel;
    @FXML
    private PasswordField newpassword,ensurepassword;
    @FXML
    private Label username;
    @FXML
    private TableView<HotelStaffVO> table;
    @FXML
    private TableColumn<HotelStaffVO,String> nameColumn,hotelColumn;
    
    @FXML
    private void SaveButtonClicked(ActionEvent event){
    	String newPass=newpassword.getText().trim();
    	String ensurePass=ensurepassword.getText().trim();
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
    		HotelStaffVO vo=staffSelected.get(0);
    		staffSelected.get(0).setPassword(newPass);
    		userblservice.saveHotelStaff(new HotelStaffVO(vo.getName(),vo.getPassword(),vo.getHotelname()));
    		AlertBox alt = new AlertBox();
			alt.display("密码已保存");
//			newpassword.clear();
//			ensurepassword.clear();
    	}
    }
    @FXML
    private void modifyButtonClicked(ActionEvent event){
    	staffSelected = FXCollections.observableArrayList();
    	staffSelected=table.getSelectionModel().getSelectedItems();
    	
    	nameText.setText(staffSelected.get(0).getName());
    	PasswordText.setText(staffSelected.get(0).getPassword());
    	hotel.setText(staffSelected.get(0).getHotelname());
    	//clear
    	newpassword.clear();
    	ensurepassword.clear();
    }
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void MemberManagementClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	
	@FXML
	private void Webmanange(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
	}
	@FXML
	private void AddHotelClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//set user name
		user.setText(LoginHelper.getLogVO().getUsername());
		
		table.setItems(getHotelStaff());
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		hotelColumn.setCellValueFactory(new PropertyValueFactory<>("hotelname"));
		//table can only select one item
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
	}
	//get hotel staff data
	private ObservableList getHotelStaff(){
        HotelStaffVOs = FXCollections.observableArrayList();
        HotelStaffVOs.clear();
        HotelStaffVOs.retainAll();
        //get hotel staff vo from data layer
        ArrayList<HotelStaffVO> list=userblservice.findHotelStaff();
        for(HotelStaffVO vo:list){
        	HotelStaffVOs.add(vo);
        }
        return HotelStaffVOs;
    }

}
