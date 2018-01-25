import domain.LottoFactory;
import domain.Lottos;
import dto.ResultDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    private static ResultDto resultDto;
    private static Lottos autoMakeLottos;

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            return render(null, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            int price = Utils.parseInt(req.queryParams("inputMoney"));
            String autoNumbers = req.queryParams("manualNumber");
            String[] autoNumberTexts = autoNumbers.split("\\r?\\n");
            int handCount = autoNumberTexts.length;
            Lottos handMakeLottos = new Lottos();
            Arrays.stream(autoNumberTexts).filter(number -> !number.isEmpty()).forEach(lottoNumber -> {
                handMakeLottos.add(LottoFactory.makeHandLotto(lottoNumber));
            });
            resultDto = new ResultDto(price, handCount, handMakeLottos);
            autoMakeLottos = LottoFactory.autoMakeLottos(resultDto.autoMakeLottoCount());
            Map<String, Object> model = new HashMap<>();
            model.put("count", handCount);
            model.put("autoLottos", autoMakeLottos.getLottos());

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            int bonusNumber = Utils.parseInt(req.queryParams("bonusNumber"));

            resultDto.checkLastWinningNumbers(winningNumber, bonusNumber, autoMakeLottos);
            Map<String, Object> model = new HashMap<>();
            model.put("revenue", resultDto.calRevenue());
            model.put("results", resultDto.getResults());
            return render(model, "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
