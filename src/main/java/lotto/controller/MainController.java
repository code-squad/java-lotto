package lotto.controller;

import lotto.InvalidInputException;
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

        int getPrice = 0;

        try {
            getPrice = ResultView.price(money);
        } catch (InvalidInputException e) {
            System.out.print(e.getMessage() + " ");
            money = InputView.money();
        }


        int manualNum = InputView.manualNum();

        try {
            manualNum = manualNumException(manualNum, getPrice);
        } catch (InvalidInputException e) {
            System.out.print(e.getMessage());
            manualNum = InputView.manualNum();
        }

        InputView.manualMessage();

        List<Lotto> manualLotto = LottoPlay.manualLottoObject(manualLottos(manualNum));

        List<Lotto> lottos = LottoPlay.lottoObject(getPrice, manualNum);


        ResultView.count(money, manualLotto.size());
        ResultView.lottoOutput(lottos, manualLotto);

        List<Integer> prize = SplitUtil.prizeList(InputView.prizeNum());
        int bonusNum = InputView.bonusNum();

        try {
            bonusNum = bonusNumException(bonusNum);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            bonusNum = InputView.bonusNum();
        }

        ResultView.prizeStatement();

        List<Integer> winnerMoneyList = MoneyCheck.getWinnerMoneyList();

        List<Rank> ranks = LottoPlay.ranks(winnerMoneyList);

        Grade grade = new Grade(lottos, manualLotto, prize, bonusNum);

        List<Integer> pageSize = MoneyCheck.grade(grade);
        long amount = MoneyCheck.profitRate(ranks, pageSize, getPrice);
        ResultView.prizeRank(pageSize, amount, ranks);
    }

    public static int bonusNumException(int bonus) throws InvalidInputException {
        if (bonus < 1 || bonus > 45) {
            throw new InvalidInputException("숫자가 잘못되었습니다. 범위 안에서 입력해주세요(1~45)");
        }
        return bonus;
    }

    public static int manualNumException(int manualNum, int getPrice) throws InvalidInputException {
        if (manualNum > getPrice) {
            throw new InvalidInputException("구매한 금액보다 Lotto 장수가 많습니다.");
        }
        return manualNum;
    }

    public static List<String> manualLottos(int manualNum) {
        List<String> manualLotto = new ArrayList<>();
        for (int i = 0; i < manualNum; i++) {
            manualLotto.add(InputView.manualLottoNum());
        }
        return manualLotto;
    }
}
