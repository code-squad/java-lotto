package lotto.lotto;

import static spark.Spark.*;
import lotto.lotto.domain.BuyingLotto;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.Rank;
import lotto.lotto.domain.WeeklyLotto;
import lotto.lotto.view.Input;
import lotto.lotto.view.View;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    public static void main(String[] args) {
        int money = Input.inputMoney();
        int manualNumber = Input.inputManualNumber();
        List<String> manualLotto = Input.inputManualLotto(manualNumber, money);

        BuyingLotto man = new BuyingLotto(money, manualLotto);
        List<Lotto> lottos = man.getLottos();

        View.lottoAutomaticView(lottos, manualNumber);
        String winningLotto = Input.inputWinningNumber();
        int bonusBall = Input.inputBonus();

        WeeklyLotto week = WeeklyLotto.of(winningLotto, bonusBall);
        Map<Rank, Integer> result = week.checkRank(lottos);

        View.resultLottoView(result);
        View.incomeMoney(result, money);
    }
}
