package lotto;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class LottoGame {
	private static Lottos lottos;
	private static int money;
	private static final int LOTTO_BUYING_MONEY = 1000;
	private static final Logger log = LoggerFactory.getLogger(LottoGame.class);

	public static void main(String[] args) {

		port(8080);

		get("/", (req, res) -> {
			return render(new HashMap<>(), "index.html");
		});

		LottoGame lottoGame = new LottoGame();
		Map<String, Object> model = new HashMap<>();
		post("/buyLotto", (req, res) -> {
			money = Integer.parseInt(req.queryParams("inputMoney"));
			lottos = lottoGame.createLottos(money,InputView.makeUserLotto(req.queryParams("manualNumber")));
			model.put("buyNum", lottos.getBuyNum());
			model.put("lottos", lottos.getLottos());

			return render(model, "show.html");
		});

		post("/matchLotto", (req, res) -> {
			String winLotto = InputView.inputWinNum(req.queryParams("winningNumber"));
			if(winLotto == null)
				return render(model, "show.html");
			HashMap<Rank, Integer> result = lottos
			.compareLotto(new WinningLotto(makePrizeNum(winLotto), Integer.parseInt(req.queryParams("bonusNumber"))));
			model.put("result", lottos);
			model.put("benefit", Result.calculateMoney(result,money));
			return render(model, "result.html");
		});
	}

	private Lottos createLottos(int money, ArrayList<MyLotto> userLotto) {
		return new Lottos(userLotto, howmanyLotto(money));
	}

	public static int howmanyLotto(int inputMoney) {
		return inputMoney / LOTTO_BUYING_MONEY;
	}

	private static ArrayList<Integer> makePrizeNum(String winLotto) {
		ArrayList<Integer> prizeNum = new ArrayList<>();
		String[] input = winLotto.split(",");
		for (String lottoNum : input) {
			prizeNum.add(Integer.parseInt(lottoNum));
		}
		return prizeNum;

	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
