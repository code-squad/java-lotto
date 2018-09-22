package lotto.controller;

import lotto.view.WebView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {


    public static void main(String[] args) {
        port(8080);

        WebView webView = new WebView();

        get("/", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return webView.render(model, "/index.html");
        });

        post("/buyLotto", (req, res)->{
            String inputMoney = req.queryParams("inputMoney");
            String inputManualNumber = req.queryParams("manualNumber");

            String[] manualNumbers = inputManualNumber.split("\n" );

            Map<String, Object> model = new HashMap<>();

            return webView.render(model, "/show.html");
        });

        post("/matchLotto", (req, res)->{

            Map<String, Object> model = new HashMap<>();

            return webView.render(model, "/result.html");
        });


    }
}
