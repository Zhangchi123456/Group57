package vo;

public class MemberLevelVO {
	
private int level;
	
	private int credit;
	
	private double discount;
	
	public MemberLevelVO(int level, int credit, double discount) {
		
		this.level = level;
		this.credit = credit;
		this.discount = discount;
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
