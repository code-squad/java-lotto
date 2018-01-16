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
	static Lottos lottos = new Lottos();
	static Money money;
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	private static Lottos buyManualTicket (int ticketNum, String inputManualNum) {
		log.info("수동으로 구매하실 번호를 입력해 주세요. 숫자 사이에는 ,와 (스페이스바)를 입력해주세요.");
		
		List<String> input = new ArrayList<String> ();

		input = InputView.inputManualNum(inputManualNum);	
		
		for (int i = 0; i < input.size() / 6; i++) {
			lottos = addManualLotto(input.subList(i * 6, (i + 1) * 6), lottos);
		}
		
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
		Map<String, Object> model = new HashMap<>();
		
		port(8080);

		get("/", (req, res) -> {
			return render(new HashMap<> (), "index.html");
		});

		post("/buyLotto", (req, res) -> {
			money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
			int lottoTicketNum = money.buyLotto();
			Lottos lottos = buyManualTicket(lottoTicketNum, req.queryParams("manualNumber"));
			int manualTicketNum = lottos.get().size();

			lottoTicketNum = lottoTicketNum - manualTicketNum;
			//log.error(Integer.toString(lottoTicketNum));
			lottos = buyAutoTicket(lottos, lottoTicketNum);

			model.put("lotto", lottos.get());
			model.put("size", lottos.getSize());
			model.put("manualTicketNo", manualTicketNum);
			model.put("autoTicketNo", lottoTicketNum);
			return render(model, "show.html");
		});
		
		post("/matchLotto", (req, res) -> {
			List<Integer> winningNum = InputView.inputNum(req.queryParams("winningNumber"));	
			int bonusNum = InputView.takeBonusNum(req.queryParams("bonusNumber"));
			WinningLotto winningLotto = new WinningLotto(winningNum, bonusNum);
			
			ArrayList<Match> matchList = lottos.makeMatchList(winningLotto);
			ArrayList<MatchingResult> result = lottos.makeResult();
			
			Lottos.fillResult(matchList, result);
			
			double profit = lottos.calculateMoney(result, money);	
			List<String> noticeResult = ResultView.printResult(result);
			
			model.put("notice", noticeResult);
			model.put("profit", profit);
			
			return render(model, "result.html");
		});
	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
