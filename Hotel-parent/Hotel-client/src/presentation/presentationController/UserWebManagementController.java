package presentation.presentationController;

import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import vo.HotelStaffVO;
import vo.MemberVO;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.UsercreditrecorduiController.CreditRecord;
import presentation.userui.AlertBox;

public class UserWebManagementController implements Initializable{
	ObservableList<MemberVO> MemberVOs,staffSelected;
//	UserLogicService userblservice =new UserLogicServiceImpl();
	@FXML
    private Label user;
    @FXML
    private TextField NameText,MemberlevelText,PhonenumberText,CreditvalueText,membertype;
    @FXML
    private DatePicker BirthdayDatepicker;
    @FXML
    private TableView<MemberVO> table;
    @FXML
    private TableColumn<MemberVO,String> nameColumn;
    
    
	@FXML
	private void modifyButtonClicked(ActionEvent event){
//		staffSelected = FXCollections.observableArrayList();
//    	staffSelected=table.getSelectionModel().getSelectedItems();
//    	//set member info
//    	NameText.setText(staffSelected.get(0).getname());
//    	MemberlevelText.setText(staffSelected.get(0).getlevel());
//    	CreditvalueText.setText(String.valueOf(staffSelected.get(0).getcredit()));
//    	PhonenumberText.setText(String.valueOf(staffSelected.get(0).getphonenumber()));
//    	membertype.setText(String.valueOf(staffSelected.get(0).getproperty()));
//    	BirthdayDatepicker.setValue(LocalDate.parse(staffSelected.get(0).getBirthday()));
	}
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		
	}
	//jump to ui
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	@FXML
	private void AddHotelClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	}
	@FXML
	private void Webmanange(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		user.setText(LoginHelper.getLogVO().getUsername());
//		
//		table.setItems(getMember());
//		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//		//table can only select one item
//		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
	}
	
//	private ObservableList getMember(){
//        MemberVOs = FXCollections.observableArrayList();
//        MemberVOs.clear();
//        MemberVOs.retainAll();
//        //get member vo from data layer
//        ArrayList<MemberVO> list=userblservice.findMember();
//        for(MemberVO vo:list){
//        	MemberVOs.add(vo);
//        }
//        return MemberVOs;
//    }
	
	
	
}









