import domain.Lotto;
import domain.LottoBundle;
import domain.LottoNum;
import domain.WinningLotto;
import domain.result.LottoResults;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.LottoMachine;
import utils.MoneyUtils;
import utils.OutputUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static utils.InputUtils.*;
import static utils.MoneyUtils.calcBuyAmount;

public class LottoWebMain {
    private static LottoBundle lottoBundle = LottoBundle.of();

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "index.html"));

        post("/buyLotto", (req, res) -> {
            int totalAmount = calcBuyAmount(convertNumber(req.queryParams("inputMoney")));
            List<Lotto> manualLottos = convertLottos(parseLottoNumbers(splitLottoNumbers(req.queryParams("manualNumber"))));
            lottoBundle.addLotto(manualLottos);
            lottoBundle.addLotto(LottoMachine.autoBuy(totalAmount, manualLottos.size()));
            Map<String, Object> model = new HashMap<>();
            model.put("buyNum", totalAmount);
            model.put("lottos", lottoBundle);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Lotto lotto = new Lotto(convertLottoNum(parseLottoNumbers(req.queryParams("winningNumber"))));
            LottoNum bonusNumber = convertLottoNum(req.queryParams("bonusNumber"));
            WinningLotto winningNumber = new WinningLotto(lotto, bonusNumber);
            LottoResults results = lottoBundle.matchLotto(winningNumber);
            Map<String, Object> model = new HashMap<>();
            model.put("results", results);
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
