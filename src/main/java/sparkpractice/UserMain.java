package sparkpractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class UserMain {
    public static void main(String[] args) {
        port(8080);
//        get("/helloworld/:name" +
//                "", (req,res) -> {
//            return "Hello World" + req.params(":name");
//        });
//        staticFileLocation("/static");
//        List<LottoSpark> users = new ArrayList<>();
//        post("/users", (req, res) -> {
//            LottoSpark user = new LottoSpark();
//            user.setName(req.queryParams("name"));
//            user.setAge(req.queryParams("age"));
//            users.add(user);
//            Map<String, Object> model = new HashMap<>();
//            model.put("users", users);
//
//            return render(model, "login.html");
//        });

        List<LottoSpark> lottoSparks = new ArrayList<>();
        get("/users", (req, res) -> {
            LottoSpark user = new LottoSpark();
            user.setInputMoney(req.queryParams("inputMoney"));
            user.setManualNumber(req.queryParams("manualNumber"));
            lottoSparks.add(user);
            Map<String, Object> model = new HashMap<>();
            model.put("lotto", lottoSparks);

            return render(model, "index.html");
        });

//        post("/buyLotto",(req,res) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("users", 4);
//            return render(model, "show.html");
//        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
