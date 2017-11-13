package controller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Lotto;
import model.Lottos;
import model.Money;
import model.WinningLotto;
import view.InputView;
import view.ResultView;

public class LottoController {
	private static final Logger log = LoggerFactory.getLogger(LottoController.class);

	Lottos lottos;
	
	public void makeLotto(InputView input, ResultView print, Money money) {
		if(input.chooseType().trim().equals("자동")) {
			this.lottos = lottos.of(money.coutTicket());
			print.lottery(lottos);
			return;
		}
		this.lottos = lottos.of(input.getLottoNumbers(money));
	}
	
	public void beginLottery(ResultView print, Money money) {
		WinningLotto winningLotto = WinningLotto.initLotto();
		print.winningNumber(winningLotto);
		lottos.checkLottos(winningLotto);
		lottos.statistic(winningLotto.getBonus());
		print.statistic(lottos);
		print.earningRate(lottos.earningRate(money.getMoney()));
	}

	public static void main(String[] args) {
/*		로그 예시
  		log.debug("log 시작" + "a"); //연산 - 비용발생
		log.debug("log 시작{}", "a"); //가변인자
		int age = 30;
		log.debug("log 시작{}, my age: {}", "a", age);
*/		
		Scanner scanner = new Scanner(System.in);
		InputView input = new InputView(scanner);
		ResultView print = new ResultView();
		LottoController controller = new LottoController();
		Money money = new Money(input.getMoney());
		
//		포비코드 DTO 사용
//		InputValue iv = InputView.inputValue();
//		if (iv.isAuto()){ 내용 생략		} 

		print.num(money.coutTicket());
		controller.makeLotto(input, print, money);
		if(input.getCommand().equals("lottery")){
			controller.beginLottery(print, money);
		}
		scanner.close();
	}
}
