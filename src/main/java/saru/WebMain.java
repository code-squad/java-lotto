package saru;

import saru.domain.LottoLine;
import saru.domain.LottoMaker;
import saru.domain.LottoUtil;
import saru.view.Input;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {
    public WebMain() {
        // empty
    }

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) ->
                new HandlebarsTemplateEngine().render(
                        new ModelAndView(null, "index.html")));

        post("/buyLotto", (req, res) -> {
            int buyNum = getBuyNum(req);

            List<LottoLine> lottoLines = getLottoLines(req, buyNum);

            Map<String, Object> model = new HashMap<>();
            model.put("buyNum", buyNum);
            model.put("lottos", lottoLines);

            return render(model, "show.html");
        });
    }

    private static List<LottoLine> getLottoLines(Request req, int buyNum) {
        String manualQuery = req.queryParams("manualNumber");
        List<LottoLine> manualLines = LottoUtil.splitManualQueryToLines(manualQuery);

        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> autoLines = lottoMaker.makeAutoLottoLines(buyNum - manualLines.size());

        return LottoUtil.joinLottoLines(autoLines, manualLines);
    }

    private static int getBuyNum(Request req) {
        String inputMoney = req.queryParams("inputMoney");
        return Input.buy(Integer.parseInt(inputMoney));
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
