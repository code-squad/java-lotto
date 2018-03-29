package lotto;

import lotto.domain.LottoProcess;
import lotto.view.Input;
import lotto.view.Print;

public class Main {
	public static void main(String[] args) {
		int price = Input.InputPrice();
		int sheets = Print.checkSheets(price);
		LottoProcess lottos = LottoProcess.of(sheets);
		Print.printLottoNum(Print.checkSheets(price), lottos);
		Print.printWinResult(price, lottos, Input.inputBeforWinNum());
	}
}
