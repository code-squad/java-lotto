package controller;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dto.InputValue;
import model.AutoLotto;
import model.CandidateLottoSet;
import model.LottoCreator;
import model.ManualLotto;
import model.WinStats;
import model.WinningLotto;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.InputView;
import view.ResultView;

public class Main {
	public static void main(String[] args) {
		port(8088);
		get("/", (req, res) -> {
			return render(new HashMap<>(), "index.html");
		});
		List<ManualLotto> manualLottos = new ArrayList<>();
		post("/buyLotto", (req, res) -> {
			List<Integer> lottoNums = process(req.queryParams("manualNumber"));
			ManualLotto manualLotto = new ManualLotto(lottoNums);
			manualLottos.add(manualLotto);
			String inputMoney = req.queryParams("inputMoney");
			Map<String, Object> model = new HashMap<>();
			model.put("inputMoney", inputMoney);
			model.put("manualLottos", manualLottos);
			return render(model,"show.html");
		});
		post("/matchLotto", (req, res) -> {
			List<Integer> lottoNums = process(req.queryParams("winningNumber"));
			int bonusNum = Integer.parseInt(req.queryParams("bonusNumber"));
			WinningLotto winningLotto = new WinningLotto(lottoNums, bonusNum);
			Map<String, Object> model = new HashMap<>();
			model.put("winningLotto", winningLotto);
			return render(model, "result.html");
		});
		
	}
	private static List<Integer> process(String num) {
		List<String> nums = Arrays.asList(num.split(","));
		List<Integer> lottoNums = nums.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		return lottoNums;
	}
	public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
//	public static void main1(String[] args) {
//		InputValue inputValue = InputView.createValue();
//		int investingAmount = inputValue.getMoney();
//		List<AutoLotto> autoLottos = LottoCreator.makeAutoLottos(inputValue.getNumOfAutoLotto());
//		List<ManualLotto> manualLottos = LottoCreator.makeManualLottos(inputValue.getNumOfManualLotto(),
//				inputValue.getManualLottoNums());
//		CandidateLottoSet candidateLottoSet = new CandidateLottoSet(manualLottos, autoLottos);
//		WinningLotto winningLotto = LottoCreator.makeWinningLotto();
//		WinStats winStats = winningLotto.makeStats(candidateLottoSet);
//		ResultView.print(candidateLottoSet, winningLotto, winStats, investingAmount);
//	}
}
