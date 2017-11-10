package model;

public enum Prize {
	FIFTH(3, 5000),
	FOURTH(4, 50000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),
	FIRST(6, 2000000000),
	ZERO(0, 0);
	
	private int matchNum;
	private int price;
	
	Prize(int matchNum, int price) {
		this.matchNum = matchNum;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	 public static Prize valueOf(int matchNum, boolean bonus) {
		 if(matchNum == 5 && bonus) {
			 return Prize.SECOND;
		 }
		 
		 for(Prize prize : Prize.values()){
			 if(prize.matchNum == matchNum) {
				return prize; 
			 }
		 }
		 return Prize.ZERO;
	 }
}
