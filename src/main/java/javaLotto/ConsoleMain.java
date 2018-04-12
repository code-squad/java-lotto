package javaLotto;

import javaLotto.domain.Grade;
import javaLotto.domain.JavaLotto;
import javaLotto.domain.Lotto;
import javaLotto.domain.WinningNumber;
import javaLotto.view.InputView;
import javaLotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) throws Exception {
        /*피드백
         * 1.convention 위반 상수는 대문자.
         * 2.number subList로 구현
         * 3.test 코드 List result = Arrays.asList(3, 3); 로 구현 변경
         * 4.List<LottoTicket>  구현
         * 5.return winningNumber.match(lotto) 객체에 메시지 보내기 구현
         * 6.GameResult 구현
         *
         *   7.사용자가 구매한 로또 한장을 LottoTicket과 같은 객체로 추상화해 List과 같은 구조로 구현
         * */
        int price = Integer.parseInt(InputView.setPrice());
        Lotto lotto = JavaLotto.buyLotto(price);
        ResultView.buyLottoInfoPrint(lotto);

        String winningNumber = InputView.setWinningNumber();
        GameResult result = Grade.checkGrade(lotto, new WinningNumber(winningNumber));
        ResultView.resultPrint(result, price);
    }
}
