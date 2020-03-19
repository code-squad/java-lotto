package application;

import controller.LottoController;
import service.LottoService;

import static spark.Spark.port;

public class WebApplication {
    public static void main(String[] args) {
        port(8080);
        new LottoController(new LottoService());
    }
}
