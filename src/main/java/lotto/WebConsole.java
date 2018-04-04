package lotto;

import lotto.domain.Ticket;
import lotto.view.AutoGenerator;
import lotto.view.ManualGenerator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebConsole {

    public static void main(String[] args) {
        port(8080);

        post("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("inputMoney", req.queryParams("inputMoney"));
            model.put("manualNumber", req.queryParams("manualNumber"));
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }


}
