package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.LottoUtil;
import lotto.util.RankUtil;
import lotto.util.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MainController {

    private static final Logger log = getLogger(MainController.class);

    public static void main(String[] args) {

        RankUtil rankUtil = new RankUtil();
        LottoUtil lottoUtil = new LottoUtil();

        int money = InputView.money();
        List<Lotto> lottos = lottoUtil.lottoObject(ResultView.price(money));
        ResultView.count(money);

        ResultView.lottoOutput(lottos);
        List<Integer> prize = SplitUtil.prizeList(InputView.prizeNum());
        ResultView.prizeStatement();

        List<Integer> prizePageSize = rankUtil.pageMoney(lottos, prize);

        System.out.println(prizePageSize);

        List<Integer> pageMoney = rankUtil.pageMoney(lottos, prize);

        double amount = rankUtil.amount(pageMoney, money);


        ResultView.prizeRank(prizePageSize, amount);


    }
}
