package application;
import java.io.InputStream;
import presentation.presentationController.RMIConnection;
import presentation.userui.ComfirmBox;
import BusinessLogicService.Service.LogoutLogicService;
import BusinessLogicService.impl.RMIHelper;
import BusinessLogicService.impl.UserLogicServiceImpl;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	 private Stage mainStage;
		public static void main(String args[]){
			launch(args);
		}
		@Override
		public void start(Stage primaryStage) throws Exception {
			init(primaryStage);
			
			mainStage.setOnCloseRequest(e-> {
				e.consume();
				boolean result=ComfirmBox.display("是否退出？");
				if(result){
					//log out current user if has login
					try {
			    		if(LoginHelper.getLogVO()!=null){
			    			LogoutLogicService logout=new UserLogicServiceImpl();
			    			logout.removeCurrentUser(LoginHelper.getLogVO().getUsername());
			    		}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainStage.close();
				}
			});
			primaryStage.show();
		}
		
		//stage的初始化
	    public void init(Stage stage){
	    	this.mainStage=stage;
	    	RMIHelper.init();
	    	new RMIConnection();
	    	UiswitchHelper.setApplication(this);
	    	goto_Loginui();
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
			mainStage.setX(140);
			mainStage.setY(50);
			mainStage.setTitle("ORHS酒店管理系统");
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    
	    //切换窗口的一个实现方法，用fxmlloader加载fxml文件路径再进行跳转（针对anchorpane的方法）
	    private Initializable AreplaceSceneContent(String fxml) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			InputStream in = Main.class.getResourceAsStream(fxml);
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setLocation(Main.class.getResource(fxml));
			
			AnchorPane page;
			try {
				page = (AnchorPane) loader.load(in);
			}finally {
				in.close();
			} 
			mainStage.setX(140);
			mainStage.setY(50);
			mainStage.setTitle("ORHS酒店管理系统");
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    //切换窗口的一个实现方法，用fxmlloader加载fxml文件路径再进行跳转（针对gridpane的方法）
	    private Initializable GreplaceSceneContent(String fxml) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			InputStream in = Main.class.getResourceAsStream(fxml);
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setLocation(Main.class.getResource(fxml));
			
			GridPane page;
			try {
				page = (GridPane) loader.load(in);
			}finally {
				in.close();
			} 
			mainStage.setX(140);
			mainStage.setY(50);
			mainStage.setTitle("ORHS酒店管理系统");
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    //切换窗口的一个实现方法，用fxmlloader加载fxml文件路径再进行跳转（针对pane的方法）
	    private Initializable PreplaceSceneContent(String fxml) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			InputStream in = Main.class.getResourceAsStream(fxml);
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setLocation(Main.class.getResource(fxml));
			
			Pane page;
			try {
				page = (Pane) loader.load(in);
			}finally {
				in.close();
			} 
			mainStage.setX(140);
			mainStage.setY(50);
			mainStage.setTitle("ORHS酒店管理系统");
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    //切换窗口的一个实现方法，用fxmlloader加载fxml文件路径再进行跳转（针对vbox的方法）
	    private Initializable VreplaceSceneContent(String fxml) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			InputStream in = Main.class.getResourceAsStream(fxml);
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setLocation(Main.class.getResource(fxml));
			
			VBox page;
			try {
				page = (VBox) loader.load(in);
			}finally {
				in.close();
			} 
			mainStage.centerOnScreen();
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    
	  //跳转到登录界面
	    public void goto_Loginui(){
	    	try {
	    		if(LoginHelper.getLogVO()!=null){
	    			LogoutLogicService logout=new UserLogicServiceImpl();
	    			logout.removeCurrentUser(LoginHelper.getLogVO().getUsername());
	    		}
				replaceSceneContent("/presentation/userui/Login.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //跳转到注册界面
	    public void goto_Registerui(){
	    	try {
				replaceSceneContent("/presentation/userui/Registerui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
        //以下是客户流程的跳转界面方法
	    
	    //跳转到用户主界面
	    public void goto_Usermainui(){
	    	try {
				replaceSceneContent("/presentation/userui/Usermainui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	   
	  //跳转到用户个人信息界面 
	    public void goto_Userinformationui(){
	    	try {
				replaceSceneContent("/presentation/userui/Userinformationui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //跳转到用户信用记录界面
	    public void goto_Usercreditrecordui(){
	    	try {
				replaceSceneContent("/presentation/userui/Usercreditrecordui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //用户点搜索以后跳转到酒店列表界面
	    public void goto_HotelListui(){
	    	try {
				replaceSceneContent("/presentation/hotelui/HotelListui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //用户点击“我的订单”按钮跳转到订单列表界面
	    public void goto_OrderListUi(){
	    	try {
				replaceSceneContent("/presentation/orderui/OrderListUi.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	  //用户在酒店列表中选中酒店后跳到该酒店的信息页面  序号1.0
	    public void goto_hotelInfoBrowseui(){
	    	try {
				GreplaceSceneContent("/presentation/hotelui/hotelInfoBrowseui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	  //用户在酒店具体信息页面中选中生成订单按钮跳转到生成订单界面 1.0.1
	    public void goto_OrderinputUi(){
	    	try {
				replaceSceneContent("/presentation/orderui/Creatorderui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //用户在酒店具体信息页面中选中曾定酒店按钮跳转到曾预定酒店界面 1.0.2
	    public void goto_reservationedhotelUi(){
	    	try {
					GreplaceSceneContent("/presentation/hotelui/MyhotelOrderui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	  //用户跳到确认订单界面 1.0.1.1
	    public void goto_confirmUi(){
	    	try {
					replaceSceneContent("/presentation/orderui/OrderInfo.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //用户想对已执行订单进行评价时跳转到评价界面
	    public void goto_OrderEvaluateui(){
	    	try {
				replaceSceneContent("/presentation/orderui/OrderEvaluate.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
        //以下是网站管理人员进行界面跳转的方法
	    
	    //跳转至网站管理人员主界面 num2.0

	    public void goto_UserWebManagementui(){
	    	try {
				AreplaceSceneContent("/presentation/userui/UserWebManagement.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	  //从管理人员主界面跳转至酒店工作人员管理界面 num2.0.1
	    public  void goto_UserWebManagementHotelui(){
	    	try {
				AreplaceSceneContent("/presentation/userui/UserWebManagementHotel.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //从管理人员主界面跳转到网站营销人员管理界面  num2.0.2
	    
	     public void goto_UserWebManagermentWebui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebManagementWeb.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //网站营销人员管理界面跳转到添加网站营销人员界面num2.0.2.1
	     public void goto_AddWebStuffui(){
	    	 try {
					VreplaceSceneContent("/presentation/userui/AddWebStuff.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从管理人员主界面跳转到添加酒店页面   num2.0.3
	     public void goto_UserWebAddHotelui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebAddHotel.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
          //从管理人员主界面跳转到会员管理界面 num2.0.4(相当于跳回管理人员主界面）
	     
	     //从添加酒店页面跳转到添加房间页面 num2.0.3.1
	     public void goto_UserWebAddRoomui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebAddRoom.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	      
	     //从添加酒店页面跳转到添加简介页面 num2.0.3.2
	     public void goto_UserWebAddDescriptionui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebAddDescription.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	   //从添加酒店页面跳转到添加酒店人员页面 num2.0.3.3
	     public void goto_AddHotelStuffui(){
	    	 try {
					VreplaceSceneContent("/presentation/userui/AddHotelStuff.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
         //以下是酒店工作人员登录之后的界面跳转
	     
	     //跳转到酒店工作人员主界面  num3.0
	     public void goto_HotelMainui(){
	    	 try {
					replaceSceneContent("/presentation/hotelui/HotelmanagerMain.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从酒店工作人员主界面跳转到客房列表界面 num3.0.1 
	     public void goto_roomInfoui(){
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/roomInfoui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	   //从酒店工作人员主界面跳转到订单列表界面 num3.0.2 
	     public void goto_orderui(){
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/orderui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	   //从订单列表界面跳转到订单详细信息界面 num3.0.2.1
	     public void goto_ordeinfoui(){
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/orderinfoui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	   //从酒店工作人员主界面跳转到入住信息更新界面 num3.0.3
	     public void goto_updateui(){
	    	 try {
					 GreplaceSceneContent("/presentation/hotelui/updateui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	   //从酒店工作人员主界面跳转到酒店信息维护界面 num3.0.4
	     public void goto_hotelInfoui(){
	    	 try {
					replaceSceneContent("/presentation/hotelui/hotelInfoui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从酒店工作人员主界面跳转到酒店营销策略制定界面(特定日期） num3.0.5.1
	     public void goto_hoteldiscountdateui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/hoteldiscountdateui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     //从酒店工作人员主界面跳转到酒店营销策略制定界面(会员生日） num3.0.5.2
	     public void goto_birthdayui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/birthdayui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从酒店工作人员主界面跳转到酒店营销策略制定界面(商业合作折扣） num3.0.5.3
	     public void goto_businesspartnerui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/businesspartnerui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从酒店工作人员主界面跳转到酒店营销策略制定界面(三间以上折扣） num3.0.5.4
	     public void goto_roomnumberui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/roomnumberui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从酒店工作人员主界面跳转到录入可用客房界面  num3.0.5.5
	     public void goto_HotelRoomEntryui() {
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/HotelRoomEntryui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	     
	     
	     
	   
	     
	     //以下是网站营销人员进行界面跳转的跳转方法
	     
	      //跳转到网站营销人员主界面 num4.0
	     public void goto_UserWebPromotionMainui(){
	    	 try {
					PreplaceSceneContent("/presentation/userui/UserWebPromotionMainui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     
	     //从网站营销人员主界面跳转到网站促销策略(特定期间折扣）界面 num4.0.1
	     public void goto_webdiscoutdatenui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/webdiscountdateui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从网站营销人员主界面跳转到网站促销策略(特定商圈折扣）界面 num4.0.2
	     public void goto_businesscircleui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/businesscircleui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	   //从网站营销人员主界面跳转到网站促销策略(会员等级折扣）界面 num4.0.3
	     public void goto_memberlevelui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/memberlevelui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //从网站营销人员主界面跳转到信用充值界面 num4.0.4
	     public void goto_Creditchargeui(){
	    	 try {
					replaceSceneContent("/presentation/userui/Creditchargeui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     //从网站营销人员主界面跳转到异常订单列表界面 num4.0.5
	     public void goto_abnormalorderui(){
	    	 try {
					PreplaceSceneContent("/presentation/orderui/abnormalorder.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	      //跳转到查看优惠界面
	     public void goto_benefitui(){
	    	 try {
					replaceSceneContent("/presentation/hotelui/Benefit.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
		
	     
	     
	     
	     
	     
}
