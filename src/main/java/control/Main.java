package control;

import domain.*;
import dto.LottoDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.NumParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.Money.LOTTO_PRICE;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;


public class Main {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/templates");

        LottoDto[] lottoDto = new LottoDto[1];
        LottoGame lottoGame = new LottoGame();
        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Money money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
            LottoMachine lottoMachine = new ManualLottoMachine(req.queryParams("manualNumber"));
            lottoDto[0] = lottoGame.generateLottos(money, lottoMachine);
            model.put("size", lottoDto[0]);
            model.put("lottoDto", lottoDto[0].getLottos());
            return render(model, "show.html");
        });
        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            WinningLotto winningLotto = WinningLotto.ofWinningLotto(NumParser.parse(req.queryParams("winningNumber")), Integer.parseInt(req.queryParams("bonusNumber")));
            GameResult gameResult = lottoGame.checkLottos(winningLotto, lottoDto[0]);
            List<String> gameResultMessage = gameResult.getResultMessage();
            int profitRate = gameResult.calculateProfitRate((double) (lottoDto[0].getLottosSize() * LOTTO_PRICE));
            model.put("gameResults", gameResultMessage);
            model.put("profitRate", profitRate);
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
