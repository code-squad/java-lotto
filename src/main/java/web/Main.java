package web;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoSeller;
import domain.Lottos;
import domain.WinningLottos;
import domain.WinningNumbers;
import dto.WinningResults;
import org.apache.commons.lang3.StringUtils;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static view.InputView.removeWhiteSpace;
import static view.InputView.splitInput;
import static view.InputView.toIntArray;

public class Main {
    private final static String LOTTOS = "LOTTOS";

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(Collections.emptyMap(), "/index.html"));

        post("/buyLotto", (req, res) -> {
            int purchaseAmount = Integer.valueOf(req.queryParams("inputMoney"));
            Optional<Lottos> manualLottos = getManualLottos(req.queryParams("manualNumber"));

            LottoSeller lottoSeller = new LottoSeller();
            Lottos lottos = lottoSeller.buyRandomLottosWithManualLottos(purchaseAmount, manualLottos.orElse(null));

            req.session().attribute(LOTTOS, lottos);

            Map<String, Object> params = new HashMap<>();
            params.put("count", lottos.size());
            params.put("lottos", lottos);

            return render(params, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            WinningNumbers winningNumbers = getWinningNumber(req.queryParams("winningNumber"),
                                                             req.queryParams("bonusNumber"));

            Lottos lottos = req.session().attribute(LOTTOS);

            WinningLottos winningLottos = lottos.match(winningNumbers);
            WinningResults results = new WinningResults(winningLottos);

            return render(Collections.singletonMap("winningResults", results), "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static Optional<Lottos> getManualLottos(String manualNumber) {
        if (StringUtils.isEmpty(manualNumber)) {
            return Optional.empty();
        }
        String[] inputs = StringUtils.split(manualNumber, "\n");
        return Optional.of(new Lottos(convertStringArrayToLottos(inputs)));
    }

    private static List<Lotto> convertStringArrayToLottos(String[] strings) {
        return Arrays.stream(strings)
                     .map(str -> new Lotto(convertStringToIntArray(str)))
                     .collect(Collectors.toList());
    }

    private static int[] convertStringToIntArray(String input) {
        return toIntArray(removeWhiteSpace(splitInput(input)));
    }

    private static WinningNumbers getWinningNumber(String winningNumber, String bonusNumber) {
        return new WinningNumbers(new Lotto(toIntArray(removeWhiteSpace(splitInput(winningNumber)))),
                                  new LottoNumber(Integer.valueOf(bonusNumber)));
    }

}
