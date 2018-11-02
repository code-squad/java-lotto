import domain.*;
import dto.WinStatsDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.StringParser;
import vo.Money;
import vo.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import static spark.Spark.*;

public class LottoGame {
    public static void main(String[] args) {
        port(8080);
        Map<String, Object> model = new HashMap<>();
        LottoBundleFactory autoLottoBundleFactory = new AutoLottoBundleFactory();
        LottoBundle theLottoBundle = autoLottoBundleFactory.generate(0);

        get("/", (req, res) -> {
            model.clear();
            theLottoBundle.clear();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Money investedMoney = Money.ofText(req.queryParams("inputMoney"));
            model.clear();
            theLottoBundle.clear();
            model.put("investedMoney", investedMoney);
            model.put("count", investedMoney.calculateCountCanBuy());
            theLottoBundle.addAll(makeLottoBundle(investedMoney.calculateCountCanBuy(), req.queryParams("manualNumber")));
            model.put("lottoBundle", theLottoBundle.toDto());
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            WinningLotto theWinningLotto = WinningLottoFactory.
                    generateWinningLotto(StringParser.parseToNumbers(req.queryParams("winningNumber")), StringParser.parseToNumber(req.queryParams("bonusNumber")));
            WinStatsDto winStatsDto = theLottoBundle.calculateWinStats(theWinningLotto, (Money) model.get("investedMoney")).toDto();
            model.put("first", winStatsDto.getNumberOfCounts(Rank.FIRST));
            model.put("second", winStatsDto.getNumberOfCounts(Rank.SECOND));
            model.put("third", winStatsDto.getNumberOfCounts(Rank.THIRD));
            model.put("fourth", winStatsDto.getNumberOfCounts(Rank.FOURTH));
            model.put("fifth", winStatsDto.getNumberOfCounts(Rank.FIFTH));
            model.put("rate", winStatsDto.getEarningRate());
            return render(model, "/result.html");
        });
    }

    private static LottoBundle makeLottoBundle(int totalCount, String manualLottoText){
        List<String> manualLottoTexts = Arrays.asList(manualLottoText.split("\r?\n"));
        if(totalCount < manualLottoTexts.size()) new IllegalArgumentException();

        LottoBundleFactory manualLottoBundleFactory = new ManualLottoBundleFactory(manualLottoTexts);
        LottoBundleFactory autoLottoBundleFactory = new AutoLottoBundleFactory();

        LottoBundle theLottoBundle = manualLottoBundleFactory.generate(manualLottoTexts.size());
        theLottoBundle.addAll(autoLottoBundleFactory.generate(totalCount - manualLottoTexts.size()));
        return theLottoBundle;
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
