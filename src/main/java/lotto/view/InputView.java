package lotto.view;

import java.util.Scanner;

import lotto.model.Lottos;

public class InputView {
	private void printLottos(Lottos lottos) {
		for (int i = 0; i < lottos.size(); i++) {
			System.out.println("[" + lottos.getString(i) + "]");
		}
		System.out.println();
	}

	public Lottos inputPrice() {
		Lottos purchaseLottos = new Lottos();

		System.out.println("구입금액을 입력해 주세요.");
		Scanner scan = new Scanner(System.in);
		purchaseLottos.purchasePrice(scan.nextInt());

		System.out.println(purchaseLottos.size() + "개를 구매했습니다.");
		printLottos(purchaseLottos);

		scan.close();
		System.out.println();

		return purchaseLottos;
	}
}
