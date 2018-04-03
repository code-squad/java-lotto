import input.InputCommon;
import input.InputUI;
import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoResult;
import lotto.WinningLotto;
import money.Money;
import org.slf4j.LoggerFactory;
import rank.Decision;
import rank.Rank;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
//import view.ResultView;
import java.util.*;
import static spark.Spark.*;

public class WebMain {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WebMain.class);
    private static List<Lotto> lottos = new ArrayList<>();
    public static void main(String[] args) {
        port(8080);
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            int num = (Integer.parseInt(req.queryParams("inputMoney")) / 1000);
            List<String> manualNum = Arrays.asList(req.queryParams("manualNumber").split("\r?\n"));
            int autoNum = num - manualNum.size();
            LottoGame lottoGame = new LottoGame(autoNum, manualNum);
            lottos = lottoGame.getLottos();
            Map<String, Object> model = new HashMap<>();
            model.put("num", num);
            model.put("lottos", lottos);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            WinningLotto winningLotto = new WinningLotto(req.queryParams("winningNumber"), req.queryParams("bonusNumber"));
            LottoResult result = new LottoResult();
            int profit = result.getProfit(lottos, winningLotto, winningLotto.getBonusNum());
            HashMap<Rank, Integer> fianlCount = result.resultCount(winningLotto, lottos);
            model.put("result", result);
            return render(model, "/result.html");
        });

//        post("/matchLotto", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            Lotto winningNumber = new Lotto(req.queryParams("winningNumber"));
//            String bonusNumber = req.queryParams("bonusNumber");
//            Money money = new Money();
//            Decision decision = new Decision();
//            int inputMoney = lottos.size() * 1000;
//            int profit = money.profit(money.totalMoney(decision.decisionRank(lottos, winningNumber, bonusNumber)), inputMoney);
//            HashMap<Rank, Integer> finalCount = money.money(decision.decisionRank(lottos, winningNumber, bonusNumber));
//            model.put("profit", profit);
//            model.put("moeny", money);
//            return render(model, "/result.html");
//        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
