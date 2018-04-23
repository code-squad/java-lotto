import domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class WebLotto {

    static List<Lotto> lottos = new ArrayList<>();

    public static void main(String[] args) {
        staticFiles.location("/templates");
        port(8080);

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            List<String> manualNumber = Arrays.asList(req.queryParams("manualNumber").split("\r?\n"));

            BuyLotto purchaseLotto = new BuyLotto(inputMoney, manualNumber);
            lottos = purchaseLotto.getLottos();

            int lottoSize = lottos.size();

            model.put("lottoSize", lottoSize);
            model.put("lottos", lottos);

            return render(model, "show.html");
        });

        post("/matchLotto" , (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningLotto = req.queryParams("winningNumber");
            int bonusBall = Integer.parseInt(req.queryParams("bonusNumber"));

            WinningNum winningNum = new WinningNum(winningLotto, bonusBall);
            Map<Rank, Integer> result = winningNum.checkRank(lottos);
            Result resultLotto = new Result(result);
            model.put("resultLotto", resultLotto);
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
