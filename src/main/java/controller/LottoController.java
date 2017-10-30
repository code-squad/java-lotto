package controller;

import java.util.Scanner;

import model.Lottos;
import model.Money;
import model.WinningLotto;
import view.InputView;
import view.ResultView;

public class LottoController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputView input = new InputView(scanner);
		ResultView print = new ResultView();
		LottoController controller = new LottoController();
		WinningLotto winningLotto = new WinningLotto();
		Money money = new Money();
		Lottos lottos = new Lottos();
		
		input.getMoney(money);
		print.num(money.coutTicket());
		
		if(input.chooseType().trim().equals("자동")) {
			lottos.makeLottos(money.coutTicket());
			print.lottery(lottos);
		}else {
			lottos.makeManualLottos(money.coutTicket(), input.getLottoNumbers(money));
		}
		if(input.getCommand().equals("lottery")){
			winningLotto.makeLotto();
			print.winningNumber(winningLotto);
		}
		
		lottos.checkLottos(winningLotto);
		lottos.statistic(winningLotto.getBonus());
		print.statistic(lottos);
		print.earningRate(lottos.earningRate(money.getMoney()));
		
		scanner.close();
	}
}
