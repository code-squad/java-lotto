package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.LottoUtil;
import lotto.util.MoneyUtil;
import lotto.util.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MainController {
    private static final Logger log = getLogger(MainController.class);

    public static void main(String[] args) {
        int money = InputView.money();
        List<Lotto> lottos = LottoUtil.lottoObject(ResultView.price(money));
        ResultView.count(money);

        ResultView.lottoOutput(lottos);
        List<Integer> prize = SplitUtil.prizeList(InputView.prizeNum());
        int bonusNum = InputView.bonusNum();
        ResultView.prizeStatement();

        List<Rank> ranks = LottoUtil.ranks();
        List<Integer> pageSize = MoneyUtil.grade(lottos, prize, bonusNum);

        int amount= MoneyUtil.profitRate(ranks, pageSize, ResultView.price(money));

        ResultView.prizeRank(pageSize, amount);
    }
}
