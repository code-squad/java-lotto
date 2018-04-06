package saru;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

public class WebMain {
    public WebMain() {
        // empty
    }

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res)->
                new HandlebarsTemplateEngine().render(
                        new ModelAndView(null, "index.html")));

//        get("/helloworld", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("name", "pobi");
//            return render(model, "/helloworld.html");
//        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
