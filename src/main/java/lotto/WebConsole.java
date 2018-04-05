package lotto;

import lotto.domain.Lotto;
import lotto.domain.generation.Ticket;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.generation.Generator.*;
import static spark.Spark.*;

public class WebConsole {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String money = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            List<Ticket> manual = generateManualTickets(manualNumber, money);
            List<Ticket> auto = generateAutoTickets(manual.size(), money);

            Lotto lotto = new Lotto(auto, manual);
            model.put("lotto", lotto);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            model.put("winningNumber", winningNumber);
            model.put("bonusNumber", bonusNumber);

            return render(model, "/matchLotto");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}