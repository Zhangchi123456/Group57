package org.Hotel.client.presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HotelorderInfouiController implements Initializable{
	@FXML
	private Button refresh,back,check;
	
	@FXML
	private TextField INtimetx,OutTimetx;
	
	@FXML
	private Label orderInfo,INtime,OutTime,State,Person;
	
	@FXML
	private ChoiceBox Statetx;
     
	@FXML
	private void StateChoiceBoxClicked(ActionEvent event){
		ObservableList T=FXCollections.observableArrayList("鏈墽琛�","宸叉墽琛�","寮傚父","宸叉挙閿�");
		Statetx.setItems(T);
		
	}
	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
	
		
	}
	@FXML
	private void RefrashClicked(ActionEvent event){
		
	}
	@FXML
    private void CheckClicked(ActionEvent event){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
