package lotto;

public class Money {
	private static final int price = 1000;		//로또의 가격
	
	private int won = 0;
	
	//생성자.
	public Money(int won) {
		this.won = won;
	}
	//가진 돈을 반환해주는 메소드.
	public int getPrice() {
		return this.won;
	}
	//거스름돈을 계산하여 반환해주는 메소드.
	public void giveChange() {
		System.out.println("거스름돈 " + (this.won % price) + " 원을 돌려 드리겠습니다.");
		
		this.won = this.won - (this.won % price);
		
		System.out.println("로또 구입 금액은 " + (this.won) + " 원 입니다.");
	}
	//입금된 가격만큼 산 티켓의 갯수를 반환해주는 메소드.
	public int buyLotto() {
		return (this.won / price);
	}
}
