import domain.BuyLotto;
import domain.Lotto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class WebLotto {

    public static void main(String[] args) {
        staticFiles.location("/templates");
        port(8080);

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            List<String> manualNumber = Arrays.asList(req.queryParams("manualNumber").split("\r?\n"));
            BuyLotto purchaseLotto = new BuyLotto(inputMoney, manualNumber);
            List<Lotto> lottos = purchaseLotto.getLottos();

            model.put("lottos", lottos);

            return render(model, "show.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
