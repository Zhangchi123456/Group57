package org.Hotel.client.presentation.userui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.shape.Circle;
import javafx.animation.Timeline;



import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;



public class Loginui extends Application{
	Stage window;
	
	public void start(Stage myStage){
		window=myStage;
		
		GridPane grid=new GridPane();
	
		grid.setPrefSize(600, 400);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(20,20,20,20));
		
		Text account=new Text("账号");
		Text password=new Text("密码");
		
		TextField acountField=new TextField();
		PasswordField psField=new PasswordField();
		
		Button login=new Button();
		Button signin=new Button();
		login.setText("注册");
		signin.setText("登入");
		HBox hbOfLogSign=new HBox();
		hbOfLogSign.setSpacing(10);
		hbOfLogSign.setAlignment(Pos.BOTTOM_RIGHT);
		hbOfLogSign.getChildren().addAll(signin,login);
		
		grid.add(account, 0, 0);
		grid.add(password, 0, 2);
		grid.add(acountField,1,0);
		grid.add(psField, 1, 2);
		grid.add(hbOfLogSign,1, 3);
		
		login.setOnAction(e->{
			System.out.print("zero");
			
		});
			
		
		
		
		Scene scene=new Scene(grid);
		
		window.setScene(scene);
		
		window.setTitle("用户登录");
		
		window.show();
		
		
	}
	
	public boolean loginEvent(){
		LoginController loginController=new LoginControllerImp();
		return loginController.isFound("1000", "abcd");
	}
	public static void main(String[] args){
		launch(args);
	}
	

}
