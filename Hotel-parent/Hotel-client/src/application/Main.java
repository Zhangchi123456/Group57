package application;



import java.io.InputStream;



import org.Hotel.common.dataService.HotelDataService;
import presentation.presentationController.RMIConnection;
import BusinessLogicService.impl.RMIHelper;
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
import Helper.UiswitchHelper;

public class Main extends Application {
	 private Stage mainStage;
		public static void main(String args[]){
			launch(args);
		}
		@Override
		public void start(Stage primaryStage) throws Exception {
			init(primaryStage);
			primaryStage.show();
			
		}
		
		//stage鐨勫垵濮嬪寲
	    public void init(Stage stage){
	    	this.mainStage=stage;
	    //	RMIHelper.init();
	    //	new RMIConnection();
	    	UiswitchHelper.setApplication(this);
	    	goto_Loginui();
	    }
	    
	    
	    //鍒囨崲绐楀彛鐨勪竴涓疄鐜版柟娉曪紝鐢╢xmlloader鍔犺浇fxml鏂囦欢璺緞鍐嶈繘琛岃烦杞�
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
			mainStage.centerOnScreen();
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    
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
			mainStage.centerOnScreen();
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
	    
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
			mainStage.centerOnScreen();
			Scene scene = new Scene(page);
			mainStage.setScene(scene);
			mainStage.sizeToScene();


