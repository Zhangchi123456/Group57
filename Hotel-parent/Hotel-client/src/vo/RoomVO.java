package vo;

import org.Hotel.common.po.RoomPO;

public class RoomVO {

	private String hotelid;
	
	private String roomtype;
	
	private int roomid;
	
	public RoomVO() {
		
	}
	
	public RoomVO(String roomtype, int roomid, String hotelid) {
		super();
		
		this.roomtype = roomtype;
		
		this.roomid = roomid;
		
		this.hotelid =hotelid;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return roomid;
	}
	
	public void setId(int roomid) {
		
		this.roomid = roomid;
	}

	public String getRoomtype() {
		// TODO Auto-generated method stub
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		
		this.roomtype = roomtype;
	}
	
	public String getHotelid() {
		// TODO Auto-generated method stub
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		
		this.hotelid = hotelid;
	}

	public void setRoomPO(RoomPO roompo) {
		this.hotelid = roompo.getHotelid();
		this.roomid = roompo.getId();
		this.roomtype = roompo.getRoomtype();
		
	}
	
	public RoomPO ToRoomPO(){
		RoomPO po = new RoomPO();
		
		po.setHotelid(hotelid);
		po.setId(roomid);
		po.setRoomtype(roomtype);
		
		return po;
	}

}
