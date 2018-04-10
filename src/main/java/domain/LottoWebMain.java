package domain;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.ResultView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoWebMain {

    private static int payment = 0;

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        Map<String, Object> inputStorage = new HashMap<>();
        port(8080);

        get("/", (request, response) -> {
            // 로또 머신
            lottoMachine.init();
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (request, response) -> {
            payment = Integer.parseInt(request.queryParams("inputMoney"));
            int totalCount = LottoMachine.getTotalCount(payment);
            inputStorage.put("totalCount", totalCount);
            int manualCount = 0;

            List<String> manualNumbers = convertToList(request.queryParams("manualNumber"));

            if (manualNumbers != null) {
                manualCount = manualNumbers.size();
            }
            lottoMachine.createManualTickets(manualNumbers);
            lottoMachine.createAutoTickets(LottoMachine.getAutoCount(totalCount, manualCount));
            LottoDAO lottoDAO = LottoDAO.getInstance();
            inputStorage.put("numbers", lottoDAO.selectNumbers(totalCount));

            ResultView.printAutoManualCount(totalCount, manualCount);
            return render(inputStorage, "show.html");
        });

        post("/matchLotto", (request, response) -> {
            String winningNumber = request.queryParams("winningNumber");
            String bonusNumber = request.queryParams("bonusNumber");
            Result result = lottoMachine.matching(winningNumber, bonusNumber, payment);
            inputStorage.put("result", result);
            return render(inputStorage, "result.html");
        });
    }

    private static List<String> convertToList(String inputManualNumber) {
        List<String> manualNumber = Arrays.asList(inputManualNumber.split("\\r?\\n"));
        if (manualNumber.get(0).equals("")) {
            return null;
        }
        return manualNumber;
    }
}