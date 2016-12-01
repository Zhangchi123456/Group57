package org.Hotel.client.presertationController;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrderListController implements Initializable {
    @FXML
    private TableView OrderList;
    @FXML
    private Button Sure;
    @FXML
    private Button Return;
    @FXML
    private ChoiceBox OrderStation;
    
    @FXML
	private void OrderTypeChoiceClicked(ActionEvent event){
		ObservableList T=FXCollections.observableArrayList("已执行","未执行","订单异常","所有订单");
		OrderStation.setItems(T);
		
	}
    @FXML
	  private void  ret(ActionEvent event){
		  
		  close(null);
	  }
	  //关闭
	  @FXML
		public void close(ActionEvent event){
			
			
		}
   
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}