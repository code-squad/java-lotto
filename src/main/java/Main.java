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

import static domain.LottoUtils.*;
import static spark.Spark.*;

public class Main {

    static User user;
    static LottoDAO lottoDAO;

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static Map<String, Object> buyLottoInput(Request req) {
        try {
            lottoDAO = new LottoDAO();
            lottoDAO.insertUserInfo(initUser(req), req.queryParams("round"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Object> input = new HashMap<>();
        input.put("user", user);
        return input;
    }

    private static Map<String, Object> matchLottoResult(Request req) {
        LottoNo bonusNo = LottoNo.of(Integer.parseInt(req.queryParams("bonusNumber")));
        LotteryCommission lotteryCommission = new LotteryCommission();
        lotteryCommission.selectWinningNumbers(inputParser(req.queryParams("winningNumber")), bonusNo);
        try {
            lottoDAO.insertWinningLotto(lotteryCommission);
            user.checkTotalResult(lotteryCommission);
            lottoDAO.updateUserInfo(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
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
