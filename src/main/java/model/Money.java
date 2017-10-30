package model;

public class Money {

	private int money = 0;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int coutTicket() {
		return money / 1000;
	}
}
