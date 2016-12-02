package vo;

public class HotelVO {
         public int hotelid;
         public String hotelname;
         
         public HotelVO(int Hotelid,String Hotelname){
        	 this.hotelid=Hotelid;
        	 this.hotelname=Hotelname;
         }
         
         public int getHotelid(){
        	 return hotelid;
         }
         
         public String getHotelname(){
        	 return hotelname;
         }
}
