package money;

import rank.Check;
import rank.Decision;
import lotto.Lotto;

import java.util.List;

public class MoneyResult {
    public static void moneyResult(List<Lotto> lottos, String bonusNum, Check check) {
        Money money = new Money();
        Decision decision = new Decision();
        decision.addRank(check.getRight(), lottos, bonusNum);
        money.money(decision.decisionRank(lottos, check.getRight() , bonusNum));
    }
}
