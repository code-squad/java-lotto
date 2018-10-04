package lotto;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoGameWebMain {

    private static LottoGame lottoGame;
    private static Money money;

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            return render("index.html");
        });

        post("/buyLotto", (request, response) -> {
            try {
                money = InputLottoWebView.inputMoney(request.queryParams("inputMoney"));
                List<String> manualLottoNumbers = InputLottoWebView.inputPurchaseManualLotto(request.queryParams("manualNumber"), money);
                lottoGame = new LottoGame(money, LottoFactory.makeManualLottoNumbers(manualLottoNumbers));

                Map<String, Object> model = new HashMap<>();
                model.put("totalLottoNumbers", OutputLottoWebView.printPurchaseLotto(lottoGame));
                model.put("totalPurchasedLottoCount", OutputLottoWebView.printNumberOfLottoPurchase(lottoGame));

                return render(model, "show.html");
            } catch (IllegalArgumentException e) {
                notFound(alert(e.getMessage(), "/"));
                return null;
            }
        });

        post("/matchLotto", (request, response) -> {
            try {
                Lotto winningLottoNumber = LottoFactory.makeManualLottoNumber(request.queryParams("winningNumber"));
                int bonus = InputLottoWebView.inputBonus(winningLottoNumber, request.queryParams("bonusNumber"));
                LottoGameResult lottoGameResult = lottoGame.playLottoGame(winningLottoNumber, bonus);

                Map<String, Object> model = OutputLottoWebView.winStat(lottoGameResult, money);

                return render(model, "result.html");
            } catch (IllegalArgumentException e) {
                notFound(alert(e.getMessage(), "/"));
                return null;
            }
        });

    }

    public static String render(String templatePath) {
        return render(null, templatePath);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static String alert(String message, String redirectUrl) {
        return "<script>alert('" + message + "'); location.href='" + redirectUrl + "'</script>";
    }

}
