import domain.LotteryCommission;
import domain.LottoNo;
import domain.LottoNoGroup;
import domain.User;
import domain.exceptions.LottoProcessException;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.InputView;
import view.ResultView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.LottoUtils.TICKET_PRICE;
import static domain.LottoUtils.inputParser;
import static spark.Spark.*;

public class Main {

    static User larry;

    private static void buyProcessConsole() {
        try {
            int money = InputView.enterUserMoney();
            larry = User.whoHasMoneyOf(money);
            int numTickets = money / TICKET_PRICE;
            int numManual = InputView.enterNumManualTickets();
            larry.purchaseTicketsAuto(numTickets - numManual);
            larry.purchaseTicketsManual(InputView.enterNumsOfManualTicket(numManual));
            ResultView.printLottos(larry);
        } catch (LottoProcessException | IOException e) {
            e.printStackTrace();
            buyProcessConsole();
        }
    }

    private static void resultProcessConsole() {
        try {
            LottoNoGroup winningNumbers = InputView.enterWinningLotto();
            LottoNo lottoNo = InputView.enterBonusBall();
            LotteryCommission.selectWinningNumbers(winningNumbers, lottoNo);
            larry.checkTotalResult();
            ResultView.printResult(larry);
        } catch (LottoProcessException e) {
            e.printStackTrace();
            resultProcessConsole();
        }
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static List<LottoNoGroup> makeLottoNoGroup(Request req) {
        String[] manualNumbers = req.queryParams("manualNumber").split("\r?\n");
        List<LottoNoGroup> manualInput = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            manualInput.add(inputParser(manualNumber.trim()));
        }
        return manualInput;
    }

    private static Map<String, Object> buyLotto(Request req) {
        int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
        larry = User.whoHasMoneyOf(inputMoney);
        List<LottoNoGroup> manualInput = makeLottoNoGroup(req);
        larry.purchaseTicketsManual(manualInput);
        larry.purchaseTicketsAuto(inputMoney/ TICKET_PRICE - manualInput.size());
        Map<String, Object> input = new HashMap<>();
        input.put("larry", larry);
        return input;
    }

    private static Map<String, Object> matchLotto(Request req) {
        LottoNo bonusNo = LottoNo.of(Integer.parseInt(req.queryParams("bonusNumber")));
        LotteryCommission.selectWinningNumbers(inputParser(req.queryParams("winningNumber")), bonusNo);
        larry.checkTotalResult();
        Map<String, Object> output = new HashMap<>();
        output.put("larry", larry);
        return output;
    }
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/template");
        get("/", (req, res) -> render(null, "index.html"));
        post("/buyLotto", (req, res) -> render(buyLotto(req), "show.html"));
        post("/matchLotto", (req, res) -> render(matchLotto(req), "result.html"));
    }
}
