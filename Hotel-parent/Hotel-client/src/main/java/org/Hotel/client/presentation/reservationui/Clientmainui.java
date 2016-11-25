package org.Hotel.client.presentation.reservationui;





import org.Hotel.client.presentation.orderui.OrderList;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*; 
import javafx.scene.shape.*;
import javafx.scene.text.Font;


public class Clientmainui extends Application {
     Stage reservatiostage;
	@Override
	public void start(final Stage reservationstage) throws Exception {
		BorderPane pane=new BorderPane();
		
		pane.setPrefSize(800, 600);
		VBox navigation =new VBox();
		navigation.setAlignment(Pos.TOP_LEFT);
		navigation.setPadding(new Insets(50, 20, 20, 50));
		navigation.setPrefSize(200, 400);
		
		pane.setLeft(navigation);
		HBox topline=new HBox();
		FlowPane centerpane=new FlowPane();
		pane.setCenter(centerpane);

		topline.setAlignment(Pos.TOP_CENTER);
		topline.setPrefSize(800, 120);
		topline.setPadding(new Insets(20, 30, 30, 10));
		
		pane.setTop(topline);
		
		Button button1=new Button("个人信息");
		Button button2=new Button("信用记录");
	    Button button3=new Button("我的订单");
	    Button button4=new Button("我的评价");
	    Button button5=new Button("搜索酒店");
	    button1.setFont(Font.font(20));
	    button2.setFont(Font.font(20));
	    button3.setFont(Font.font(20));
	    button4.setFont(Font.font(20));
	    button5.setFont(Font.font(20));
	    button1.setPrefSize(200, 50);
	    button2.setPrefSize(200, 50);
	    button3.setPrefSize(200, 50);
	    button4.setPrefSize(200, 50);
	    button5.setPrefSize(200, 50);
	    
	    
	    //监听事件
	   button1.setOnAction(new EventHandler<ActionEvent>(){
		   public void handle(ActionEvent event){
			   Clientinformationui informationui=new Clientinformationui();
				 try {
					informationui.start(reservationstage);
				} catch (Exception e) {
					// TODO Auto-generated catch bloc
					e.printStackTrace();
				}
		   }
	   });
	   button3.setOnAction(new EventHandler<ActionEvent>(){
		   public void handle(ActionEvent event){
			   OrderList Orderlist=new OrderList();
				 try {
					Orderlist.start(reservationstage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
	   });
	   
	   button2.setOnAction(new EventHandler<ActionEvent>(){
		   public void handle(ActionEvent event){
			   Clientcreditrecordui creditui=new Clientcreditrecordui();
				 try {
					creditui.start(reservationstage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
	   });
	    
	  
	   
	   button4.setOnAction(new EventHandler<ActionEvent>(){
		   public void handle(ActionEvent event){
			  
		   }
	   });
	   
	   button5.setOnAction(new EventHandler<ActionEvent>(){
		   public void handle(ActionEvent event){
			  
		   }
	   });
	   
	   
	    
	    
	    
	    
	    Label label1=new Label("欢迎您，会员");
	    topline.setAlignment(Pos.CENTER);
	    label1.setFont(Font.font(30));
	    
	    ChoiceBox procb = new ChoiceBox(FXCollections.observableArrayList(
	    	    "江苏","浙江")
	    	);
	    ChoiceBox shicb=new ChoiceBox(FXCollections.observableArrayList(
	    	    "南京","杭州")
	    	);
	    ChoiceBox businesscb=new ChoiceBox(FXCollections.observableArrayList(
	    	    "新街口","武林门")
	    	);
	    Label biaoyu=new Label("快速寻找您心仪的酒店：");
	    Label search=new Label("其他关键字：");
	    Label prol=new Label("省／直辖市：");
	    Label shil=new Label("市：");
	    Label businessl=new Label("商圈：");
	    TextField seartx=new TextField();
	    biaoyu.setFont(Font.font(25));
	    HBox h1=new HBox();
	    HBox h2=new HBox();
	    HBox h3=new HBox();
	    h1.getChildren().addAll(biaoyu);
	    h2.getChildren().addAll(prol,procb,shil,shicb,businessl,businesscb);
	    h2.setSpacing(10);
	    h3.getChildren().addAll(search,seartx);
	    Button searb=new Button("开始搜索");
	    
	    centerpane.getChildren().addAll(h1,h2,h3,searb);
	    centerpane.setVgap(40);
	    centerpane.setHgap(40);
	    centerpane.setPadding(new Insets(50, 50, 50, 50));
	    centerpane.setPrefSize(600, 400);
	    		
	    		
	    
	    
	    navigation.getChildren().addAll(button1,button2,button3,button4);
	    topline.getChildren().add(label1);
	    navigation.setSpacing(20);;
	    
	    Scene scnen = new Scene(pane);  
     
        reservationstage.setScene(scnen);  
	    reservationstage.show();  
		
	}
	public static void main(String[] args){  
        Application.launch(args);  
    }  
}
