package lotto;

import lotto.domain.LottoDTO;
import lotto.domain.LottoProcess;
import lotto.domain.Result;
import lotto.view.Input;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static List<LottoDTO> lottos;

	public static void main(String[] args) {
		port(8080);

		get("/", (req, res) -> {
			return render(null, "/index.html");
		});

		post("/buyLotto", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			int sheets = Input.checkSheets(req.queryParams("inputMoney"));
			model.put("price", req.queryParams("inputMoney"));
			model.put("sheets", sheets);
			if (req.queryParams("manualNumber").isEmpty()) {
				lottos = LottoProcess.of(sheets).getAllLottos();
				model.put("lottos", lottos);
				return render(model, "show.html");
			}
			lottos = LottoProcess.of(sheets,req.queryParams("manualNumber")).getAllLottos();
			model.put("lottos", lottos);
			return render(model, "show.html");
		});

		post("/matchLotto", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			Result result = Result.of();
			model.put("result", result.getResult(req.queryParams("bonusNumber"), LottoProcess.of(lottos), req.queryParams("winningNumber")));
			model.put("revenu", result.calcRevenue(req.queryParams("price")));
			return render(model, "result.html");
		});

	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
