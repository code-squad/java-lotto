package lotto;

import java.util.ArrayList;

public class Money {
	private int won = 0;
	private final int price = 1000;		//로또의 가격
	
	private static final int MATCH3_MONEY = 5000;		//X개 맞았을 때의 상금을 상수값으로 지정.
	private static final int MATCH4_MONEY = 50000;
	private static final int MATCH5_MONEY = 1500000;
	private static final int MATCH6_MONEY = 2000000000;
	
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
		System.out.println("거스름돈 " + (this.won % this.price) + " 원을 돌려 드리겠습니다.");
		
		this.won = this.won - (this.won % this.price);
		
		System.out.println("로또 구입 금액은 " + (this.won) + " 원 입니다.");
	}
	//입금된 가격만큼 산 티켓의 갯수를 반환해주는 메소드.
	public int buyLotto() {
		return (this.won / this.price);
	}
	//맞은 갯수 비례 금액을 계산하여 총 딴 돈을 구한다. (내가 건 돈 만큼은 뺀다.)
	public static void calculateMoney(ArrayList<Integer> result, int money) {
		int earnMoney = (result.get(0) * MATCH3_MONEY) + (result.get(1) * MATCH4_MONEY)
						+ (result.get(2) * MATCH5_MONEY) + (result.get(3) * MATCH6_MONEY) - money;
		int yield = (earnMoney / money) * 100;		//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		
		ResultView.printResult(result, yield);		//결과를 출력해준다.
	}
}
