package lotto.io;

import lotto.domain.*;
import lotto.util.LottoRecorder;
import lotto.util.LottoVendor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoController {

    private static Lotteries lottoList;

    public static void main(String[] args) {
        staticFiles.location("/templates");

        post("/buyLotto", (req, res)-> {
            Map<String, Object> model = new HashMap<>();
            int lottoCount = new Money(req.queryParams("inputMoney")).exchangeToLottoCount();
            Lotteries manualLottoList = manualLottoList(req.queryParams("manualNumber"));
            lottoCount -= manualLottoList.size();
            Lotteries lotteries = LottoVendor.getInstance().buy(lottoCount, false);
            for (int index = 0; index < manualLottoList.size(); index++) {
                lotteries.add(manualLottoList.get(index));
            }
            lottoList = lotteries;

            model.put("lotteries", lotteries);
            return render(model, "/templates/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            WinningLotto winningLotto = new WinningLotto(new Lotto(req.queryParams("winningNumber")), new LottoNumber(req.queryParams("bonusNumber")));
            LottoRecorder result = winningLotto.match(lottoList, winningLotto.getLuckyNumber());
            model.put("lottoRank", LottoRank.values());
            model.put("result",result);
            return render(model, "/templates/result.html");
        });
    }

    private static Lotteries manualLottoList(String manualNumber) {
        if (!manualNumber.contains("\r\n")) return new Lotteries(Arrays.asList(new Lotto(manualNumber)));
        return new Lotteries(Arrays.asList(manualNumber.split("\r\n")).stream()
                .map(number->new Lotto(number)).collect(Collectors.toList()));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
