package lotto;

import lotto.db.LottoDAO;
import lotto.db.LottoGameDAO;
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

		LottoGameDAO lottoGameDAO = new LottoGameDAO();

		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("turnNo", lottoGameDAO.selectLatestTurnNo());
			return render(model, "/index.html");
		});
		get("/deleteAll", (req, res) -> {
			LottoDAO lottoDAO = new LottoDAO();
			lottoDAO.delete();
			ResultDAO resultDAO = new ResultDAO();
			resultDAO.delete();
			lottoGameDAO.delete();
			Map<String, Object> model = new HashMap<>();
			model.put("turnNo", lottoGameDAO.selectLatestTurnNo());
			return render(model, "/index.html");
		});

		post("/selectBeforeResult", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("result", Result.selectResult(req.queryParams("inputTurnNo")));
			return render(model, "/result.html");
		});

		post("/buyLotto", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			price = req.queryParams("inputMoney");
			int sheets = Input.checkSheets(price);
			String turnNo = req.queryParams("turnNo");
			model.put("price", price);
			model.put("sheets", sheets);
			LottoProcess lottoProcess = LottoProcess.getLottoProcess(req.queryParams("manualNumber"), sheets);
			lottoProcess.insertLottos(turnNo);
			model.put("lottos", LottoProcess.selectLottos(turnNo));
			model.put("lottoGame", lottoGameDAO.selectWinNo(turnNo));
			return render(model, "/show.html");
		});

		post("/matchLotto", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			Result.of().insertResult(price, req.queryParams("turnNo"));
			model.put("result", Result.selectResult());
			return render(model, "/result.html");
		});

	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
