package presentation.presentationController;

import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import vo.MemberVO;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.UsercreditrecorduiController.CreditRecord;
import presentation.userui.AlertBox;

public class UserWebManagementController implements Initializable{
	private String membername,memberlevel,phonenumber,creditvalue;
	private LocalDate birthday;
	private ObservableList<SimpleMember> finallist;
    @FXML
    private TextField NameText,MemberlevelText,PhonenumberText,CreditvalueText;
    
    @FXML
    private DatePicker BirthdayDatepicker;
    
    @FXML
    private TableView<SimpleMember> MemberTable;
    
    @FXML
    private TableColumn<SimpleMember,String> Membername,Memberid;
    
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		if(!Allisfilled()){
			AlertBox alt = new AlertBox();
			alt.display("除生日外的其他信息不得为空");
		}else{
			membername=NameText.getText().toString();
			memberlevel=MemberlevelText.getText().toString();
			phonenumber=PhonenumberText.getText().toString();
			creditvalue=CreditvalueText.getText().toString();
		}
	}
	
	private boolean Allisfilled(){
		if(NameText.getText().isEmpty()||MemberlevelText.getText().isEmpty()||
				PhonenumberText.getText().isEmpty()||CreditvalueText.getText().isEmpty()){
			return false;
		}
		return true;
	}
	@FXML
	private void Webmanange(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
	}
	@FXML
	private void AddHotelClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	}
	
	@FXML
	private void MemberAddClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	public static class SimpleMember {
		 
        private final SimpleStringProperty MemberID;
        private final SimpleStringProperty membername;
 
        public SimpleMember(String Name,String ID){
        	  this.membername = new SimpleStringProperty(Name);
        	  this.MemberID = new SimpleStringProperty(ID);
        	 
        }  
 
       public void setmembername(String str){
    	   this.membername.set(str);
       }

		public void setMemberID(String ID) {
			
			this.MemberID.set(ID);
		}



		public String getmemberName() {
            return this.membername.get();
        }
 
     

		public String getId() {
			return this.MemberID.get();
		}

	
    
  }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<MemberVO> memberlist1=new ArrayList<MemberVO>();
		ArrayList<SimpleMember> memberlist2=new ArrayList<SimpleMember>();
		MemberVO vo1=new MemberVO(0, 0,  "会员一","1", "1");
		vo1.setid(2);
		memberlist1.add(vo1);
		
		
		for(int i=0;i<memberlist1.size();i++){
			memberlist2.add(new SimpleMember(memberlist1.get(i).getname(),String.valueOf(memberlist1.get(i).getid())));
		}
		finallist =FXCollections.observableArrayList(memberlist2);
		System.out.println(finallist.get(0).getmemberName());
		Memberid.setCellValueFactory(
	            new PropertyValueFactory<SimpleMember,String>("MemberID"));
	 
		Memberid.setCellFactory(TextFieldTableCell.<SimpleMember>forTableColumn());
		Memberid.setOnEditCommit(
	            (CellEditEvent<SimpleMember, String> t) -> {
	                ((SimpleMember) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setMemberID((t.getNewValue()));
	        });
		
		Membername.setCellValueFactory(
	            new PropertyValueFactory<SimpleMember,String>("hotel"));
	 
		Membername.setCellFactory(TextFieldTableCell.<SimpleMember>forTableColumn());
		Membername.setOnEditCommit(
	            (CellEditEvent<SimpleMember, String> t) -> {
	                ((SimpleMember) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setmembername(((t.getNewValue())));
	        });
		
		MemberTable.setItems(finallist);
		
		
	}
	
	
	
	
	
}









