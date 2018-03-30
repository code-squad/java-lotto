package lotto;

import lotto.domain.LottoProcess;
import lotto.view.Input;
import lotto.view.Print;
public class Main {
	public static void main(String[] args) {
		int price = Input.inputPrice();
		int sheets = Print.checkSheets(price);
		int userSheets = Input.inputUserBuy();

		LottoProcess lottos = LottoProcess.of(sheets - userSheets, Input.checkUserSheets(userSheets));
		Print.printLottoNum(userSheets, Print.checkSheets(price), lottos);
		Print.printWinResult(price, lottos, Input.inputBeforWinNum());
	}
}
