import input.*;
import lotto.HandLotto;
import lotto.Lotto;
import rank.Check;
import view.ResultView;
<<<<<<< HEAD
import input.Handbuy;
import lotto.HandLotto;
import java.util.ArrayList;
=======
import java.util.List;
>>>>>>> 80e6998bd7808e35b79848303683d11e08a70492

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        int inputPrice = InputPrice.inputPrice();
        int handbuy = Handbuy.handBuy();
<<<<<<< HEAD
        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputPrice / 1000) - handbuy) + "개를 구매했습니다.");
        HandLotto hand = new HandLotto();
        ArrayList<lotto.Lotto> lottos = input.makeLottos(((inputPrice / 1000) - handbuy));
        hand.generateHandLotto(handbuy, lottos);

//        System.out.println((inputPrice / 1000) + "개를 구매했습니다.");
//        ArrayList<Lotto> lottos = input.makeLottos((inputPrice / 1000));
=======
        HandLotto hand = new HandLotto();
        List<Lotto> lottos = input.makeLottos(((inputPrice / 1000) - handbuy));
        hand.generateHandLotto(handbuy, lottos);
        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputPrice / 1000) - handbuy) + "개를 구매했습니다.");
>>>>>>> 80e6998bd7808e35b79848303683d11e08a70492
        Input.rightNumber();
        // check객체가 생성이되면서 right을 입력
        Check check = new Check();
        check.checking(lottos);

        String bonusNum = BonusNum.bonusNum();
        ResultView.result(lottos, bonusNum, check, inputPrice);
    }
}
