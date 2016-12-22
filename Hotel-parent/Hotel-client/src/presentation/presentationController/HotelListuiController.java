package presentation.presentationController;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.ReservationController;
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
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.WebPromotionVO;

public class HotelListuiController implements Initializable{
	private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	private ObservableList<SimpleHotel> finallist;
	private ObservableList<SimpleHotel> reservationedlist;
	private ArrayList<SimpleHotel> hotellist3;
	private AlertBox alt = new AlertBox();//提示框
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
    private void CreatOrderClicked(ActionEvent event) throws RemoteException{
      	int selectnumber=Hoteltable.getSelectionModel().getSelectedIndex();
    	if(selectnumber==-1){
    		alt.display("未选中酒店");
    	}
    	else{
    	if(ReservationCheckbox.isSelected()){
    		ObservableList<SimpleHotel> list=Hoteltable.getItems();
    		String name=list.get(selectnumber).getHotel();
    		HotelVO hotelVO=reservationService.findbyname(name);
    		ArrayList<HotelPromotionVO> hotelprolist=reservationService.findhotelpro(name);
    		ReservationController.setHotelproList(hotelprolist);
    		ReservationController.setHotelvo(hotelVO);
    	}else{
    		HotelVO currenthotel=ReservationController.getHotelvolist().get(selectnumber);
    		ReservationController.setHotelvo(currenthotel);
    		String name=currenthotel.getName();
    		ArrayList<HotelPromotionVO> hotelprolist=reservationService.findhotelpro(name);
    		ReservationController.setHotelproList(hotelprolist);
    	}
        UiswitchHelper.getApplication().goto_OrderinputUi();
    	}
    }
  @FXML
  private void ReservationClicked(ActionEvent event){
	  
	  if(ReservationCheckbox.isSelected()){
		  ArrayList<SimpleHotel> hotellist4=new ArrayList<SimpleHotel>();		  		 
		  for(int i=0;i<hotellist3.size();i++){		 		  
			if(hotellist3.get(i).getIfreservationed().equals("是")){
					  hotellist4.add(hotellist3.get(i));
				  }		  
		  }
		 
		  ObservableList<SimpleHotel> finallist2=FXCollections.observableArrayList(hotellist4);
		  Hoteltable.setItems(finallist2);
	  }
	  else{
		  Hoteltable.setItems((finallist));
	  }
      
  }
    @FXML
    private void CheckButtonClicked(ActionEvent event) throws RemoteException{
    	int selectnumber=Hoteltable.getSelectionModel().getSelectedIndex();
    	if(selectnumber==-1){
    		alt.display("未选中酒店");
    	}
    	else{
    	
    	if(ReservationCheckbox.isSelected()){
    		ObservableList<SimpleHotel> list=Hoteltable.getItems();
    		String name=list.get(selectnumber).getHotel();
    		HotelVO hotelVO=reservationService.findbyname(name);
    		ReservationController.setHotelvo(hotelVO);
    	}else{
    		HotelVO currenthotel=ReservationController.getHotelvolist().get(selectnumber);
    		ReservationController.setHotelvo(currenthotel);
    	}
        UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<WebPromotionVO> weblist=reservationService.showall();
		ReservationController.setWebpromotionvolist(weblist);
		ArrayList<HotelVO> hotellist1=ReservationController.getHotelvolist();

		try {
			HotelVO testhotel=reservationService.findbyname("南行酒店");
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<SimpleHotel> hotellist2=new ArrayList<SimpleHotel>();
		for(int i=0;i<hotellist1.size();i++){
			HotelVO vo=hotellist1.get(i);
			hotellist2.add(new SimpleHotel(vo.getName(),vo.getStar(),vo.getGrade(),vo.getSingleRoomPrice(),reservationService.Ifreservationed(LoginController.UserName, vo)));
		
		}
		hotellist3=hotellist2;
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
	            new PropertyValueFactory<>("star"));
	 
		HotelStar.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
		HotelStar.setOnEditCommit(
	            (CellEditEvent<SimpleHotel, String> t) -> {
	                ((SimpleHotel) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStar(((t.getNewValue())));
	        });
		
		
		    HotelScore.setCellValueFactory(
		            new PropertyValueFactory<>("grade"));
	   	 
			HotelScore.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
			HotelScore.setOnEditCommit(
		            (CellEditEvent<SimpleHotel, String> t) -> {
		                ((SimpleHotel) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setGrade(((t.getNewValue())));
		        });
			
			HotelPrice.setCellValueFactory(
		            new PropertyValueFactory<>("hotelprice"));
	   	 
			HotelPrice.setCellFactory(TextFieldTableCell.<SimpleHotel>forTableColumn());
			HotelPrice.setOnEditCommit(
		            (CellEditEvent<SimpleHotel, String> t) -> {
		                ((SimpleHotel) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setHotelprice(((t.getNewValue())));
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
		
	}
	
	public static class SimpleHotel {            
        private final SimpleStringProperty hotelprice;
        private final SimpleStringProperty Ifreservationed;
        private final SimpleStringProperty hotel;
        private final SimpleStringProperty star;
        private final SimpleStringProperty grade;
        
        private SimpleHotel(String Hotel,int star,double grade,double price,String Creditlast){
        	  this.hotel = new SimpleStringProperty(Hotel);
        	 	  
        	  this.hotelprice = new SimpleStringProperty(String.valueOf(price));
        	  this.Ifreservationed = new SimpleStringProperty(Creditlast);
        	  this.star=new SimpleStringProperty(String.valueOf(star));
        	  this.grade=new SimpleStringProperty(String.valueOf(grade));
        }  
 
       public void setHotel(String name){
    	   hotel.set(name);
       }

		public void setHotelprice(String hotelname) {
			
			hotelprice.set(hotelname);
		}
		public void setGrade(String grades){
			grade.set(grades);
		}

		public void setIfReservation(String f) {
			
			Ifreservationed.set(f);
		}
       public void setStar(String rats){
    	   star.set(rats);
       }


		public String getHotel(){
			return hotel.get();
		}
     
		public String getStar(){
			return star.get();
		}
     

		
       public String getGrade(){
    	   return grade.get();
       }

		public String getHotelprice() {
			return hotelprice.get();
		}

		public String getIfreservationed() {
			return Ifreservationed.get();
		}

	
    
  }
}


