package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class BenefitController implements Initializable{
     @FXML
     private Label hotel1,hotel2,hotel3,hotel4,hotel5,web1,web2,web3;
     //            持有优惠策略label
     @FXML
     private void ReturnClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
     }
     //初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<WebPromotionVO> weblist=ReservationController.getWebPromotionvolist();//得到网站营销策略列表
		ArrayList<HotelPromotionVO> hotelprolist=ReservationController.getHotelprolist();//得到酒店营销策略列表
		for(int i=0;i<hotelprolist.size();i++){
			HotelPromotionVO hotelprovo=hotelprolist.get(i);
			switch(hotelprovo.getName()){
			case"日期折扣":
				String enddate;
				if(hotelprovo.getEndDate()==null){
					enddate="";
				}else{
					enddate=String.valueOf(hotelprovo.getEndDate());
				}
			     if(hotel1.getText().isEmpty()){
			    	 hotel1.setText(hotelprovo.getName()+":          "+String.valueOf(hotelprovo.getStartDate())+"   to   "+enddate+"       "+String.valueOf(hotelprovo.getDateDiscount()*10)+"折");
			     }else{
			    	 hotel5.setText(hotelprovo.getName()+":          "+String.valueOf(hotelprovo.getStartDate())+"   to   "+enddate+"       "+String.valueOf(hotelprovo.getDateDiscount()*10)+"折");
			     }
				break;
			case"多间折扣":
				hotel2.setText("三间以上折扣:                                                         "+String.valueOf(hotelprovo.getMultiorderDiscount()*10)+"折");
				break;
			case"企业折扣":
				hotel3.setText(hotelprovo.getName()+":                                                                "+String.valueOf(hotelprovo.getEnterpriceDiscount()*10)+"折");
				break;
			case"生日折扣":
				hotel4.setText("生日折扣:                                                                "+String.valueOf(hotelprovo.getBirthdayDiscount()*10)+"折");
				break;
				
			}
		}
		
		for(int i=0;i<weblist.size();i++){
			WebPromotionVO webpro=weblist.get(i);
			
			if(web1.getText().isEmpty()){
				web1.setText(webpro.getStartDate()+"    to    "+webpro.getEndDate()+"  "+String.valueOf(webpro.getDateDiscount()*10)+"折");
			}else {
				web2.setText(webpro.getStartDate()+"    to     "+webpro.getEndDate()+"  "+String.valueOf(webpro.getDateDiscount()*10)+"折");
			}
		}
	}

}
