package control;

import domain.*;
import dto.LottoDto;
import dto.ResultDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.InputView;
import view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.Money.LOTTO_PRICE;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;


public class Main {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/templates");

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Money money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
            LottoMachine lottoMachine = new ManualLottoMachine(req.queryParams("manualNumber"));
            LottoDto lottoDto = new LottoGame().generateLottos(money, lottoMachine);
            model.put("size", lottoDto);
            model.put("lottoDto", lottoDto.getLottos());
            return render(model, "show.html"); // 전달할 곳
        });
//        post("/matchLotto", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            Money money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
//            LottoMachine lottoMachine = new ManualLottoMachine(req.queryParams("manualNumber"));
//            LottoDto lottoDto = new LottoGame().generateLottos(money, lottoMachine);
//            model.put("lottoDto", lottoDto);
//            return render(model, "result.html"); // 전달할 곳
//        });


//        int lottoTicketCount = LottoTicketControl.getLottoTicketCount();
//        int manualLottoTicketCount = LottoTicketControl.getManualLottoTicketCount(lottoTicketCount);
//
//        ResultView.printKindsOfLottosCount(lottoTicketCount, manualLottoTicketCount);
//        ResultView.showLottos(lottoDto);
//
//        GameResult gameResult = lottoGame.checkLottos(WinningLottoControl.getWinningLotto(), lottoDto);
//        int profitRate = gameResult.calculateProfitRate((double) (lottoTicketCount * LOTTO_PRICE));
//        ResultView.showLottoResult(new ResultDto(gameResult.getGameResult(), profitRate));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
