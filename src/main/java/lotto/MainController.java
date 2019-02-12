package lotto;

import lotto.domain.*;
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
        int money = InputView.money();
        int manualNum = InputView.manualNum();

        InputView.manualMessage();

        List<Lotto> manualLotto = LottoPlay.manualLottoObject(manualLottos(manualNum));

        List<Lotto> lottos = LottoPlay.lottoObject(ResultView.price(money), manualNum);
        ResultView.count(money, manualLotto.size());
        ResultView.lottoOutput(lottos, manualLotto);

        List<Integer> prize = SplitUtil.prizeList(InputView.prizeNum());
        int bonusNum = InputView.bonusNum();
        ResultView.prizeStatement();

        List<Rank> ranks = LottoPlay.ranks();

        Grade grade = new Grade(lottos, manualLotto, prize, bonusNum);

        List<Integer> pageSize = MoneyCheck.grade(grade);
        long amount = MoneyCheck.profitRate(ranks, pageSize, ResultView.price(money));
        ResultView.prizeRank(pageSize, amount);
    }

    public static List<String> manualLottos(int manualNum) {
        List<String> manualLotto = new ArrayList<>();
        for (int i = 0; i < manualNum; i++) {
            manualLotto.add(InputView.manualLottoNum());
        }
        return manualLotto;
    }
}
