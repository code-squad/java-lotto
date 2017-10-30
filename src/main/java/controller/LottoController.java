package controller;

import java.util.Scanner;

import model.LottoService;
import model.Lottos;
import model.Money;
import view.InputView;
import view.ResultView;

public class LottoController {

	private static LottoService service = null;
	
	public Lottos beginAuto(Money money) {
		return service.beginAuto(money.coutTicket());
	}

	public Lottos beginManual(Money money, InputView input) {
		return service.beginManual(money.coutTicket(), input.getLottoNumbers(money));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputView input = new InputView(scanner);
		ResultView print = new ResultView();
		LottoController controller = new LottoController();
		Money money = new Money();
		service = new LottoService();
		input.getMoney(money);
		Lottos lottos = null;
		if(input.chooseType().trim().equals("자동")) {
			lottos = controller.beginAuto(money);
			print.lottery(lottos);
		}else {
			lottos = controller.beginManual(money, input);
		}
		if(input.getCommand().equals("lottery")){
			service.makeWinningLotto();
			print.winningNumber(lottos);
		}
		service.checkLottos();
		print.statistic(lottos);
		scanner.close();
	}
}
