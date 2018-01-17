import com.github.jknack.handlebars.Handlebars;
import domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.InputView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    private static final LottoSeller lottoSeller = new LottoSeller(new LottoNumCreator());

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            return render(new HashMap<>(), "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            Lottos manualLottos = getManualLottos(req.queryParams("manualNumber"));

            BuyInfo buyInfo = new BuyInfo(inputMoney, manualLottos);
            Lottos lottos = lottoSeller.buyLotto(buyInfo);

            List<String> lottosString = splitToString(lottos.toString());
            model.put("lottos", lottosString);
            model.put("numOfLottos", lottosString.size());
            req.session().attribute("lottos", lottos);

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Lottos lottos = req.session().attribute("lottos");
            Lotto winningNo = new Lotto(getNumber(req.queryParams("winningNumber")));
            LottoNo bonusNo = new LottoNo(Integer.parseInt(req.queryParams("bonusNumber")));

            WinningNumber winningNumber = new WinningNumber(winningNo, bonusNo);
            WinningLottos winningLottos = lottos.getWinningLottos(winningNumber);
            List<String> resultString = splitToString(winningLottos.toString());

            model.put("profit", winningLottos.getProfitPercentage());
            model.put("result", resultString);

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String path) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, path));
    }
}
