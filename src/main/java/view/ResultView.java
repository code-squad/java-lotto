package view;

import model.Lotto;
import model.Lottos;
import model.Money;
import model.WinningLotto;

public class ResultView {
//뷰에 모델인 Lottos를 파라미터로 넘겨주는 게 맞는 건지 컨트롤러에서 결과값만 넘겨줘야하는지...
	public void num(int num) {
		System.out.print(num + "개를 구매했습니다.");
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
	
/*	public void statistic(Lottos lottos) {
		System.out.println("당첨 통계");
		System.out.println("-----------");
		System.out.println("3개 일치(5000원)- " + lottos.statistic(3) + "개");
		System.out.println("4개 일치(50000원)- " + lottos.statistic(4) + "개");
		System.out.println("5개 일치(1500000원)- " + lottos.statistic(5) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottos.statistic(5) + "개");
		System.out.println("6개 일치(2000000000원)- " + lottos.statistic(6) + "개");
	}
*/	public void statistic(Lottos lottos) {
		System.out.println("당첨 통계");
		System.out.println("-----------");
		System.out.println("3개 일치(5000원)- " + lottos.getRankCount("fifth") + "개");
		System.out.println("4개 일치(50000원)- " + lottos.getRankCount("fourth") + "개");
		System.out.println("5개 일치(1500000원)- " + lottos.getRankCount("third") + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottos.getRankCount("second") + "개");
		System.out.println("6개 일치(2000000000원)- " + lottos.getRankCount("first") + "개");
	}
	
	public void earningRate(double earningRate) {
		System.out.println("총 수익률은 " + earningRate + "%입니다." );
		
	}
}
