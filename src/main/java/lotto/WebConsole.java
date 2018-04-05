package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.view.Output;
import lotto.view.UserPrompt;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.Generator.*;
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

            List<Ticket> manual = generateManualTickets(money, manualNumber);
            List<Ticket> auto = generateAutoTickets(money, manual.size());

            Lotto lotto = new Lotto(auto, manual);
            model.put("lotto", lotto);
            return render(model, "/show.html");
        });


    }

    private static Lotto initLotto() {
        try {
            int total = UserPrompt.getMoney();
            int numberOfManual = UserPrompt.getNumberOfManual(total);
            List<List<Integer>> manual = UserPrompt.getManual(numberOfManual);

            return new Lotto(generateAutoTickets(total - numberOfManual), generateManualTickets(manual));

        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return initLotto();
        }
    }

    private static WinningLotto initWinningLotto() {
        try {
            List<Integer> numbers = UserPrompt.getWinningNumbers();
            Integer number = UserPrompt.getBonusNumber();

            Ticket winningTicket = generateWinningTicket(numbers);
            Number bonusNumber = generateBonusNumber(number);
            return new WinningLotto(winningTicket, bonusNumber);

        } catch (IllegalArgumentException e) {
            Output.printMessage(e.getMessage());
            return initWinningLotto();
        }
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}