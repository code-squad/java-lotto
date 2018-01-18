package lotto.controller;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import lotto.LottoStore;
import lotto.WinningLotto;
import lotto.domain.LottoCustomerTicket;
import lotto.domain.LottoManualTicketRequest;
import lotto.domain.LottoResult;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class LottoGameController {
    private static final String indexPath = "/index.html";
    public static void main(String[] args) {
        port(8080);

        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("errorMessage", "");
            return render(model, indexPath);
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            try {
                LottoCustomerTicket lottoCustomerTicket = makeLottoCustomerTicket(req.queryParams("inputMoney"), req.queryParams("manualNumber"));

                model.put("countMessage", lottoCustomerTicket.showCountMessage());
                model.put("ticketMessage", lottoCustomerTicket.showTicketMessages());
                model.put("lottoCustomerTicket", lottoCustomerTicket);
                model.put("lottoCustomerTicketStr", lottoCustomerTicket.toString());
            } catch (Exception e) {
                model.put("errorMessage", "아까 발생한 오류는.. " + e.getMessage());
                e.printStackTrace();
                return render(model, indexPath);
            }
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            try {
                WinningLotto winningLotto = new WinningLotto(req.queryParams("winningNumber"), req.queryParams("bonusNumber"));
                LottoResult lottoResult = makeLottoResult(req, winningLotto);

                model.put("profitRatioResultMessage", lottoResult.showProfitRatioResultMessage());
                model.put("resultMessages", lottoResult.showResultMessages());
            } catch (Exception e) {
                model.put("errorMessage", "아까 발생한 오류는.. " + e.getMessage());
                e.printStackTrace();
                return render(model, indexPath);
            }
            return render(model, "/result.html");
        });

    }

    private static LottoResult makeLottoResult(Request req, WinningLotto winningLotto) {
        LottoManualTicketRequest lottoManualTicketRequest = new LottoManualTicketRequest(req.queryParams("lottoCustomerTicketStr"));
        LottoCustomerTicket lottoCustomerTicket = LottoStore.buyExplicitTickets(lottoManualTicketRequest);
        return lottoCustomerTicket.matchTickets(winningLotto);
    }

    private static LottoCustomerTicket makeLottoCustomerTicket(String inputMoneyStr, String manualNumberStr) {
        LottoManualTicketRequest lottoManualTicketRequest = new LottoManualTicketRequest(manualNumberStr);
        int ticketTotalPrice = Integer.parseInt(inputMoneyStr);
        return LottoStore.buyLottoTicket(ticketTotalPrice, lottoManualTicketRequest);
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}