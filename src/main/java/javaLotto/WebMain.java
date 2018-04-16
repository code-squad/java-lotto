package javaLotto;

import javaLotto.domain.*;
import javaLotto.utils.LottoNumberGenerator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
        private static Lotto lotto;

        public static void main(String[] args) {
        staticFiles.location("/templates");
        port(8080);

        get("/index", (req, res) -> {
            return render(new HashMap<>() ,"index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));

            List<LottoTicket> lottos = new ArrayList<>();
            for (String number : req.queryParams("manualNumber").split("\r\n")){
                lottos.add(LottoNumberGenerator.makeLottoNumberManual(number));
            }

            lotto = JavaLotto.buyLotto(inputMoney, lottos);
            model.put("lottoInfo", lotto.getSize());
            model.put("lotto", lotto.getLottos());
            return render(model,"show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            GameResult result = Grade.checkGrade(lotto, new WinningNumber(req.queryParams("winningNumber"), req.queryParams("bonusNumber")));
            model.put("result", result.getGrade());
            model.put("percent", result.getPercent(lotto.getSize()*1000));
            return render(model,"result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}