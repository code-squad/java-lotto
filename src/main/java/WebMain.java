import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoResult;
import lotto.WinningLotto;
import org.slf4j.LoggerFactory;
import rank.Rank;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
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
            LottoGame lottoGame = new LottoGame();
            lottoGame.makeLottos(autoNum, manualNum);
            lottos = LottoGame.getLottos();
            Map<String, Object> model = new HashMap<>();
            model.put("num", num);
            model.put("lottos", lottos);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            WinningLotto winningLotto = new WinningLotto(req.queryParams("winningNumber"), req.queryParams("bonusNumber"));
            LottoResult result = new LottoResult();
            lottos = LottoGame.getLottos();
            int profit = result.profitPer(lottos, winningLotto, winningLotto.getBonusNum());
            HashMap<Rank, Integer> finalCount = result.resultCount(winningLotto, lottos);
            model.put("result", result);
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
