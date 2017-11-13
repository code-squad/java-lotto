package view;

import model.Lotto;
import model.Lottos;
import model.Money;
import model.WinningLotto;

public class ResultView {

	public void num(int num) {
		System.out.println(num + "개를 구매했습니다.");
	}
	
	public void lottery(Lottos lottos) {
		for (Lotto lotto : lottos.getLottos()) {
			System.out.println(lotto.getList());
		}
	}

	public void winningNumber(WinningLotto winningLotto) {
		System.out.print(winningLotto.getList());
		System.out.println(" 보너스 번호: " + winningLotto.getBonus());
	}
	
	public void statistic(Lottos lottos) {
		System.out.println("당첨 통계");
		System.out.println("-----------");
		System.out.println("3개 일치(5000원)- " + lottos.getRankCount("FIFTH") + "개");
		System.out.println("4개 일치(50000원)- " + lottos.getRankCount("FOURTH") + "개");
		System.out.println("5개 일치(1500000원)- " + lottos.getRankCount("THIRD") + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottos.getRankCount("SECOND") + "개");
		System.out.println("6개 일치(2000000000원)- " + lottos.getRankCount("FIRST") + "개");
}

	public void earningRate(double earningRate) {
		System.out.println("총 수익률은 " + earningRate + "%입니다." );
		
	}
}
