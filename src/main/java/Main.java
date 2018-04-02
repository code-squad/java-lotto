import input.*;
import lotto.HandLotto;
import lotto.Lotto;
import rank.Check;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.ResultView;
import input.Handbuy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String [] args) {
        port(8080);
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "jimmy");
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            List<Lotto> lottos = new ArrayList<>();
            Map<String, Object> model = new HashMap<>();
            model.put(req.queryParams("inputMoney"), "inputMoney");
            return render(model, "/show.html");
        });


        Input input = new Input();
        int inputMoney = InputPrice.inputPrice();
        int handbuy = Handbuy.handBuy();
        HandLotto hand = new HandLotto();
        List<Lotto> lottos = input.makeLottos(((inputMoney / 1000) - handbuy));
        hand.generateHandLotto(handbuy, lottos);
        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputMoney / 1000) - handbuy) + "개를 구매했습니다.");
        Input.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        String bonusNum = BonusNum.bonusNum();
        ResultView.result(lottos, bonusNum, check, inputMoney);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
