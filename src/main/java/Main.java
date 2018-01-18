import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	private static final int priceLotto = 1000;
	private static Lottos lottos;
	private static int money;
	
	
	public static void main(String[] args) {
		staticFiles.location("/static");
		
		post("/buyLotto", (req, res) -> {
			String moneyStr = req.queryParams("inputMoney");
			money = Integer.parseInt(moneyStr);
			int howMany = money / priceLotto;
			String manualNo = req.queryParams("manualNumber");
			String[] totalManualNo = manualNo.split("(\r\n)");
			lottos = new Lottos(UserLotto.createLottos(howMany, totalManualNo));
			Map<String, Object> model = new HashMap<>();
			model.put("lottos", lottos);
			return render(model, "show.html");
		});
		
		post("/matchLotto", (req, res) -> {
			String winningNumber = req.queryParams("winningNumber");
			WinningLotto winningLotto = new WinningLotto(WinningLotto.getWinningLotto(winningNumber));
			String bonusNumber = req.queryParams("bonusNumber");
			int bonusNo = Integer.parseInt(bonusNumber);
			List<Match> matches = lottos.createMatches(winningLotto.numbers, bonusNo);
			StatisticsSet statisticsSet = new StatisticsSet(Statistics.createStatisticsSet());
			Statistics.runCheckingMatchingTicketNum(statisticsSet, matches);
			statisticsSet.setRateOfReturn(money);
			log.info(statisticsSet.getRateOfReturn() + "");
			Map<String, Object> model = new HashMap<>();
			model.put("statisticsSet", statisticsSet);
			return render(model, "result.html");
		});
	}
	
	public static String render(Map<String, Object> model, String templatePath) {
	    return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}