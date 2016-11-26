package org.Hotel.client.presentation.main;

import java.io.InputStream;

import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	private Stage mainStage;
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
		
	}
	
	//stage的初始化
    public void init(Stage stage){
    	this.mainStage=stage;
    	goto_Usermainui();
    }
    
    
    //跳转到用户主界面
    public void goto_Usermainui(){
    	try {
			replaceSceneContent("/userui/Usermainui.fxml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //跳转到登录界面
    public void goto_Loginui(){
    	
    }
    
    
    //切换窗口的一个实现方法，用fxmlloader加载fxml文件路径再进行跳转
    private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = Main.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(Main.class.getResource(fxml));
		
		BorderPane page;
		try {
			page = (BorderPane) loader.load(in);
		}finally {
			in.close();
		} 
		mainStage.centerOnScreen();
		Scene scene = new Scene(page);
		mainStage.setScene(scene);
		mainStage.sizeToScene();


		return (Initializable) loader.getController();
	}
}
