import domain.Lotto;
import domain.LottoBundle;
import domain.Money;
import domain.WinningLotto;
import dto.LottoDto;
import dto.LottosDto;
import dto.WinResultDto;

import static spark.Spark.*;

import factory.AutoCreateLottoBudleFactory;
import factory.LottoBundleFactory;
import factory.ManualCreateLottoBundleFactory;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.Parser.*;

public class Main {

    public static void main(String[] args) {

        // db 대신?
        List<LottoDto> lottosDto = new ArrayList<>();

        port(8080);

        get("/", (request, response) -> {
            lottosDto.clear();
            return render(null, "/index.html");
        });

        post("/buyLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            LottoBundleFactory manualCreateLottoBundle = ManualCreateLottoBundleFactory.initManualCreateLotto(request.queryParams("manualNumber"));

            lottosDto.addAll(manualCreateLottoBundle.createLottoBunddle().toLottoDtos().getLottoDtos());

            model.put("inputMoney", request.queryParams("inputMoney"));
            model.put("manualAmt", lottosDto.size());
            model.put("manualCreateLottoBundle", lottosDto);

            return render(model, "show.html");
        });

        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Money money = Money.initString(request.queryParams("inputMoney"));
            int autoLottoBundleAmt = money.getLottoAmt() - lottosDto.size();
            LottoBundleFactory autoCreateLottoBundleFactory = AutoCreateLottoBudleFactory.initAutoCreateLottoAmt(autoLottoBundleAmt);

            lottosDto.addAll(autoCreateLottoBundleFactory.createLottoBunddle().toLottoDtos().getLottoDtos());

            WinningLotto winningLotto = new WinningLotto(strToInt(request.queryParams("winningNumber")), strToNo(request.queryParams("bonusNumber")));

            WinResultDto winResultDto = winningLotto.checkWins(LottosDto.init(lottosDto));
            model.put("winResultDto", winResultDto.getWinResultDto());
            model.put("yield", money.getYield(winResultDto));

            return render(model, "result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
