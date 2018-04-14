package lotto;

import static spark.Spark.exception;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketIssuer;
import lotto.domain.LottoTickets;
import lotto.domain.WinningTicket;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebMain {
    public static void main(String[] args) {
        final String LINE_SEPARATOR = "\r\n";
        final String SESSION_TICKETS_NAMES_KEY = "tickets";

        port(8090);
        staticFiles.location("/templates");

        post("/buyLotto", (req, resp) -> {
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String manualNumbers = req.queryParams("manualNumber");
            String[] selfSelectLottoNumbers = manualNumbers.split(LINE_SEPARATOR);
            int purchasableTicketCount = LottoTicketIssuer.getPurchasableTicketCount(inputMoney);

            if (selfSelectLottoNumbers.length > purchasableTicketCount) {
                throw new IllegalArgumentException("구매 가능한 로또 수를 초과했습니다.");
            }

            List<LottoTicket> selfLottoTickets = LottoTicketIssuer.issue(selfSelectLottoNumbers);
            int restMoney = inputMoney - LottoTicketIssuer.getTicketPrice(selfSelectLottoNumbers.length);
            LottoTickets lottoTickets = new LottoTickets(selfLottoTickets, LottoTicketIssuer.issue(restMoney));
            req.session().attribute(SESSION_TICKETS_NAMES_KEY, lottoTickets);

            Map<String, Object> model = new HashMap<>();
            model.put("lottoTickets", lottoTickets);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, resp) -> {
            String winningNumber = req.queryParams("winningNumber");
            int bonusNumber = Integer.valueOf(req.queryParams("bonusNumber"));
            LottoTickets tickets = req.session().attribute(SESSION_TICKETS_NAMES_KEY);

            LottoTicket winningTicket = LottoTicketIssuer.issue(winningNumber);
            GameResult result = new GameResult(tickets, new WinningTicket(winningTicket, bonusNumber));

            Map<String, Object> model = new HashMap<>();
            model.put("result", result.getAnalyzeResult());
            model.put("rateOfReturn", (int) result.getRateOfReturn());
            return render(model, "result.html");
        });

        exception(IllegalArgumentException.class, (exception, request, response) -> {
            response.type("application/json");
            response.status(400);
            response.body(String.format("{\"message\":\"%s\"}", exception.getMessage()));
        });
    }

    /**
     * @see <a href = "http://sparkjava.com/documentation#views-and-templates">Spark Views and Templates</a>
     */
    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
