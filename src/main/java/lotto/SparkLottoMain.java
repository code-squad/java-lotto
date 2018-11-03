package lotto;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class SparkLottoMain {
    public static void main(String[] args) {
        port(8080);
        List<Lotto> lottos = new ArrayList<>();
        final Money[] money = new Money[1];

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });
        post("/buyLotto", (req, res) -> {
            money[0] = new Money(Integer.parseInt(req.queryParams("inputMoney")));
            String[] lottoList = req.queryParams("manualNumber").split("\r?\n");
            money[0].isOverCount(lottoList.length);
            for (String lotto : lottoList) {
                lottos.add(Lotto.ofManualLotto(lotto));
            }
            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottos);
            model.put("count", lottos.size());
            return render(model, "show.html");
        });
        post("/matchLotto", (req, res) -> {
            WinningLotto winningLotto = new WinningLotto(req.queryParams("winningNumber"), LottoNo.of(req.queryParams("bonusNumber")));
            LottoManager lottoManager = new LottoManager(lottos);
            lottoManager.winLottoMatch(winningLotto);

            Map<String, Object> model = new HashMap<>();
            model.put("FIFTH", lottoManager.getRank(Rank.FIFTH));
            model.put("FOURTH", lottoManager.getRank(Rank.FOURTH));
            model.put("THIRD", lottoManager.getRank(Rank.THIRD));
            model.put("SECOND", lottoManager.getRank(Rank.SECOND));
            model.put("FIRST", lottoManager.getRank(Rank.FIRST));
            model.put("yield", money[0].yield(lottoManager));

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
