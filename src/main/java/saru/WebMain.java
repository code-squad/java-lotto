package saru;

import saru.domain.*;
import saru.view.*;

import java.util.*;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {
    private static List<LottoLine> storeLottoLines = null;
    private static int buyNum = 0;

    public static void main(String[] args) {
        initWebMain();

        post("/buyLotto", (req, res) -> {
            storeBuyNum(req);
            storeLottoLines(req, buyNum);

            Map<String, Object> model = new HashMap<>();
            model.put("buyNum", buyNum);
            model.put("lottos", storeLottoLines);

            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNum = req.queryParams("winningNumber");
            int bonusNum = Integer.parseInt(req.queryParams("bonusNumber"));

            // TODO 여기서 디비에서 불러온다
            LottoCalculator lottoCalculator = LottoCalculator.of(storeLottoLines);
            Result result = lottoCalculator.makeResult(buyNum, winningNum, bonusNum);
            // TODO 여기서 result 디비에 넣는다

            Map<String, Object> model = new HashMap<>();
            model.put("result", result);
            return render(model, "result.html");
        });
    }

    private static void initWebMain() {
        port(8080);

        get("/", (req, res) ->
                new HandlebarsTemplateEngine().render(
                        new ModelAndView(null, "index.html")));
    }

    private static void storeLottoLines(Request req, int buyNum) {
        String manualQuery = req.queryParams("manualNumber");
        List<LottoLine> manualLines = LottoUtil.splitManualQueryToLines(manualQuery);

        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> autoLines = lottoMaker.makeAutoLottoLines(buyNum - manualLines.size());

        storeLottoLines = LottoUtil.joinLottoLines(autoLines, manualLines);
        // TODO 여기서 디비에 넣는다
    }

    private static void storeBuyNum(Request req) {
        String inputMoney = req.queryParams("inputMoney");
        buyNum = Input.buy(Integer.parseInt(inputMoney));
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
