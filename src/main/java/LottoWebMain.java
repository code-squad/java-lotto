import domain.Lotto;
import domain.LottoBundle;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.LottoMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static utils.InputViewUtils.*;
import static utils.MoneyUtils.calcBuyAmount;

public class LottoWebMain {
    public static void main(String[] args) {
        port(8080);
        get("/", (req, res) -> render(null, "index.html"));
        post("/buyLotto", (req, res) -> {
            int totalAmount = calcBuyAmount(convertNumber(req.queryParams("inputMoney")));
            List<Lotto> manualLottos = convertLottos(parseLottoNumbers(splitLottoNumbers(req.queryParams("manualNumber"))));
            LottoBundle lottoBundle = LottoBundle.of();
            lottoBundle.addLotto(manualLottos);
            lottoBundle.addLotto(LottoMachine.autoBuy(totalAmount, manualLottos.size()));
            Map<String, Object> model = new HashMap<>();
            model.put("buyNum", totalAmount);
            model.put("lottos", lottoBundle);
            return render(model, "show.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
