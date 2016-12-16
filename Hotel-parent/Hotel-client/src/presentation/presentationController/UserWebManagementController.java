package presentation.presentationController;

import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.UserLogicService;
import BusinessLogicService.impl.UserLogicServiceImpl;
import vo.HotelStaffVO;
import vo.MemberVO;
import vo.WebStaffVO;
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
	UserLogicService userblservice =new UserLogicServiceImpl();
	@FXML
    private Label user;
    @FXML
    private TextField NameText,MemberlevelText,PhonenumberText,CreditValueText,membertype;
    @FXML
    private DatePicker BirthdayDatepicker;
    @FXML
    private TableView<MemberVO> table;
    @FXML
    private TableColumn<MemberVO,String> nameColumn;
    
    
	@FXML
	private void modifyButtonClicked(ActionEvent event){
		staffSelected = FXCollections.observableArrayList();
    	staffSelected=table.getSelectionModel().getSelectedItems();
    	//precondition:clear phone text and date picker
    	PhonenumberText.clear();
    	BirthdayDatepicker.setValue(null);
    	//set member info
    	if(!staffSelected.isEmpty()){
    		//set member info
    		NameText.setText(staffSelected.get(0).getname());
    		MemberlevelText.setText(staffSelected.get(0).getlevel());
    		membertype.setText(String.valueOf(staffSelected.get(0).getproperty()));
    		CreditValueText.setText(String.valueOf(staffSelected.get(0).getcredit()));
    		//phone number and birthday exist
    		if(staffSelected.get(0).getphonenumber()!=null){
    			PhonenumberText.setText(String.valueOf(staffSelected.get(0).getphonenumber()));
    		}
    		if(staffSelected.get(0).getBirthday()!=null){
    			BirthdayDatepicker.setValue(staffSelected.get(0).getbirthday());
    		}
    		
    	}
	}
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		String name=NameText.getText().trim();
		String phoneNum =PhonenumberText.getText().trim();
		LocalDate birthday=BirthdayDatepicker.getValue();
		
		if(name.length()==0)
		{
			return;
		}
		MemberVO vo=staffSelected.get(0);
    	//edit phonenum and birthday
		
		//can't delete phone numbers
    	if(phoneNum.length()==0&&birthday==null){
    		return;
    	}else if(birthday==null&&phoneNum.length()!=0){
    		if(!phoneNum.equals(vo.getPhonenumber())){
    			vo.setPhonenumber(phoneNum);
    			userblservice.saveMember(vo);
    			AlertBox alt = new AlertBox();
    			alt.display("会员信息已保存");
    		}
    	}else if(birthday!=null&&phoneNum.length()==0){
    		if(!birthday.equals(vo.getbirthday())){
    			vo.setMemberbirthday(birthday);
    			userblservice.saveMember(vo);
    			AlertBox alt = new AlertBox();
    			alt.display("会员信息已保存");
    		}
    	}else{
    		if(!phoneNum.equals(vo.getPhonenumber())||!birthday.equals(vo.getbirthday())){
    			vo.setPhonenumber(phoneNum);
    			vo.setMemberbirthday(birthday);
    			userblservice.saveMember(vo);
    			AlertBox alt = new AlertBox();
    			alt.display("会员信息已保存");
    		}

    	}
    	
	}
	//jump to other ui
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
		user.setText(LoginHelper.getLogVO().getUsername());
		
		table.setItems(getMember());
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("membername"));
		//table can only select one item
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	private ObservableList getMember(){
        MemberVOs = FXCollections.observableArrayList();
        //get member vo from data layer
        ArrayList<MemberVO> list=userblservice.findMember();
        for(MemberVO vo:list){
        	MemberVOs.add(vo);
        }
        return MemberVOs;
    }
	
	
	
}


