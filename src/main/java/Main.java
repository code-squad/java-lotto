import input.*;
import lotto.HandLotto;
import lotto.Lotto;
import rank.Check;
import view.ResultView;
import input.Handbuy;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        InputUI inputUI = new InputUI();
        int inputMoney = InputPrice.inputPrice();
        int handbuy = Handbuy.handBuy();
        HandLotto hand = new HandLotto();
        InputCommon input = new InputCommon();
        List<Lotto> lottos = input.makeLottos(((inputMoney / 1000) - handbuy));
        hand.generateHandLotto(handbuy, lottos);
        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputMoney / 1000) - handbuy) + "개를 구매했습니다.");
        InputUI.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        String bonusNum = BonusNum.bonusNum();
        ResultView.result(lottos, bonusNum, check, inputMoney);
    }
}
