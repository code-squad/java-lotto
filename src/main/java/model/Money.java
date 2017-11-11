package model;

public class Money {

	private static final int TICKET_PRICE = 1000;
	
	private int money = 0;
	
	public Money(int money){
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
//
//	public void setMoney(int money) {
//		this.money = money;
//	}
	
	public int coutTicket() {
		return money / TICKET_PRICE;
	}
}
