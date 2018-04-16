package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static spark.Spark.*;

public class LottoWebApplication {

    private static LottoGame lottoGame;
    private static long amount;

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res)-> render(null, "/index.html"));

        post("/buyLotto", (req, res) -> {
            long inputMoney = Long.parseLong(req.queryParams("inputMoney"));
            String manualNumber = req.queryParams("manualNumber");

            String[] splitNumber = manualNumber.split("\r\n");
            List<List<String>> manualNumbers = new ArrayList<>();
            for (String number : splitNumber) {
                manualNumbers.add(Arrays.asList(number.split(",")));
            }

            lottoGame = new LottoGame(inputMoney, manualNumbers);
            amount = inputMoney;

            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottoGame.getLottos());

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            List<String> winningNumber = Arrays.asList(req.queryParams("winningNumber").split(","));
            String bonusNumber = req.queryParams("bonusNumber");

            GameResult gameResult = lottoGame.play(winningNumber, bonusNumber);

            List<String> ranks = gameResult.getRank()
                    .entrySet()
                    .stream()
                    .map(rank -> rank.getKey().toString(rank.getValue()))
                    .collect(toList());

            Map<String, Object> model = new HashMap<>();
            model.put("ranks", ranks);
            model.put("rateOfReturn", gameResult.rateOfReturn(amount));
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String path) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, path));
    }
}
