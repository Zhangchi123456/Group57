package vo;

import org.Hotel.common.po.HotelPO;

public class HotelVO {
	private String name;
	private String circle;
	private int star;
	private double grade; 
	private String introduction;
	private String city;
	private String address;
	private int singleRoom;
	private int leftSingleRoom;
	private double singleRoomPrice;
	private int standardRoom;
	private int leftStandardRoom;
	private double standardRoomPrice;
	private int familyRoom;
	private int leftFamilyRoom;
	private double familyRoomPrice;
	private int suiteRoom;
	private int leftSuiteRoom;
	private double suiteRoomPrice;
	
	public HotelVO() {
	}
	
	public HotelVO(String name, String circle, 
			int star, double grade,
			String introduction,
			String city,String address,
			int singleRoom,int leftSingleRoom,
			int standardRoom,int leftStandardRoom,
			int familyRoom,int leftFamilyRoom,
			int suiteRoom,int leftSuiteRoom,
			double singleRoomPrice,double standardRoomPrice,
			double familyRoomPrice,double suiteRoomPrice){
		//hotel info
		this.name = name;				 
		this.circle = circle;				 
		this.star = star;			 
		this.grade = grade;		
		this.introduction=introduction;
		this.city=city;
		this.address=address;
		//room
		//room nums
		this.singleRoom = singleRoom;		
		this.standardRoom=standardRoom;
		this.familyRoom = familyRoom;		
		this.suiteRoom=suiteRoom;
		//left room nums
		this.leftSingleRoom=leftSingleRoom;
		this.leftStandardRoom=leftStandardRoom;
		this.leftFamilyRoom=leftFamilyRoom;
		this.leftSuiteRoom=leftSuiteRoom;
		//room price
		this.singleRoomPrice=singleRoomPrice;
		this.singleRoomPrice=singleRoomPrice;
		this.singleRoomPrice=singleRoomPrice;
		this.singleRoomPrice=singleRoomPrice;
	}

	public void setbuHotelPO(HotelPO po){
		this.address=po.getAddress();
		this.circle=po.getCircle();
		this.city=po.getCity();
		this.introduction=po.getIntroduction();
		this.familyRoom=po.getFamilyRoom();
		this.familyRoomPrice=po.getFamilyRoomPrice();
		this.grade=po.getGrade();
		this.leftFamilyRoom=po.getLeftFamilyRoom();
		this.leftSingleRoom=po.getLeftSingleRoom();
		this.leftStandardRoom=po.getLeftStandardRoom();
		this.leftSuiteRoom=po.getLeftSuiteRoom();
		this.name=po.getName();
		this.standardRoom=po.getStandardRoom();
		this.standardRoomPrice=po.getStandardRoomPrice();
		this.star=po.getStar();
		this.suiteRoom=po.getSuiteRoom();
		this.suiteRoomPrice=po.getSuiteRoomPrice();
		this.singleRoom=po.getSingleRoom();
		this.singleRoomPrice=po.getSingleRoomPrice();
		
	}
	
	public HotelPO Tohotelpo(HotelVO vo){
		HotelPO po=new HotelPO();
		po.setAdsress(address);
		po.setCircle(circle);
		po.setCity(city);
		po.setFamilyRoom(familyRoom);
		po.setFamilyRoomPrice(familyRoomPrice);
		po.setGrade(grade);
		po.setIntroduction(introduction);
		po.setLeftFamilyRoom(leftFamilyRoom);
		po.setLeftSingleRoom(leftSingleRoom);
		po.setLeftStandardRoom(leftStandardRoom);
		po.setLeftSuiteRoom(leftSuiteRoom);
		po.setName(name);
		po.setSingleRoom(singleRoom);
		po.setSingleRoomPrice(singleRoomPrice);
		po.setStandardRoom(standardRoom);
		po.setStandardRoomPrice(standardRoomPrice);
		po.setStar(star);
		po.setSuiteRoom(suiteRoom);
		po.setSuiteRoomPrice(suiteRoomPrice);
		
		return po;
	}
	//getters and setters
	public String getName() {
		return name;
	}

    public void setName(String name) {
		
		this.name = name;
	}
    
	public String getCircle() {
		
		return circle;
	}

	public void setCircle(String circle) {
		
		this.circle = circle;
	}
	
	
	public int getStar() {
		
		return star;
	}

	public void setStar(int star) {
		
		this.star = star;
	}
	
	public double getGrade() {
		
		return grade;
	}
	
	public void setGrade(double grade) {
		
		this.grade = grade;
	}
	
	public String getIntroduction() {
		
		return introduction;
	}

	public void setIntroduction(String introduction) {
		
		this.introduction = introduction;
	}
	
	public String getCity() {
			
		return city;
	}

	public void setCity(String city) {
			
		this.city = city;
	}
		
	public String getAddress() {
		
		return address;
	}

	public void setAdsress(String address) {
			
		this.address = address;
	}
				
    public int getSingleRoom() {
		
		return singleRoom;
	}

	public void setSingleRoom(int singleRoom) {
			
		this.singleRoom = singleRoom;
	}

	public int getStandardRoom() {
			
		return standardRoom;
	}

	public void setStandardRoom(int standardRoom) {
				
		this.standardRoom = standardRoom;
	}

	public int getLeftSingleRoom() {
		
		return leftSingleRoom;
	}

	public void setLeftSingleRoom(int leftSingleRoom) {
				
		this.leftSingleRoom = leftSingleRoom;
	}

	public int getLeftStandardRoom() {
		
		return leftStandardRoom;
	}

	public void setLeftStandardRoom(int leftStandardRoom) {
				
		this.leftStandardRoom = leftStandardRoom;
	}
	
	public int getFamilyRoom() {
		
		return familyRoom;
	}

	public void setFamilyRoom(int familyRoom) {
				
		this.familyRoom = familyRoom;
	}
	
    public int getLeftFamilyRoom() {
		
		return leftFamilyRoom;
	}

	public void setLeftFamilyRoom(int leftFamilyRoom) {
				
		this.leftFamilyRoom = leftFamilyRoom;
	}

	public int getSuiteRoom() {
		
		return suiteRoom;
	}

	public void setSuiteRoom(int suiteRoom) {
				
		this.suiteRoom = suiteRoom;
	}

	 public int getLeftSuiteRoom() {
			
		return leftSuiteRoom;
	}

	public void setLeftSuiteRoom(int leftSuiteRoom) {
					
		this.leftSuiteRoom = leftSuiteRoom;
	}
	
	public double getSingleRoomPrice() {
			
		return singleRoomPrice;
	}

	public void setSingleRoomPrice(int singleRoomPrice) {
				
		this.singleRoomPrice = singleRoomPrice;
	}

	public double getStandardRoomPrice() {
				
		return standardRoomPrice;
	}

	public void setStandardRoomPrice(int standardRoomPrice) {
					
		this.standardRoomPrice = standardRoomPrice;
	}
	
	public double getFamilyRoomPrice() {
		
		return familyRoomPrice;
	}

	public void setFamilyRoomPrice(int familyRoomPrice) {
				
		this.familyRoomPrice = familyRoomPrice;
	}

	public double getSuiteRoomPrice() {
				
		return suiteRoomPrice;
	}

	public void setSuiteRoomPrice(int suiteRoomPrice) {
					
		this.suiteRoomPrice = suiteRoomPrice;
	}
}
