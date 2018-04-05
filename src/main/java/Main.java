import domain.*;
import domain.exceptions.LottoProcessException;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.InputView;
import view.ResultView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.LottoUtils.TICKET_PRICE;
import static domain.LottoUtils.inputParser;
import static domain.LottoUtils.makeLottoNoGroup;
import static spark.Spark.*;

public class Main {

    static User larry;
    static LottoDAO lottoDAO;

//    private static void buyProcessConsole() {
//        try {
//            int money = InputView.enterUserMoney();
//            larry = User.whoHasMoneyOf(money);
//            int numTickets = money / TICKET_PRICE;
//            int numManual = InputView.enterNumManualTickets();
//            larry.purchaseTicketsAuto(numTickets - numManual);
//            larry.purchaseTicketsManual(InputView.enterNumsOfManualTicket(numManual));
//            ResultView.printLottos(larry);
//        } catch (LottoProcessException | IOException e) {
//            e.printStackTrace();
//            buyProcessConsole();
//        }
//    }
//
//    private static void resultProcessConsole() {
//        try {
//            LottoNoGroup winningNumbers = InputView.enterWinningLotto();
//            LottoNo lottoNo = InputView.enterBonusBall();
//            LotteryCommission lotteryCommission = new LotteryCommission();
//            lotteryCommission.selectWinningNumbers(winningNumbers, lottoNo);
//            larry.checkTotalResult();
//            ResultView.printResult(larry);
//        } catch (LottoProcessException e) {
//            e.printStackTrace();
//            resultProcessConsole();
//        }
//    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static Map<String, Object> buyLottoInput(Request req) {
        int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
        String[] manualNumbers = req.queryParams("manualNumber").split("\r?\n");
        List<LottoNoGroup> manualInput = makeLottoNoGroup(manualNumbers);
        larry = User.nameOf(req.queryParams("userName"));
        larry.hasMoneyOf(inputMoney);
        larry.purchaseTicketsManual(manualInput);
        larry.purchaseTicketsAuto(inputMoney/ TICKET_PRICE - manualInput.size());
        System.out.println("TEMP LOG ===============" + larry.getLottos().toString());
        try {
            lottoDAO = new LottoDAO();
            lottoDAO.insertUserInfo(larry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Object> input = new HashMap<>();
        input.put("larry", larry);
        return input;
    }

    private static Map<String, Object> matchLottoResult(Request req) {
        LottoNo bonusNo = LottoNo.of(Integer.parseInt(req.queryParams("bonusNumber")));
        LotteryCommission lotteryCommission = new LotteryCommission();
        lotteryCommission.selectWinningNumbers(inputParser(req.queryParams("winningNumber")), bonusNo);
        try {
            lottoDAO.insertWinningLotto(lotteryCommission);
            larry.checkTotalResult(lotteryCommission);
            lottoDAO.updateUserInfo(larry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Object> result = new HashMap<>();
        result.put("larry", larry);
        return result;
    }

    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/template");
        get("/", (req, res) -> render(null, "index.html"));
        post("/buyLotto", (req, res) -> render(buyLottoInput(req), "show.html"));
        post("/matchLotto", (req, res) -> render(matchLottoResult(req), "result.html"));
    }
}
