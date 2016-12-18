package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.CircleVO;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelInfo {
	//显示所有城市
	public ArrayList<String> showCitys();
	//显示城市里的所有商圈
	public ArrayList<String> showCircle(String city);
	//添加酒店
	public void addHotel(HotelVO vo);
	//是否是酒店
	public boolean isHotel(String name);
	//添加房间
	public void addRoom(RoomVO vo);
    //显示城市里的所有CircleVO
	ArrayList<CircleVO> getCircle(String city_name);
    //得到商圈
	CircleVO getCircle(String city_name, String circle);
    //更新商圈信息
	void updateCircle(CircleVO vo);
	//根据酒店名找到酒店
	public HotelVO findbyname(String name) throws RemoteException;
	//根据商圈找酒店
	public ArrayList<HotelVO> findbycircle(String circle) throws RemoteException;
}
