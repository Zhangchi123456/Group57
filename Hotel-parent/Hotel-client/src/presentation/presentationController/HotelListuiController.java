package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
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
	private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	private ObservableList<SimpleHotel> finallist;
	private ObservableList<SimpleHotel> reservationedlist;
	@FXML
	private CheckBox ReservationCheckbox;//是否预定过该酒店
	@FXML
	private TableView<SimpleHotel> Hoteltable;//酒店列表
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
  private void ReservationClicked(ActionEvent event){
	  
	  if(ReservationCheckbox.isSelected()){
		  Hoteltable.setItems(reservationedlist);
	  }
	  else{
		  Hoteltable.setItems((finallist));
	  }
      
  }
    @FXML
    private void CheckButtonClicked(ActionEvent event){
    	int selectnumber=Hoteltable.getSelectionModel().getSelectedIndex();
    	System.out.println(finallist.get(selectnumber).getHotel());
        UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ArrayList<HotelVO> hotellist1=new ArrayList<HotelVO>();
		HotelVO vo1=new HotelVO();
		vo1.setName("123");vo1.setStar(5);
		HotelVO vo2=new HotelVO();
		vo2.setName("456");vo2.setStar(3);
		hotellist1.add(vo1);
		hotellist1.add(vo2);
		ArrayList<SimpleHotel> hotellist2=new ArrayList<SimpleHotel>();
		for(int i=0;i<hotellist1.size();i++){
			hotellist2.add(new SimpleHotel(hotellist1.get(i).getName(),String.valueOf(hotellist1.get(i).getStar())
					,String.valueOf(hotellist1.get(i).getGrade()),String.valueOf(hotellist1.get(i).getSingleRoomPrice()),"否"));
		}
		
		finallist =FXCollections.observableArrayList(hotellist2);
		
		HotelName.setCellValueFactory(
	            new PropertyValueFactory<>("hotel"));
	 
		HotelName.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
		HotelName.setOnEditCommit(
	            (CellEditEvent<SimpleHotel, String> t) -> {
	                ((SimpleHotel) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setHotel(((t.getNewValue())));
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
			
			HotelPrice.setCellValueFactory(
		            new PropertyValueFactory<>("hotelprice"));
	   	 
			HotelPrice.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
			HotelPrice.setOnEditCommit(
		            (CellEditEvent<SimpleHotel, String> t) -> {
		                ((SimpleHotel) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setHotelprice((((t.getNewValue()))));
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
		  Hoteltable.setItems(finallist);
		System.out.println(1);
	}
	
	public static class SimpleHotel {
		 
        
        private final SimpleStringProperty hotelstar;
        private final SimpleStringProperty hotelgrade;
        private final SimpleStringProperty hotelprice;
        private final SimpleStringProperty Ifreservationed;
        private final SimpleStringProperty hotel;
 
        private SimpleHotel(String Hotel,String Orderid,String Time,String Creditchange,String Creditlast){
        	  this.hotel = new SimpleStringProperty(Hotel);
        	  this.hotelstar = new SimpleStringProperty(String.valueOf(Orderid));
        	  this.hotelgrade = new SimpleStringProperty(Time);    	  
        	  this.hotelprice = new SimpleStringProperty(String.valueOf(Creditchange));
        	  this.Ifreservationed = new SimpleStringProperty(Creditlast);
        	
        }  
 
       public void setHotel(String name){
    	   hotel.set(name);
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



		public String getHotel(){
			return hotel.get();
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


