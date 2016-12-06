package vo;

import org.Hotel.common.po.MemberLevelPO;

public class MemberLevelVO {
	
private int level;
	
	private int credit;
	
	private double discount;
	
	public MemberLevelVO(int level, int credit, double discount) {
		
		this.level = level;
		this.credit = credit;
		this.discount = discount;
	}

	public void setByPO(MemberLevelPO po){
		this.level = po.getLevel();
		this.credit = po.getCredit();
		this.discount = po.getDiscount();
	}
	
	public MemberLevelPO toPO(){
		MemberLevelPO po = new MemberLevelPO();
		po.setLevel(level);
		po.setCredit(credit);
		po.setDiscount(discount);
		return po;
	}
	
	public int getLevel() {
		return level;
	}

	public int getCredit() {
		return credit;
	}

	
	public double getDiscount() {
		return discount;
	}

}
