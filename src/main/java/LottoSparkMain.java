import domain.Lottos;
import domain.Rank;
import domain.WinnerLotto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoSparkMain {
    public static void main(String[] args) {
        port(8080);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Lottos> lottosMap = new HashMap<>();
        staticFiles.location("/static");


        post("/buyLotto", (req, res) -> {
            resultMap.clear();
            List<String> manualNumbers = new ArrayList<>(Arrays.asList(req.queryParams("manualNumber").split("\r?\n")));
            Lottos userLottos = Lottos.ofString(manualNumbers, req.queryParams("inputMoney"));
            lottosMap.put("lottos", userLottos);
            // lottosMap 생성 이유 resultMap은 lottos로 제내릭 선언을 안했더니 get을 하고 메서드를 호출 불가능
            resultMap.put("lottos", userLottos);
            resultMap.put("count", userLottos.getLottoryManager().count());

            return render(resultMap, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            List<String> winningNumber = new ArrayList<>(Arrays.asList(req.queryParams("winningNumber").split(",")));
            WinnerLotto winnerLotto = WinnerLotto.of(winningNumber, Integer.parseInt(req.queryParams("bonusNumber")));
            Lottos lottos = lottosMap.get("lottos");
            lottos.matchLotto(winnerLotto);

            List<String> result = Arrays.stream(Rank.values())
                    .sorted(Comparator.reverseOrder())
                    .map(value -> ResultView.result(value, lottos.getLottoryManager()))
                    .collect(Collectors.toList());

            resultMap.put("result", result);
            resultMap.put("yield", lottos.getLottoryManager().yield());
            return render(resultMap, "/result.html");
        });

    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
