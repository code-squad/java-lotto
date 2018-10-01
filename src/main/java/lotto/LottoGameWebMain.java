package lotto;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoGameWebMain {

    private static LottoGame lottoGame;

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            return render("index.html");
        });

        post("/buyLotto", (request, response) -> {
            String inputMoney = request.queryParams("inputMoney");
            Money money = new Money(Integer.parseInt(inputMoney));

            String[] inputManualLottoNumbers = split(request.queryParams("manualNumber"));

            List<String> manualLottoNumbers = new ArrayList<>();
            for (String inputManualLottoNumber : inputManualLottoNumbers) {
                manualLottoNumbers.add(inputManualLottoNumber);
            }

            lottoGame = new LottoGame(money, LottoFactory.makeManualLottoNumbers(manualLottoNumbers));

            return render("show.html");
        });

    }

    public static String render(String templatePath) {
        return render(null, templatePath);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static String[] split(String input) {
        return input.split("<br>");
    }

}
