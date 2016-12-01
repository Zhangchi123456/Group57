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
import javafx.scene.control.TextField;

public class OrderInputController implements Initializable {
	
    @FXML
    private TextField UserName;
    @FXML
    private TextField UserNum;
    @FXML
    private TextField Telephone;
    
    @FXML
    private TextField TimeBegin;
    @FXML
    private TextField TimeEnd;
    @FXML
    private ChoiceBox RoomType;
    @FXML
    private ChoiceBox Child;
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
	  //确定监听
	  @FXML
       private void  sur(ActionEvent event){
		  String username = UserName.getText().trim();
		  String usernum = UserNum.getText().trim();
		  String telephone = Telephone.getText().trim();
		
		  String timebegin = TimeBegin.getText().trim();
		  String timeend = TimeEnd.getText().trim();
		  
		  
	  }
	  @FXML
		private void RoomTypeChoiceClicked(ActionEvent event){
			ObservableList T=FXCollections.observableArrayList("大床房","标准间","家庭房","套房");
			RoomType.setItems(T);
			
		}
	  @FXML
		private void HaveChildClicked(ActionEvent event){
			ObservableList T=FXCollections.observableArrayList("有","无");
			Child.setItems(T);
			
		}
	  
	 
     @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	

}
