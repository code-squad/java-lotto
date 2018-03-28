import input.BonusNum;
import input.Input;
import input.InputPrice;
import input.Handbuy;
import lotto.HandLotto;
import money.Money;
import rank.Check;
import rank.Decision;
import view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        int inputPrice = InputPrice.inputPrice();
        int handbuy = Handbuy.handBuy();
        HandLotto hand = new HandLotto();
        ArrayList<lotto.Lotto> lottos = input.makeLottos(((inputPrice / 1000) - handbuy));
        hand.generateHandLotto(handbuy, lottos);
        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputPrice / 1000) - handbuy) + "개를 구매했습니다.");
        Input.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        String bonusNum = BonusNum.bonusNum();
        Input.rightResult();
        Money money = new Money();
        Decision decision = new Decision();
        decision.addRank(check.getRight(), lottos, bonusNum);
        money.money(decision.decisionRank(lottos, check.getRight() , bonusNum));
        ResultView.printCount(money.finalCount);
        ResultView.printResult(lottos, bonusNum, inputPrice, check.getRight());
    }
}
