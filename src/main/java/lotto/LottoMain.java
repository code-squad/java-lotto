package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoMain {

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", ((request, response) -> {
            String money = request.queryParams("inputMoney");
            String manualNumber = request.queryParams("manualNumber");

            LottoStore lottoStore = new LottoStore(new Money(Integer.parseInt(money)),   Arrays.asList(manualNumber.split("\r\n")));
            request.session().attribute("lottoStore", lottoStore);
            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottoStore.getLottos());
            model.put("count", lottoStore.getLottos().size());
            return render(model, "/show.html");
        }));

        post("/matchLotto", ((request, response) -> {
            String winningNumber = request.queryParams("winningNumber");
            String bonusNumber = request.queryParams("bonusNumber");

            LottoStore lottoStore = request.session().attribute("lottoStore");
            LottoResult lottoResult = lottoStore.match(new WinningLotto(winningNumber, Integer.parseInt(bonusNumber)));
            Map<String, Object> model = new HashMap<>();
            model.put("result",lottoResult.getResultList(lottoResult.getResult()));
            model.put("profit",lottoResult.getPercentage());
            return render(model, "/result.html");
        }));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
