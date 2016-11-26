package org.Hotel.client.presertationController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class hoteldiscountdateuiController implements Initializable{
	
	@FXML
	private Button button_birthday;
	
	@FXML
	private Button button_businesspartner;
	
	@FXML
	private Button button_roomnumber;
	
	@FXML
	private TextField hoteldiscountdatediscount;
	
	@FXML
	private TableView hoteldiscountdateTable;
	
	@FXML
	private TableColumn hoteldiscountdateTable_start;
	
	@FXML
	private TableColumn hoteldiscountdateTable_end;
	
	@FXML
	private TableColumn hoteldiscountdateTable_discount;
	
	@FXML
	private Button delete;
	
	@FXML
	private TextField startMonth;
	
	@FXML
	private TextField startDate;
	
	@FXML
	private TextField endMonth;
	
	@FXML
	private TextField endDate;
	
	@FXML
	private TextField newDiscount;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button back;
	
	@FXML
	public void toBusinesspartner(ActionEvent event){
		
	}
	
	@FXML
	public void toRoomnumber(ActionEvent event){
		
	}
	
	@FXML
	public void toBirthday(ActionEvent event){
		
	}
	
	@FXML
	public void delete(ActionEvent event){
		
	}
	
	@FXML
	public void update(ActionEvent event){
		
	}
	
	@FXML
	public void toBack(ActionEvent event){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}


