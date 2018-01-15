package lotto;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	private static Lottos buyManualTicket (int ticketNum, String inputManualNum) {
		log.info("수동으로 구매하실 번호를 입력해 주세요. 숫자 사이에는 ,와 (스페이스바)를 입력해주세요.");
		Lottos lottos = new Lottos();
		List<String> input = new ArrayList<String> ();

		input = InputView.inputManualNum(inputManualNum);	
		lottos = addManualLotto(input, lottos);
		
		return lottos;
	}

	private static Lottos addManualLotto(List<String> input, Lottos lottos) {
		if (!input.isEmpty()) {
			lottos.add(new Lotto(InputView.convertInput(input)));
			return lottos;
		}
		return lottos;
	}

	private static Lottos buyAutoTicket (Lottos lottos, int ticketNum) {
		for (int i = 0; i < ticketNum; i++) {
			lottos.add(new AutoLotto());
		}
		return lottos;
	}

	//===========================MAIN START===============================
	public static void main (String[] args) {
		port(8080);

		get("/", (req, res) -> {
			return render(new HashMap<> (), "index.html");
		});

		post("/buyLotto", (req, res) -> {
			Money money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
			int lottoTicketNum = money.buyLotto();
			Lottos lottos = buyManualTicket(lottoTicketNum, req.queryParams("manualNumber"));
			int manualTicketNum = lottos.get().size();

			lottoTicketNum = lottoTicketNum - manualTicketNum;
			//log.error(Integer.toString(lottoTicketNum));
			lottos = buyAutoTicket(lottos, lottoTicketNum);

			Map<String, Object> model = new HashMap<>();
			model.put("lotto", lottos.get());
			model.put("size", lottos.getSize());
			return render(model, "show.html");

			//			String inputName = req.queryParams("names");
			//			ArrayList<String> carNameList = new ArrayList<String>(Arrays.asList(RacingCar.splitName(inputName)));
			//			for (String name : carNameList) {
			//				cars.add(new Car(name));
			//			}
			//			Map<String, Object> model = new HashMap<>();
			//			model.put("cars", cars);
			//			return render(model, "game.html");
		});

		//Money money = new Money(InputView.takeMoney());		//돈을 입력 받는다.

		//int lottoTicketNum = money.buyLotto();

		//Lottos lottos = buyManualTicket(lottoTicketNum);		//수동으로 번호를 입력받아 티켓을 만든다.
		//int manualTicketNum = lottos.get().size();		//수동으로 만든 티켓의 갯수.

		//		lottoTicketNum = lottoTicketNum - manualTicketNum;
		//		ResultView.printAutoOrManual(manualTicketNum, lottoTicketNum);

		//lottos = buyAutoTicket(lottos, lottoTicketNum);		//남은 티켓 수만큼 자동 티켓을 만들어 준다.

		//ResultView.printTicket(lottos);
		//---


		//		ArrayList<Integer> winningNum = InputView.inputNum();		//지난 주 당첨 번호를 입력 받는다.
		//		int bonusNum = InputView.takeBonusNum();
		//		WinningLotto winningLotto = new WinningLotto(winningNum, bonusNum);
		//		
		//		ArrayList<Match> matchList = lottos.makeMatchList(winningLotto);
		//		ArrayList<MatchingResult> result = lottos.makeResult();
		//		
		//		Lottos.fillResult(matchList, result);		//당첨 번호들을 가지고 최신 result 로 채워준다.(Update해준다.)
		//		
		//		double profit = lottos.calculateMoney(result, money);		//번 돈과 투자한 돈을 가지고 수익률을 계산한다.
		//		
		//		ResultView.printResult(result);
		//		ResultView.printProfit(profit);
	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
