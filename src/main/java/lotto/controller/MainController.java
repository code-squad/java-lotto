package lotto.controller;

import lotto.InvalidInputException;
import lotto.WrongAmountException;
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
        int money = getMoney();
        int getPrice = ResultView.price(money);

        int manualNum = getManualNum(InputView.manualNum(), getPrice);


        InputView.manualMessage();

        List<Lotto> manualLotto = LottoPlay.manualLottoObject(manualLottos(manualNum));

        List<Lotto> lottos = LottoPlay.lottoObject(getPrice, manualNum);

        ResultView.count(money, manualLotto.size());
        ResultView.lottoOutput(lottos, manualLotto);

        List<Integer> prize = SplitUtil.prizeList(InputView.prizeNum());
        int bonusNum = getBonusNum(InputView.bonusNum());

        ResultView.prizeStatement();

        List<Integer> winnerMoneyList = MoneyCheck.getWinnerMoneyList();

        List<Rank> ranks = LottoPlay.ranks(winnerMoneyList);

        Grade grade = new Grade(lottos, manualLotto, prize, bonusNum);

        List<Integer> pageSize = MoneyCheck.grade(grade);
        long amount = MoneyCheck.profitRate(ranks, pageSize, getPrice);
        ResultView.prizeRank(pageSize, amount, ranks);
    }

    private static int getBonusNum(int bonusNum) {
        try {
            bonusNum = ExceptionCheck.bonusNumException(bonusNum);
        } catch (WrongAmountException e) {
            bonusNum = catchBonusNum(e);
            while (!ExceptionCheck.bonusNum(bonusNum)) {
                bonusNum = catchBonusNum(e);
            }
        }
        return bonusNum;
    }

    private static int catchBonusNum(WrongAmountException e) {
        int bonusNum;
        System.out.println(e.getMessage());
        bonusNum = InputView.bonusNum();
        return bonusNum;
    }

    private static int getManualNum(int manualNum, int getPrice) {
        try {
            manualNum = ExceptionCheck.manualNumException(manualNum, getPrice);
        } catch (InvalidInputException e) {

            manualNum = catchManualNum(e);
            while (!ExceptionCheck.manualNum(manualNum, getPrice)) {
                manualNum = catchManualNum(e);
            }
        }
        return manualNum;
    }

    private static int catchManualNum(InvalidInputException e) {
        int manualNum;
        System.out.print(e.getMessage());
        manualNum = InputView.manualNum();
        return manualNum;
    }

    private static int getMoney() {
        InputView.money();
        int money = InputView.moneyInput();
        try {
            money = ExceptionCheck.moneyNumException(money);
        } catch (InvalidInputException e) {
            money = catchMoney(e);
            while (!ExceptionCheck.money(money)) {
                money = catchMoney(e);
            }
        }
        return money;
    }

    private static int catchMoney(InvalidInputException e) {
        int money;
        System.out.println(e.getMessage());
        InputView.money();
        money = InputView.moneyInput();
        return money;
    }

    public static List<String> manualLottos(int manualNum) {
        List<String> manualLotto = new ArrayList<>();
        for (int i = 0; i < manualNum; i++) {
            manualLotto.add(InputView.manualLottoNum());
        }
        return manualLotto;
    }
}
