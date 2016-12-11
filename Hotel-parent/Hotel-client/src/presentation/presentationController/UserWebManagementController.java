package presentation.presentationController;

import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import vo.HotelStaffVO;
import vo.MemberVO;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
	UserLogicService userblservice =new UserLogicServiceImpl();
	@FXML
    private Label user;
    @FXML
    private TextField NameText,MemberlevelText,PhonenumberText,CreditvalueText;
    @FXML
    private DatePicker BirthdayDatepicker;
    @FXML
    private TableView<MemberVO> table;
    @FXML
    private TableColumn<MemberVO,String> nameColumn;
    
 
    
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void modifyButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	private ObservableList getHotelStaff(){
        MemberVOs = FXCollections.observableArrayList();
        MemberVOs.clear();
        MemberVOs.retainAll();
        //get member vo from data layer
        ArrayList<MemberVO> list=userblservice.findHotelStaff();
        for(HotelStaffVO vo:list){
        	HotelStaffVOs.add(vo);
        }
        return HotelStaffVOs;
    }
	
	
	
}









