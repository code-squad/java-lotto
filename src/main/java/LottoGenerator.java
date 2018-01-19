import dto.LottoResult;
import model.Customer;
import model.HandOperatedLotto;
import model.Lotto;
import model.Rank;
import model.StringUtil;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class LottoGenerator {
    private static Customer customer = new Customer();

    public static void main(String[] args) {
        port(8080);

        staticFiles.location("/templates");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model,"/index.html");
        });

        post("/buyLotto", (req, res) ->{
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            String[] lottoNumbers = StringUtil.removeLineBreaker(manualNumber);
            HandOperatedLotto handOperatedLotto = new HandOperatedLotto(lottoNumbers.length, lottoNumbers);
            Integer amount = Integer.valueOf(inputMoney);

            List<Lotto> lottos = customer.buy(amount, handOperatedLotto);
            List<Integer> nos = new ArrayList();
            generateNos(lottos, nos);

            Map<String, Object> model = new HashMap<>();
            model.put("printBuyWhat", "수동으로 " + lottoNumbers.length + "장, 자동으로 " + (lottos.size() - lottoNumbers.length) + "개를 구매했습니다.");
            model.put("lottos", lottos);
            model.put("nos", nos);

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res)->{
            String winningNumber = req.queryParams("winningNumber");
            Integer bonus = Integer.valueOf(req.queryParams("bonusNumber"));

            LottoResult lottoResult = customer.getLottoResult(winningNumber, bonus);
            Set<Map.Entry<Rank,Integer>> result = lottoResult.getLottoResult().entrySet();


            Map<String, Object> model = new HashMap<>();
            model.put("result", result);
            model.put("index", 1);
            model.put("percentage", lottoResult.getPercentage());
            return render(model, "/result.html");
        });

    }

    private static void generateNos(List<Lotto> lottos, List<Integer> nos) {
        for (int i = 0; i < lottos.size(); i++) {
            nos.add(i);
        }
    }


    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}