package vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.Hotel.common.po.OrderPO;

public class OrderVO {
	private String id;
	
	private String name;
	
	private String hotelid;
	
	private String starttime;
	
	private String state;
	
	private String leavetime;
	
	private String price;
	
	private String dischargetime;
	
	private String lasttime;
	
	private String peoplenum;
	
	private String  havekids;
	
	private String singleRoom;
	
	private String standardRoom;
	
	private String familyRoom;
	
	private String suiteRoom;
	
	private String comment;
	
	private String grade;
	
    public OrderVO(){
    	super();
    }
	public OrderVO(String id, String name, String child, String hotelid, String intime, String outtime, String state, String price, String lasttime, String dischargetime,String peoplenum, String havekids, String singleRoom, String standardRoom, String familyRoom, String suiteRoom, String comment, String grade) {
		super();
		this.id = id;
		
		this.name = name;
			
		this.hotelid = hotelid;
		
		this.starttime = intime;
		
		this.leavetime = outtime;
		
		this.state = state;
		
		this.price = price;
		
		this.lasttime = lasttime;
		
		this.dischargetime = dischargetime;
		
		this.peoplenum = peoplenum;
		
		this.havekids = havekids;
		
		this.singleRoom = singleRoom;
		
		this.standardRoom = standardRoom;
		
		this.familyRoom = familyRoom;
		
		this.suiteRoom = suiteRoom;
		
		this.comment = comment;
		
		this.grade = grade;
	}
	
	//po转vo
	public void SetbyOrderPO(OrderPO po){
        this.id = String.valueOf(po.getId());
		
		this.name = po.getName();
		this.hotelid = po.getHotelid();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		  
		
		this.starttime = format.format(po.getStarttime());
		
		this.leavetime =format.format( po.getLeavetime());
		
		this.state = po.getState();
		
		this.price = String.valueOf( po.getPrice());
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-mm-dd hh:mm:ss ");
		if(po.getLasttime()!=null)
		this.lasttime = formatter.format((po.getLasttime()));
		if(po.getDischargetime()!=null)
		this.dischargetime = formatter.format(po.getDischargetime());
		
		this.peoplenum = String.valueOf(po.getPeoplenum());
		
		if(po.isHavekids()==false){
			this.havekids="无";
		}
		else{
			this.havekids="有";
		}
		
		this.singleRoom =String.valueOf( po.getSingleRoom());
		
		this.standardRoom = String.valueOf(po.getStandardRoom());
		
		this.familyRoom =String.valueOf( po.getFamilyRoom());
		
		this.suiteRoom =String.valueOf( po.getSuiteRoom());
		
		this.comment = String.valueOf(po.getComment());
		
		this.grade = String.valueOf(po.getGrade());
	}
	
	//vo转po
	public OrderPO toOrderPO(OrderVO vo){
		OrderPO po = new OrderPO();
		po.setId(Integer.parseInt(id));
		po.setComment(comment);
		System.out.println(vo.dischargetime);
		
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-mm-dd hh:mm:ss ");		  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   		    
		    java.sql.Date sdate = null; //初始化   	      		   		      
		    java.util.Date udate = sdf.parse(starttime);   
		    sdate = new java.sql.Date(udate.getTime()); 
		    po.setStarttime(sdate);
		    java.sql.Date sdate1 = null;
		    java.util.Date udate1 = sdf.parse(leavetime);   
		    sdate1 = new java.sql.Date(udate1.getTime()); 
		    po.setLeavetime(sdate1);
		    java.sql.Date sdate2 = null;
		    if(dischargetime!=null){
		    java.util.Date udate2 = formatter.parse(dischargetime);   
		    sdate2 = new java.sql.Date(udate1.getTime());}
		    po.setDischargetime(sdate2);
		    java.sql.Date sdate3 = null;
		    if(lasttime!=null){
		    java.util.Date udate3 = formatter.parse(lasttime);   
		    sdate3 = new java.sql.Date(udate1.getTime()); }
		    
		    po.setLasttime(sdate3);
		    
		    
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(havekids.equals("有")){
		po.setHavekids(true);
		}
		else{
			po.setHavekids(false);
		}
		po.setHotelid(hotelid);	
		po.setName(name);
		
		po.setFamilyRoom(Integer.parseInt(familyRoom));

		po.setPeoplenum(Integer.parseInt(peoplenum));
		po.setPrice(Double.parseDouble(price));
		po.setSingleRoom(Integer.parseInt(singleRoom));
		po.setStandardRoom(Integer.parseInt(standardRoom));
		po.setState(state);
		po.setSuiteRoom(Integer.parseInt(suiteRoom));
		po.setGrade(Double.parseDouble(grade));
		return po;
	}
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the child
	 */
	
	/**
	 * @param child the child to set
	 */

	/**
	 * @return the peoplenum
	 */
	public String getPeoplenum() {
		return peoplenum;
	}
	/**
	 * @param peoplenum the peoplenum to set
	 */
	public void setPeoplenum(String peoplenum) {
		this.peoplenum = peoplenum;
	}
	/**
	 * @return the havekids
	 */
	public String isHavekids() {
		return havekids;
	}
	/**
	 * @param havekids the havekids to set
	 */
	public void setHavekids(String havekids) {
		this.havekids = havekids;
	}
	/**
	 * @return the singleRoom
	 */
	public String getSingleRoom() {
		return singleRoom;
	}
	/**
	 * @param singleRoom the singleRoom to set
	 */
	public void setSingleRoom(String singleRoom) {
		this.singleRoom = singleRoom;
	}
	/**
	 * @return the standardRoom
	 */
	public String getStandardRoom() {
		return standardRoom;
	}
	/**
	 * @param standardRoom the standardRoom to set
	 */
	public void setStandardRoom(String standardRoom) {
		this.standardRoom = standardRoom;
	}
	/**
	 * @return the familyRoom
	 */
	public String getFamilyRoom() {
		return familyRoom;
	}
	/**
	 * @param familyRoom the familyRoom to set
	 */
	public void setFamilyRoom(String familyRoom) {
		this.familyRoom = familyRoom;
	}
	/**
	 * @return the suiteRoom
	 */
	public String getSuiteRoom() {
		return suiteRoom;
	}
	/**
	 * @param suiteRoom the suiteRoom to set
	 */
	public void setSuiteRoom(String suiteRoom) {
		this.suiteRoom = suiteRoom;
	}
	/**
	 * @param state the state to set
	 */
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(String id) {
		
		this.id = id;
	}

	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getHotelid() {
		
		return hotelid;
	}
	
	public void setHotelid(String hotelid) {
		
		this.hotelid = hotelid;
	}

    
    /**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the leavetime
	 */
	public String getLeavetime() {
		return leavetime;
	}

	/**
	 * @param leavetime the leavetime to set
	 */
	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	/**
	 * @return the lasttime
	 */
	public String getLasttime() {
		return lasttime;
	}

	/**
	 * @param lasttime the lasttime to set
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	/**
	 * @return the dischargetime
	 */
	public String getDischargetime() {
		return dischargetime;
	}

	/**
	 * @param dischargetime the dischargetime to set
	 */
	public void setDischargetime(String dischargetime) {
		this.dischargetime = dischargetime;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getState() {
    	
    	return state;
    }
   
    
    public void setState(String state) {
    	
    	this.state = state;
    }
    
    public String getPrice() {
    	
    	return price;
    }
    
    public void setPrice(String price) {
    	
    	this.price = price;
    }
    
}