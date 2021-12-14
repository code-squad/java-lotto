package controller;

import dto.LottoDto;
import dto.LottosResult;
import service.LottoService;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;

        get("/", (req, res) -> index());
        post("/buyLotto", (req, res) -> butLotto(req));
        post("/matchLotto", (req, res) -> matchLotto(req));
    }

    private String index() {
        return render(null, "index.html");
    }

    private String butLotto(Request req) {
        String inputMoney = req.queryParams("inputMoney");
        String manualNumbers = req.queryParams("manualNumber");

        List<LottoDto> lottos = lottoService.buyLotto(inputMoney, manualNumbers);

        Map<String, Object> model = new HashMap<>();
        model.put("lottosSize", lottos.size());
        model.put("lottos", lottos);

        return render(model, "show.html");
    }

    private String matchLotto(Request req) {
        String winningNumber = req.queryParams("winningNumber");
        String bonusNumber = req.queryParams("bonusNumber");

        LottosResult lottosResult = lottoService.matchLotto(winningNumber, bonusNumber);

        Map<String, Object> model = new HashMap<>();
        model.put("lottosResult", lottosResult);

        return render(model, "result.html");
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
