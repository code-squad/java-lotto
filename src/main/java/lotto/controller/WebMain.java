package lotto.controller;

import lotto.domain.Rank;
import lotto.service.LottoGames;
import lotto.view.WebView;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {
    static LottoGames lottoGames = null;


    public static void main(String[] args) {
        port(8080);

        WebView webView = new WebView();



        get("/", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return webView.render(model, "/index.html");
        });

        post("/buyLotto", (req, res)->{
            String inputMoney = req.queryParams("inputMoney");
            String inputManualNumber = req.queryParams("manualNumber");
            String[] manualNumbers = new String[0];
            if(inputManualNumber != null && !inputManualNumber.isEmpty() ) {
                manualNumbers = inputManualNumber.split("\n");
            }

            lottoGames = new LottoGames(Long.parseLong(inputMoney), manualNumbers);

            Map<String, Object> model = new HashMap<>();
            model.put("buyCount", lottoGames.getHavingCount());
            model.put("lottos", lottoGames.getLottos().getLottos());

            return webView.render(model, "/show.html");
        });

        post("/matchLotto", (req, res)->{


            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");
            List<String> winNumbers = new ArrayList<>();

            winNumbers.add(winningNumber);
            winNumbers.add(bonusNumber);
            lottoGames.setWinLotto(winNumbers);

            int buyAmt = lottoGames.getHavingCount() * LottoGames.LOTTO_PRICE_PER_TICKET;

            Map<Rank, Integer> rankCountMap = lottoGames.getRankMap();

            int awardAmt = lottoGames.getAwardAmt();

            Map<String, Object> model = new HashMap<>();
            model.put("rankText", lottoGames.getResultViewString());
            model.put("incomeRate", (long)awardAmt * 100l / (long)buyAmt);

            return webView.render(model, "/result.html");
        });


    }
}
