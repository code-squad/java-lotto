package lotto;

public class Money {
	private static final int price = 1000;		//로또의 가격
	
	private int won = 0;
	
	//생성자.
	public Money(int won) {
		this.won = won - (won % price);		//1000원 이하의 돈은 버림.
	}
	//가진 돈을 반환해주는 메소드.
	public int getPrice() {
		return this.won;
	}
	//입금된 가격만큼 산 티켓의 갯수를 반환해주는 메소드.
	public int buyLotto() {
		return (this.won / price);
	}
}
