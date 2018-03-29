import domain.LottoUtil;
import domain.Lottos;
import view.InputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int money = InputView.putMoney();
        int numLotto = LottoUtil.getNumOfLotto(money);
        Lottos lottos = new Lottos();
        lottos.initAutoLottos(numLotto);
        List<Integer> answer = InputView.putAnswer();
        lottos.getResult(answer);
    }

}
