//import domain.*;
//import domain.Number;
//import view.InputView;
//import view.ResultView;
//
//import java.util.List;
//
//public class Main {
//
//    private static Lottos inputLottos() {
//        try {
//            System.out.println("구입 금액을 입력해 주세요.");
//            int numLotto = LottoUtil.checkReturnNumLotto(InputView.inputNumber());
//            System.out.println(String.format("%d개를 구매했습니다.", numLotto));
//            return Lottos.initLottosAuto(numLotto);
//        } catch (RuntimeException e) {
//            return inputLottos();
//        }
//    }
//
//    private static Lotto initWinningLotto() {
//        try {
//            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//            List<Integer> answer = InputView.putAnswer();
//            System.out.println("보너스 볼을 입력해 주세요..");
//            return WinningLotto.of(answer, initBonusNumber());
//        } catch (RuntimeException e) {
//            return initWinningLotto();
//        }
//    }
//
//    private static Number initBonusNumber() {
//        try {
//            return Number.of(InputView.inputNumber());
//        } catch (RuntimeException e) {
//            return initBonusNumber();
//        }
//    }
//
//    public static void main(String[] args) {
//        Lottos lottos = inputLottos();
//        ResultView.printLottos(lottos);
//        Lotto winningLotto = initWinningLotto();
//        ResultView.printResult(lottos, winningLotto);
//    }
//
//}
