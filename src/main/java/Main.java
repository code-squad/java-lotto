import input.BonusNum;
import input.Input;
import input.InputPrice;
import lotto.Lotto;
import money.Money;
import rank.Check;
import rank.Decision;
import view.ResultView;
import input.Handbuy;
import lotto.HandLotto;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        int inputPrice = InputPrice.inputPrice();
        int handbuy = Handbuy.handBuy();
        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputPrice / 1000) - handbuy) + "개를 구매했습니다.");
        HandLotto hand = new HandLotto();
        ArrayList<lotto.Lotto> lottos = input.makeLottos(((inputPrice / 1000) - handbuy));
        hand.generateHandLotto(handbuy, lottos);

//        System.out.println((inputPrice / 1000) + "개를 구매했습니다.");
//        ArrayList<Lotto> lottos = input.makeLottos((inputPrice / 1000));
        Input.rightNumber();
        // check객체가 생성이되면서 right을 입력
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
