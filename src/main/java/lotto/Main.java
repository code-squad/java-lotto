package lotto;

import lotto.domain.LottoProcess;
import lotto.view.Input;
import lotto.view.Print;

public class Main {
	public static void main(String[] args) {
		int price = Input.InputPrice();
		LottoProcess lottos = Print.printLottoNum(Print.checkSheets(price));
		Print.printWinResult(price, lottos, Input.inputBeforWinNum());
	}
}