			return (Initializable) loader.getController();
		}
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
	    
	    //璺宠浆鍒扮櫥褰曠晫闈�
	    public void goto_Loginui(){
	    	try {
				replaceSceneContent("/presentation/userui/Login.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //璺宠浆鍒版敞鍐岀晫闈�
	    public void goto_Registerui(){
	    	try {
				replaceSceneContent("/presentation/userui/Registerui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //浠ヤ笅鏄鎴锋祦绋嬬殑璺宠浆鐣岄潰鏂规硶
	    
	    //璺宠浆鍒扮敤鎴蜂富鐣岄潰
	    public void goto_Usermainui(){
	    	try {
				replaceSceneContent("/presentation/userui/Usermainui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	   
	   //璺宠浆鍒扮敤鎴蜂釜浜轰俊鎭晫闈� 
	    public void goto_Userinformationui(){
	    	try {
				replaceSceneContent("/presentation/userui/Userinformationui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //璺宠浆鍒扮敤鎴蜂俊鐢ㄨ褰曠晫闈�
	    public void goto_Usercreditrecordui(){
	    	try {
				replaceSceneContent("/presentation/userui/Usercreditrecordui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //鐢ㄦ埛鐐规悳绱互鍚庤烦杞埌閰掑簵鍒楄〃鐣岄潰
	    public void goto_HotelListui(){
	    	try {
				replaceSceneContent("/presentation/hotelui/HotelListui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //鐢ㄦ埛鐐瑰嚮鈥滄垜鐨勮鍗曗�濇寜閽烦杞埌璁㈠崟鍒楄〃鐣岄潰
	    public void goto_OrderListUi(){
	    	try {
				replaceSceneContent("/presentation/orderui/OrderListUi.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    //鐢ㄦ埛鍦ㄩ厭搴楀垪琛ㄤ腑閫変腑閰掑簵鍚庤烦鍒拌閰掑簵鐨勪俊鎭〉闈�  搴忓彿1.0
	    public void goto_hotelInfoBrowseui(){
	    	try {
				GreplaceSceneContent("/presentation/hotelui/hotelInfoBrowseui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //鐢ㄦ埛鍦ㄩ厭搴楀叿浣撲俊鎭〉闈腑閫変腑鐢熸垚璁㈠崟鎸夐挳璺宠浆鍒扮敓鎴愯鍗曠晫闈� 1.0.1
	    public void goto_OrderinputUi(){
	    	try {
				replaceSceneContent("/presentation/orderui/Creatorderui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  //鐢ㄦ埛鍦ㄩ厭搴楀叿浣撲俊鎭〉闈腑閫変腑鏇惧畾閰掑簵鎸夐挳璺宠浆鍒版浘棰勫畾閰掑簵鐣岄潰 1.0.2
	    public void goto_reservationedhotelUi(){
	    	try {
					GreplaceSceneContent("/presentation/hotelui/MyhotelOrderui.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	  //鐢ㄦ埛璺冲埌纭璁㈠崟鐣岄潰 1.0.1.1
	    public void goto_confirmUi(){
	    	try {
					replaceSceneContent("/presentation/orderui/OrderInfo.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //鐢ㄦ埛鎯冲宸叉墽琛岃鍗曡繘琛岃瘎浠锋椂璺宠浆鍒拌瘎浠风晫闈�
	    public void goto_OrderEvaluateui(){
	    	try {
				replaceSceneContent("/presentation/orderui/OrderEvaluate.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //浠ヤ笅鏄綉绔欑鐞嗕汉鍛樿繘琛岀晫闈㈣烦杞殑鏂规硶
	    
	    //璺宠浆鑷崇綉绔欑鐞嗕汉鍛樹富鐣岄潰 num2.0
	    public void goto_UserWebManagementui(){
	    	try {
				AreplaceSceneContent("/presentation/userui/UserWebManagement.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //浠庣鐞嗕汉鍛樹富鐣岄潰璺宠浆鑷抽厭搴楀伐浣滀汉鍛樼鐞嗙晫闈� num2.0.1
	    public  void goto_UserWebManagementHotelui(){
	    	try {
				AreplaceSceneContent("/presentation/userui/UserWebManagementHotel.fxml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //浠庣鐞嗕汉鍛樹富鐣岄潰璺宠浆鍒扮綉绔欒惀閿�浜哄憳绠＄悊鐣岄潰  num2.0.2
	    
	     public void goto_UserWebManagermentWebui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebManagementWeb.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //缃戠珯钀ラ攢浜哄憳绠＄悊鐣岄潰璺宠浆鍒版坊鍔犵綉绔欒惀閿�浜哄憳鐣岄潰num2.0.2.1
	     public void goto_AddWebStuffui(){
	    	 try {
					VreplaceSceneContent("/presentation/userui/AddWebStuff.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	    //浠庣鐞嗕汉鍛樹富鐣岄潰璺宠浆鍒版坊鍔犻厭搴楅〉闈�   num2.0.3
	     public void goto_UserWebAddHotelui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebAddHotel.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庣鐞嗕汉鍛樹富鐣岄潰璺宠浆鍒颁細鍛樼鐞嗙晫闈� num2.0.4(鐩稿綋浜庤烦鍥炵鐞嗕汉鍛樹富鐣岄潰锛�
	     
	     //浠庢坊鍔犻厭搴楅〉闈㈣烦杞埌娣诲姞鎴块棿椤甸潰 num2.0.3.1
	     public void goto_UserWebAddRoomui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebAddRoom.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	      
	     //浠庢坊鍔犻厭搴楅〉闈㈣烦杞埌娣诲姞绠�浠嬮〉闈� num2.0.3.2
	     public void goto_UserWebAddDescriptionui(){
	    	 try {
					AreplaceSceneContent("/presentation/userui/UserWebAddDescription.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	    //浠庢坊鍔犻厭搴楅〉闈㈣烦杞埌娣诲姞閰掑簵浜哄憳椤甸潰 num2.0.3.3
	     public void goto_AddHotelStuffui(){
	    	 try {
					VreplaceSceneContent("/presentation/userui/AddHotelStuff.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     //浠ヤ笅鏄厭搴楀伐浣滀汉鍛樼櫥褰曚箣鍚庣殑鐣岄潰璺宠浆
	     
	     //璺宠浆鍒伴厭搴楀伐浣滀汉鍛樹富鐣岄潰  num3.0
	     public void goto_HotelMainui(){
	    	 try {
					replaceSceneContent("/presentation/hotelui/HotelmanagerMain.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒板鎴垮垪琛ㄧ晫闈� num3.0.1 
	     public void goto_roomInfoui(){
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/roomInfoui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒拌鍗曞垪琛ㄧ晫闈� num3.0.2 
	     public void goto_orderui(){
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/orderui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	    //浠庤鍗曞垪琛ㄧ晫闈㈣烦杞埌璁㈠崟璇︾粏淇℃伅鐣岄潰 num3.0.2.1
	     public void goto_ordeinfoui(){
	    	 try {
					GreplaceSceneContent("/presentation/hotelui/orderinfoui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒板叆浣忎俊鎭洿鏂扮晫闈� num3.0.3
	     public void goto_updateui(){
	    	 try {
					 GreplaceSceneContent("/presentation/hotelui/updateui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒伴厭搴椾俊鎭淮鎶ょ晫闈� num3.0.4
	     public void goto_hotelInfoui(){
	    	 try {
					replaceSceneContent("/presentation/hotelui/hotelInfoui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒伴厭搴楄惀閿�绛栫暐鍒跺畾鐣岄潰(鐗瑰畾鏃ユ湡锛� num3.0.5.1
	     public void goto_hoteldiscountdateui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/hoteldiscountdateui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒伴厭搴楄惀閿�绛栫暐鍒跺畾鐣岄潰(浼氬憳鐢熸棩锛� num3.0.5.2
	     public void goto_birthdayui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/birthdayui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	   //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒伴厭搴楄惀閿�绛栫暐鍒跺畾鐣岄潰(鍟嗕笟鍚堜綔鎶樻墸锛� num3.0.5.3
	     public void goto_businesspartnerui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/businesspartnerui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庨厭搴楀伐浣滀汉鍛樹富鐣岄潰璺宠浆鍒伴厭搴楄惀閿�绛栫暐鍒跺畾鐣岄潰(涓夐棿浠ヤ笂鎶樻墸锛� num3.0.5.4
	     public void goto_roomnumberui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/roomnumberui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     
	   
	     
	     //浠ヤ笅鏄綉绔欒惀閿�浜哄憳杩涜鐣岄潰璺宠浆鐨勮烦杞柟娉�
	     
	      //璺宠浆鍒扮綉绔欒惀閿�浜哄憳涓荤晫闈� num4.0
	     public void goto_UserWebPromotionMainui(){
	    	 try {
					PreplaceSceneContent("/presentation/userui/UserWebPromotionMainui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     
	     //浠庣綉绔欒惀閿�浜哄憳涓荤晫闈㈣烦杞埌缃戠珯淇冮攢绛栫暐(鐗瑰畾鏈熼棿鎶樻墸锛夌晫闈� num4.0.1
	     public void goto_webdiscoutdatenui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/webdiscountdateui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庣綉绔欒惀閿�浜哄憳涓荤晫闈㈣烦杞埌缃戠珯淇冮攢绛栫暐(鐗瑰畾鍟嗗湀鎶樻墸锛夌晫闈� num4.0.2
	     public void goto_businesscircleui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/businesscircleui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庣綉绔欒惀閿�浜哄憳涓荤晫闈㈣烦杞埌缃戠珯淇冮攢绛栫暐(浼氬憳绛夌骇鎶樻墸锛夌晫闈� num4.0.3
	     public void goto_memberlevelui(){
	    	 try {
					PreplaceSceneContent("/presentation/promotionui/memberlevelui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     //浠庣綉绔欒惀閿�浜哄憳涓荤晫闈㈣烦杞埌淇＄敤鍏呭�肩晫闈� num4.0.4
	     public void goto_Creditchargeui(){
	    	 try {
					replaceSceneContent("/presentation/userui/Creditchargeui.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     //浠庣綉绔欒惀閿�浜哄憳涓荤晫闈㈣烦杞埌寮傚父璁㈠崟鍒楄〃鐣岄潰 num4.0.5
	     public void goto_abnormalorderui(){
	    	 try {
					PreplaceSceneContent("/presentation/orderui/abnormalorder.fxml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	     
	     
	     
	     
	     
	     
	     
}
