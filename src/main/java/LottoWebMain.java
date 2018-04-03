import domain.Lotto;
import domain.LottoBundle;
import domain.LottoNum;
import domain.WinningLotto;
import domain.dao.LottoDAO;
import domain.dao.PrizeDAO;
import domain.result.LottoResults;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.LottoMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static utils.InputUtils.*;
import static utils.MoneyUtils.calcBuyAmount;

public class LottoWebMain {

    public static void main(String[] args) {
        port(8080);
        get("/", (req, res) -> {
            LottoDAO lottoDAO = LottoDAO.of();
            lottoDAO.deleteLottosRecord();
            return render(null, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            int totalAmount = calcBuyAmount(convertNumber(req.queryParams("inputMoney")));
            List<Lotto> manualLottos = convertLottos(parseLottoNumbers(splitLottoNumbers(req.queryParams("manualNumber"))));
            LottoBundle lottoBundle = new LottoBundle();
            lottoBundle.addLotto(manualLottos);
            lottoBundle.addLotto(LottoMachine.autoBuy(totalAmount, manualLottos.size()));
            LottoDAO lottoDAO = LottoDAO.of();
            lottoDAO.saveBuyLottos(lottoBundle);
            Map<String, Object> model = new HashMap<>();
            model.put("buyNum", totalAmount);
            model.put("lottos", lottoBundle);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            LottoDAO lottoDAO = LottoDAO.of();
            LottoBundle lottoBundle = lottoDAO.getBuyLottos();
            Lotto lotto = new Lotto(convertLottoNum(parseLottoNumbers(req.queryParams("winningNumber"))));
            LottoNum bonusNumber = convertLottoNum(req.queryParams("bonusNumber"));
            WinningLotto winningNumber = new WinningLotto(lotto, bonusNumber);
            LottoResults results = lottoBundle.matchLotto(winningNumber);
            PrizeDAO prizeDAO = PrizeDAO.of();
            prizeDAO.savePrize(results);
            Map<String, Object> model = new HashMap<>();
            model.put("results", results);
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
