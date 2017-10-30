package view;

import model.Lotto;
import model.Lottos;
import model.WinningLotto;

public class ResultView {

	public void num() {
		System.out.print("개를 구매했습니다.");
	}
	
	public void lottery(Lottos lottos) {
		for (Lotto lotto : lottos.getLottos()) {
			System.out.println(lotto.getList());
		}
	}

	public void winningNumber(Lottos lottos) {
		System.out.print(lottos.getWinningNumber());
		System.out.print(" 보너스 번호: " + lottos.getBonus());
	}
	
	public void statistic(Lottos lottos) {
		System.out.println("당첨 통계");
		System.out.println("-----------");
		System.out.println("3개 일치(5000원)- " + lottos.statistic(3) + "개");
		System.out.println("4개 일치(50000원)- " + lottos.statistic(4) + "개");
		System.out.println("5개 일치(1500000원)- " + lottos.statistic(5) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottos.statistic(5) + "개");
		System.out.println("6개 일치(2000000000원)- " + lottos.statistic(6) + "개");
		System.out.println("총 수익률은 " + "입니다." );
	}
}
