import domain.Lotto;
import domain.LottoBundle;
import domain.LottoNum;
import domain.WinningLotto;
import domain.result.LottoResults;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.LottoMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static utils.InputUtils.*;
import static utils.MoneyUtils.calcBuyAmount;
/*
    [만들어야하는 테이블]
    1. 구매한 로또 - LottoBundle(각각을 테이블 로우로 저장)
    2. 위닝 로또와 비교한 결과 - LottoResults (각 랭크에 대한 결과 - String 데이터를 저장하면되지않을까)
 */

public class LottoWebMain {
    private static LottoBundle lottoBundle = new LottoBundle();

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

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
