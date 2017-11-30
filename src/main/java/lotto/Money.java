package lotto;

import java.util.ArrayList;

public class Money {
	//거스름돈을 계산하여 반환해주는 메소드.
	public static int giveChange(int money) {
		ResultView.giveChangeMsg(money, money % 1000);
		return (money - (money % 1000));
	}
	//입금된 가격만큼 산 티켓의 갯수를 반환해주는 메소드.
	public static int buyLotto(int money) {
		return (money / 1000);
	}
	//맞은 갯수 비례 금액을 계산하여 총 딴 돈을 구한다. (내가 건 돈 만큼은 뺀다.)
	public static void calculateMoney(ArrayList<Integer> result, int money) {
		int earnMoney = (result.get(0) * 5000) + (result.get(1) * 50000) + (result.get(2) * 1500000) + (result.get(3) * 2000000000) - money;
		int yield = (earnMoney / money) * 100;		//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		
		ResultView.printResult(result, yield);		//결과를 출력해준다.
	}
}
