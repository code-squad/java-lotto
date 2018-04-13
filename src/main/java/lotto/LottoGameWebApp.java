package lotto;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static spark.Spark.*;

public class LottoGameWebApp {
	private static LottoGame lottoGame;
	private static final String NUMBER_SPLIT_REGEX = ", |,";
	
	public static void main(String[] args) {
		port(8080);
		
		get("/", (request, response) -> render(null, "/index.html"));
		
		post("/buyLotto", (request, response) -> {
			lottoGame = new LottoGame(new RandomLottoGenerator());
			int money = Integer.parseInt(request.queryParams("money"));
			List<Lotto> customLottos = Arrays.stream(request.queryParams("customLottos").split("\\r\\n"))
					.map(customLotto -> new LottoNumbers(Arrays.stream(customLotto.split(NUMBER_SPLIT_REGEX))
							.map(LottoNumber::parseLottoNumber)
							.collect(toList())))
					.map(lottoNumbers -> new Lotto(lottoNumbers, false))
					.collect(toList());
			List<Lotto> lottos = lottoGame.generateLottos(money, customLottos);
			
			Map<String, Object> model = new HashMap<>();
			model.put("lottos", lottos);
			model.put("lottosSize", lottos.size());
			model.put("money", money);
			
			return render(model, "/show.html");
		});
		
		post("/matchLotto", (request, response) -> {
			int money = Integer.parseInt(request.queryParams("money"));
			
			LottoNumbers winNumbers = new LottoNumbers(Arrays.stream(request.queryParams("winNumbers").split(NUMBER_SPLIT_REGEX))
					.map(LottoNumber::parseLottoNumber)
					.collect(toList()));
			LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(request.queryParams("bonusNumber")));
			LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(winNumbers, bonusNumber);
			
			Map<String, Object> model = new HashMap<>();
			model.put("results", lottoGame.getResults(lottoWinNumbers));
			model.put("profitRate", lottoGame.calculateProfitRate(lottoWinNumbers, money));
			
			return render(model, "/result.html");
		});
	}
	
	private static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
