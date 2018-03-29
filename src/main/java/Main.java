import domain.Lottos;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int numLotto = InputView.buyLotto();
        System.out.println(String.format("%d개를 구매했습니다.", numLotto));
        Lottos lottos = Lottos.initLottosAuto(numLotto);
        ResultView.printLottos(lottos);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> answer = InputView.putAnswer();
        ResultView.printResult(lottos, answer);
    }
}
