package lotto;

import lotto.domain.Lotto;
import lotto.domain.Results;
import lotto.domain.WinningLotto;
import lotto.domain.generation.Number;
import lotto.domain.generation.Ticket;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.generation.Generator.*;
import static spark.Spark.*;

public class WebConsole {
    private static Lotto lotto;

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

            lotto = new Lotto(auto, manual);

            model.put("lotto", lotto);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            Ticket winningTicket = generateWinningTicket(winningNumber);
            Number bonusBall = generateBonusNumber(bonusNumber);
            WinningLotto winningLotto = new WinningLotto(winningTicket, bonusBall);

            Results results = new Results(lotto, winningLotto);
            model.put("results", results);
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}