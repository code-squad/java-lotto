import dao.LottoDAO;
import dao.RankDAO;
import lotto.*;

import static spark.Spark.*;

import rank.Rank;
import result.Result;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.port;

public class WebRun {
    public static void main(String [] args) {
        port(8080);
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            List<String> manualNum = Arrays.asList(req.queryParams("manualNumber").split("\r?\n"));
            WebBuy webBuy = new WebBuy();
            webBuy.webAutoBuy(((Integer.parseInt(req.queryParams("inputMoney")) / 1000) - manualNum.size()));
            webBuy.webManualBuy(manualNum);
            Map<String, Object> model = new HashMap<>();
            List<Lotto> lottos = webBuy.getLottos();
            LottoDAO lottoDao = new LottoDAO();
            lottoDao.lottosInserting(lottos);
            model.put("num", (Integer.parseInt(req.queryParams("inputMoney")) / 1000));
            model.put("lottos", lottos);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            LottoDAO lottoDao = new LottoDAO();
            LottoGame game = new LottoGame(lottoDao.readLottos());
            WinningLotto winningLotto = new WinningLotto(new Lotto(req.queryParams("winningNumber")), Integer.parseInt(req.queryParams("bonusNumber")));
            Result result = game.match(winningLotto);
            RankDAO rankDao = new RankDAO();
            rankDao.insert(result);
            model.put("result", result);
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
