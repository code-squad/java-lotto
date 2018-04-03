package lotto.lotto;

import static spark.Spark.*;

import lotto.lotto.domain.*;
import lotto.lotto.view.Input;
import lotto.lotto.view.View;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

public class webLotto {
    static List<Lotto> lottos = new ArrayList<>();

    public static void main(String[] args) {
        staticFiles.location("/templates");
        port(8090);

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            List<String> manualLotto = Arrays.asList(req.queryParams("manualNumber").split("\r?\n"));

            BuyingLotto man = new BuyingLotto(inputMoney, manualLotto);
            lottos = man.getLottos();
            int num = lottos.size();
            model.put("num", num);
            model.put("lottos", lottos);

            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningLotto = req.queryParams("winningNumber");
            int bonusBall = Integer.parseInt(req.queryParams("bonusNumber"));

            WeeklyLotto week = WeeklyLotto.of(winningLotto, bonusBall);
            Map<Rank, Integer> result = week.checkRank(lottos);
            ResultDTO resultLotto = new ResultDTO(result, lottos.size()*1000);
            model.put("resultLotto", resultLotto);

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}

