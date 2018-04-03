package lotto;

import lotto.db.LottoDAO;
import lotto.db.ResultDAO;
import lotto.domain.LottoProcess;
import lotto.domain.Result;
import lotto.view.Input;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static String price;

	public static void main(String[] args) {
		port(8080);

		get("/", (req, res) -> {
			LottoDAO lottoDAO = new LottoDAO();
			ResultDAO resultDAO = new ResultDAO();
			lottoDAO.delete();
			lottoDAO.init();
			resultDAO.delete();
			return render(null, "/index.html");
		});

		post("/buyLotto", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			price = req.queryParams("inputMoney");
			int sheets = Input.checkSheets(price);
			model.put("price", price);
			model.put("sheets", sheets);
			LottoProcess lottoProcess = LottoProcess.getLottoProcess(req.queryParams("manualNumber"), sheets);
			lottoProcess.insertLottos();
			model.put("lottos", LottoProcess.selectLottos());
			return render(model, "show.html");
		});

		post("/matchLotto", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			Result.of().insertResult(price, req.queryParams("bonusNumber"), req.queryParams("winningNumber"));
			model.put("result", Result.selectResult());
			return render(model, "result.html");
		});

	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
