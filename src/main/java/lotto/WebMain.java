package lotto;

import java.util.HashMap;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static lotto.domain.LottoResult.getProfit;
import static lotto.domain.LottoResult.getProfitRate;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {
    private static final String NUMBER_REGEX = "\r\n";
    private static final String MONEY = "money";
    private static final String LOTTOS = "lottos";

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post("/buyLotto", (req, res) -> {
            int money = Integer.parseInt(req.queryParams(MONEY));
            String[] numbers = req.queryParams("manualNumber").split(NUMBER_REGEX);

            LottoMachine lottoMachine = LottoMachine.init(money, numbers.length);
            Lottos lottos = lottoMachine.generateLottos(Input.init(String.join(", ", numbers)).customLottoms(numbers.length));
            req.session().attribute(MONEY, money);
            req.session().attribute(LOTTOS, lottos);

            Map<String, Object> model = new HashMap<>();
            model.put(LOTTOS, lottos.getLottos());
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumbers = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            Lotto winningOriginalLotto = Input.init(winningNumbers).winNumbers();
            WinningLotto winningLotto = WinningLotto.generate(winningOriginalLotto, Input.init(bonusNumber).getBonusBall(winningOriginalLotto));
            int money = req.session().attribute(MONEY);
            Lottos lottos = req.session().attribute(LOTTOS);
            LottoResult lottoResult = lottos.matchResult(winningLotto);

            Map<String, Object> model = new HashMap<>();
            model.put("lottoMap", lottoResult.getWinningLottoMap());
            model.put("profit", getProfitRate(getProfit(lottoResult.getWinningLottoMap()), money));
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
