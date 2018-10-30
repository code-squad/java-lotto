package lottogame;

import lottogame.domain.Lotto;
import lottogame.domain.LottoGame;
import lottogame.domain.WinnningLotto;
import lottogame.dto.LottoDto;
import lottogame.dto.Result;
import lottogame.dto.ResultDto;
import lottogame.view.InputView;
import lottogame.vo.Money;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class SparkMain {
    public static void main(String[] args) {
        port(8080);

        List<Lotto> lottos = new ArrayList<>();

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            lottos.clear();
            lottos.addAll(InputView.web(inputMoney, manualNumber));

            Map<String, Object> model = new HashMap<>();
            model.put("amount", lottos.size());
            model.put("lottos", lottos.stream().map(x -> new LottoDto(x.toString())).collect(Collectors.toList()));
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            LottoGame game = new LottoGame(lottos);
            Result result = game.result(WinnningLotto.of(winningNumber, bonusNumber));

            int rate = (result.totalReward() / (Money.LOTTO_PRICE * lottos.size())) * 100;
            List<ResultDto> resultDtos = ResultDto.listOf(result);

            Map<String, Object> model = new HashMap<>();
            model.put("rate", rate);
            model.put("results", resultDtos);
            return render(model, "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}



