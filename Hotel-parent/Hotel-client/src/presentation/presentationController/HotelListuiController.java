package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.UsercreditrecorduiController.CreditRecord;
import vo.HotelVO;

public class HotelListuiController implements Initializable{
	
	
	@FXML
	private CheckBox ReservationCheckbox;//是否预定过该酒店
	@FXML
	private TableView<SimpleHotel> HotelTable;//酒店列表
	@FXML
	private TableColumn<SimpleHotel,String> HotelName,HotelStar,HotelScore,HotelPrice,Reservation;//表中项目
	@FXML
	private Button ReturnButton;
	
    //界面跳转
    
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
        UiswitchHelper.getApplication().goto_Usermainui();
    }
    @FXML
    private void ObservedHotel(ActionEvent event){
        UiswitchHelper.getApplication().goto_Usermainui();
    }
    @FXML
    private void CheckButtonClicked(ActionEvent event){
        UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<HotelVO> hotellist1=new ArrayList<HotelVO>();
		ArrayList<SimpleHotel> hotellist2=new ArrayList<SimpleHotel>();
		for(int i=0;i<hotellist1.size();i++){
			hotellist2.add(new SimpleHotel(hotellist1.get(i).getName(),String.valueOf(hotellist1.get(i).getStar())
					,String.valueOf(hotellist1.get(i).getGrade()),String.valueOf(hotellist1.get(i).getSingleRoomPrice()),"否"));
		}
		
		ObservableList<SimpleHotel> finallist =FXCollections.observableArrayList();
		HotelName.setCellValueFactory(
	            new PropertyValueFactory<>("hotelname"));
	 
		HotelName.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
		HotelName.setOnEditCommit(
	            (CellEditEvent<SimpleHotel, String> t) -> {
	                ((SimpleHotel) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setHotelnamen((t.getNewValue()));
	        });
		
		HotelStar.setCellValueFactory(
	            new PropertyValueFactory<>("hotelstar"));
	 
		HotelStar.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
		HotelStar.setOnEditCommit(
	            (CellEditEvent<SimpleHotel, String> t) -> {
	                ((SimpleHotel) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setHotelstar(((t.getNewValue())));
	        });
		
		
		HotelScore.setCellValueFactory(
		            new PropertyValueFactory<>("hotelgrade"));
	   	 
			HotelScore.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
			HotelScore.setOnEditCommit(
		            (CellEditEvent<SimpleHotel, String> t) -> {
		                ((SimpleHotel) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setHotelgrade(((t.getNewValue())));
		        });
			

			Reservation.setCellValueFactory(
		            new PropertyValueFactory<>("Ifreservationed"));
		 
			Reservation.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
			Reservation.setOnEditCommit(
		            (CellEditEvent<SimpleHotel, String> t) -> {
		                ((SimpleHotel) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setIfReservation((((t.getNewValue()))));
		        });
		  HotelTable.setItems(finallist);
		
	}
	
	public static class SimpleHotel {
		 
        private final SimpleStringProperty hotelname;
        private final SimpleStringProperty hotelstar;
        private final SimpleStringProperty hotelgrade;
        private final SimpleStringProperty hotelprice;
        private final SimpleStringProperty Ifreservationed;
       
 
        private SimpleHotel(String Hotelname,String Orderid,String Time,String Creditchange,String Creditlast){
        	  this.hotelname = new SimpleStringProperty(Hotelname);
        	  this.hotelstar = new SimpleStringProperty(String.valueOf(Orderid));
        	  this.hotelgrade = new SimpleStringProperty(Time);    	  
        	  this.hotelprice = new SimpleStringProperty(String.valueOf(Creditchange));
        	  this.Ifreservationed = new SimpleStringProperty(Creditlast);
        	
        }  
 
        public void setHotelnamen(String Action) {
			
        	this.hotelname.set(Action);
		}

		public void setHotelstar(String Creditchange) {
			
			hotelstar.set(Creditchange);
		}

		
		public void setHotelgrade(String Creditlast) {
			
			hotelgrade.set(Creditlast);
		}

		public void setHotelprice(String hotelname) {
			
			hotelprice.set(hotelname);
		}

		public void setIfReservation(String f) {
			
			Ifreservationed.set(f);
		}



		public String getName() {
            return hotelname.get();
        }
 
     

		public String getHotelstar() {
			return hotelstar.get();
		}

		public String getHotlgrade() {
			return hotelgrade.get();
		}

		public String getHotelprice() {
			return hotelprice.get();
		}

		public String getIfreservationed() {
			return Ifreservationed.get();
		}

	
    
  }
}


