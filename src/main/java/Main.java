import dao.LottoDao;
import dao.WinResultDao;
import domain.Money;
import domain.WinningLotto;

import static spark.Spark.*;

import factory.AutoCreateLottoBudleFactory;
import factory.LottoBundleFactory;
import factory.ManualCreateLottoBundleFactory;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;
import java.util.Map;

import static util.Parser.*;

public class Main {

    public static void main(String[] args) {

        // db
        LottoDao lottoDao = new LottoDao();
        WinResultDao winResultDao = new WinResultDao();

        port(8080);

        get("/", (request, response) -> {
            lottoDao.clear();
            winResultDao.clear();
            return render(null, "/index.html");
        });

        post("/buyLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            LottoBundleFactory manualCreateLottoBundle = ManualCreateLottoBundleFactory.initManualCreateLotto(request.queryParams("manualNumber"));

            lottoDao.insertAll(manualCreateLottoBundle.createLottoBunddle().toLottoDtos());

            model.put("inputMoney", request.queryParams("inputMoney"));
            model.put("manualAmt", lottoDao.count());
            model.put("manualCreateLottoBundle", lottoDao.selectAll().getLottoDtos());

            return render(model, "show.html");
        });

        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Money money = Money.initString(request.queryParams("inputMoney"));
            int autoLottoBundleAmt = money.getLottoAmt() - lottoDao.count();
            LottoBundleFactory autoCreateLottoBundleFactory = AutoCreateLottoBudleFactory.initAutoCreateLottoAmt(autoLottoBundleAmt);

            lottoDao.insertAll(autoCreateLottoBundleFactory.createLottoBunddle().toLottoDtos());

            WinningLotto winningLotto = new WinningLotto(strToInt(request.queryParams("winningNumber")), strToNo(request.queryParams("bonusNumber")));

            winResultDao.insertAll(winningLotto.checkWins(lottoDao.selectAll()));

            model.put("winResultDto", winResultDao.selectAll().getWinResultDto());
            model.put("yield", money.getYield(winResultDao.selectAll()));

            return render(model, "result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
