package org.Hotel.client.presertationController;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class OrderInfoController implements Initializable {
	
    @FXML
    private Label Hotel;
    @FXML
    private Label UserNum;
    @FXML
    private Label Telephone;
    
    @FXML
    private Label Child;
   
    @FXML
    private Label RoomType;
    @FXML
    private Label TimeBegin;
    @FXML
    private Label TiemEnd;
    @FXML
    private Button Sure;
    @FXML
    private Button Return;
	
	
	  @FXML
	  private void  ret(ActionEvent event){
		  
		  close(null);
	  }
	  //关闭
	  @FXML
		public void close(ActionEvent event){
		
		}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
