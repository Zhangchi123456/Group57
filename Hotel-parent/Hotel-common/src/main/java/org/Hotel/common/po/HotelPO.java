package org.Hotel.common.po;

import java.io.Serializable;

public class HotelPO implements Serializable{

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
	
	public HotelPO() {
	}
	
	public HotelPO(String name, String circle, 
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
		this.familyRoomPrice =familyRoomPrice;
		this.standardRoomPrice=standardRoomPrice;
		this.suiteRoomPrice=suiteRoomPrice;
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

	public void setSingleRoomPrice(double singleRoomPrice2) {
				
		this.singleRoomPrice = singleRoomPrice2;
	}

	public double getStandardRoomPrice() {
				
		return standardRoomPrice;
	}

	public void setStandardRoomPrice(double standardRoomPrice2) {
					
		this.standardRoomPrice = standardRoomPrice2;
	}
	
	public double getFamilyRoomPrice() {
		
		return familyRoomPrice;
	}

	public void setFamilyRoomPrice(double familyRoomPrice2) {
				
		this.familyRoomPrice = familyRoomPrice2;
	}

	public double getSuiteRoomPrice() {
				
		return suiteRoomPrice;
	}

	public void setSuiteRoomPrice(double suiteRoomPrice2) {
					
		this.suiteRoomPrice = suiteRoomPrice2;
	}
	
}
